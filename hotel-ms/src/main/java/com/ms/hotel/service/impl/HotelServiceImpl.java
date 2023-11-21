package com.ms.hotel.service.impl;

import com.ms.hotel.dto.HotelDTO;
import com.ms.hotel.mapper.HotelMapper;
import com.ms.hotel.model.HotelEntity;
import com.ms.hotel.repository.HotelRepository;
import com.ms.hotel.service.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements IHotelService {

    private final HotelRepository hotelRepository;
    @Override
    public ResponseEntity findAll() {
        var hotelList = this.hotelRepository.findAll();
        return ResponseEntity.ok(hotelList);
    }

    @Override
    public ResponseEntity create(HotelDTO hotelDTO) {

        HotelEntity hotel = HotelMapper.mappingHotelDtoToHotelEntity(hotelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @Override
    public ResponseEntity findById(UUID id) {
        var hotel = this.hotelRepository.findById(id);
        return ResponseEntity.ok(hotel);
    }
}
