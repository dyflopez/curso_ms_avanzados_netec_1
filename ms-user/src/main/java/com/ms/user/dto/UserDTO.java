package com.ms.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String document;

    private String name;

    private String email;

    private String information;

}
