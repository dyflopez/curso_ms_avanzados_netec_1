package com.ms.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    @NotEmpty
    private String name ;

    @NotEmpty
    private String location ;

    @NotEmpty
    private String information ;
}
