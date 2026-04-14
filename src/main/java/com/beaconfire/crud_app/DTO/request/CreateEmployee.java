package com.beaconfire.crud_app.DTO.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateEmployee {
    @NotBlank(message="firstname cannot be blank")
    private String firstname;

    @NotBlank(message="lastname cannot be blank")
    private String lastname;
}
