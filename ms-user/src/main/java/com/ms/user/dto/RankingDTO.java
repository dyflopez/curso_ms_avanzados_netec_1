package com.ms.user.dto;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingDTO {

    private String id;

    private  String userId;

    private String hotelId;

    private String observation;

    private HotelDTO hotelDTO;
}
