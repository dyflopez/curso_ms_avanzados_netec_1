package com.ms.hotel.controller.v1;


import com.ms.hotel.controller.v1.docs.HotelDoc;
import com.ms.hotel.dto.HotelDTO;
import com.ms.hotel.model.HotelEntity;
import com.ms.hotel.service.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/hotel")
public class HotelController implements HotelDoc {

    private  final IHotelService iHotelService;

    @Override
    @PostMapping
    public ResponseEntity create(HotelDTO hotelDTO) {
        return this.iHotelService.create(hotelDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity getAll() {
        return this.iHotelService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity getById(UUID id) {
        return this.iHotelService.findById(id);
    }
}
