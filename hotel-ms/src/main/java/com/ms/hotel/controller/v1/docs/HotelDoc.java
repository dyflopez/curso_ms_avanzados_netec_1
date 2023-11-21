package com.ms.hotel.controller.v1.docs;


import com.ms.hotel.dto.HotelDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "hotel Controller" ,description = "API EXPOSED FOR CRUD operations on hotel")
public interface HotelDoc {

    @Operation(summary ="create hotel"  ,
            description = "This operation is for creating hotel")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode ="201" ,
                    description =  "hotel created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode ="400" ,
                    description =  "bad request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity create (@Valid @RequestBody HotelDTO hotelDTO);


    @Operation(summary ="List hotels"  ,
            description = "this operation is for getting all hotel")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode ="200" ,
                    description =  "list of hotel generate succesfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode ="400" ,
                    description =  "bad request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getAll();

    @Operation(summary ="get hotel by Id"  ,
            description = "this operation is for getting a hotel by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode ="200" ,
                    description =  "getting hotel generate succesfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode ="400" ,
                    description =  "bad request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getById(UUID id);

}
