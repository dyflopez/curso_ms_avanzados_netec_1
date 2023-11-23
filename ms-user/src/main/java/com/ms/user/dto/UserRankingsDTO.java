package com.ms.user.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRankingsDTO {

    private  String document;

    private String name ;

    private String email ;

    private String information;

    private List<RankingDTO> rankings;

}
