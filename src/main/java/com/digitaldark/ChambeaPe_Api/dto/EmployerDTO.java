package com.digitaldark.ChambeaPe_Api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDTO {

    //Atributes from UserEntity

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private byte hasPremium;

    private String profilePic;

    private byte isActive;

    private String description;

}
