package com.ms.hotel.mapper;

import com.ms.hotel.dto.HotelDTO;
import com.ms.hotel.model.HotelEntity;
public class HotelMapper {

    public static HotelEntity mappingHotelDtoToHotelEntity(HotelDTO hotelDTO){
        return HotelEntity
                .builder()
                .information(hotelDTO.getInformation())
                .location(hotelDTO.getLocation())
                .name(hotelDTO.getName())
                .build();
    }
}
