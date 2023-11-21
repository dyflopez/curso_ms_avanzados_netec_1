package com.ms.hotel.service;

import com.ms.hotel.dto.HotelDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IHotelService {

    ResponseEntity findAll ();

    ResponseEntity create(HotelDTO hotelDTO);

    ResponseEntity findById(UUID id);
}
