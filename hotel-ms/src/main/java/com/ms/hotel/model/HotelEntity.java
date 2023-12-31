package com.ms.hotel.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",updatable = false,nullable = false)
    private UUID id ;

    @NotEmpty
    private String name ;

    @NotEmpty
    private String location ;

    @NotEmpty
    private String information ;



}
