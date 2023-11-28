package com.ms.user.service.impl;


import com.ms.user.config.HotelServiceFeing;
import com.ms.user.dto.*;
import com.ms.user.exception.MyHandleException;
import com.ms.user.mapper.UserMapper;
import com.ms.user.model.UserEntity;
import com.ms.user.producer.IEmailProduce;
import com.ms.user.repository.UserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ServiceImpl implements IUserService {


    private final RestTemplate restTemplate;

    private  final UserRepository userRepository;

    private final HotelServiceFeing hotelServiceFeing;

    private IEmailProduce iEmailProduce;
    @Override
    public ResponseEntity create(UserDTO userDTO) {

        String uuid = UUID.randomUUID().toString();

        UserEntity newUser = UserMapper.getUserDtoToUserEntity(userDTO);
        newUser.setId(uuid);
        var user = this.userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @Override
    public ResponseEntity getAll() {
        var user=  this.userRepository.findAll();
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity getById(String id) {
        var user=  this
                .userRepository
                .findById(id)
                .orElseThrow(  () -> new MyHandleException("User does not exist"));

        var response = this.getInformationWithOpenFeingAndRestTemplate(user);


        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    private UserRankingsDTO getInformationWithOpenFeingAndRestTemplate(UserEntity user)
    {

        UserRankingsDTO userRankingsDTO = new UserRankingsDTO();

        userRankingsDTO.setName(user.getName());
        userRankingsDTO.setEmail(user.getEmail());
        userRankingsDTO.setInformation(user.getInformation());
        userRankingsDTO.setDocument(user.getDocument());

        RankingDTO[] rankingsResponse =  this
                .restTemplate
                .getForObject("http://MS-RANKING/rankings/user/"+user.getId(), RankingDTO[].class);

        var rankings = Arrays.stream(rankingsResponse).collect(Collectors.toList());


        rankings
                .stream()
                .map(
                        ranking ->{
                            var hotel =this.hotelServiceFeing.getHotel(ranking.getHotelId());

                            ranking.setHotelDTO(hotel);
                            return ranking;
                        }
                ).collect(Collectors.toList());



        userRankingsDTO.setRankings(rankings);

        var  email  = JmsEmailDetails
                .builder()
                .name(user.getName())
                .recipient(user.getEmail())
                .emailType("welcome")
                .build();
        iEmailProduce.GenerateTransactionEmail(email);
        return userRankingsDTO;
    }

    private UserRankingsDTO getWithRestTemplate(UserEntity user){
        UserRankingsDTO userRankingsDTO = new UserRankingsDTO();

        userRankingsDTO.setName(user.getName());
        userRankingsDTO.setEmail(user.getEmail());
        userRankingsDTO.setInformation(user.getInformation());
        userRankingsDTO.setDocument(user.getDocument());

        RankingDTO[] rankingsResponse =  this
                .restTemplate
                .getForObject("http://MS-RANKING/rankings/user/"+user.getId(), RankingDTO[].class);

        var rankings = Arrays.stream(rankingsResponse).collect(Collectors.toList());


        rankings
                .stream()
                .map(
                        ranking ->{
                            ResponseEntity<HotelDTO> hotelResponse =
                                    this
                                            .restTemplate
                                            .getForEntity("http://MS-HOTEL/hotel/"+ranking.getHotelId(), HotelDTO.class);
                            var hotel = hotelResponse.getBody();
                            ranking.setHotelDTO(hotel);

                            return ranking;
                        }
                ).collect(Collectors.toList());


        userRankingsDTO.setRankings(rankings);
        return userRankingsDTO;
    }
}
