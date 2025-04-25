package com.nttdata.prueba.back.dto;

import lombok.Data;

@Data
public class ClientDTO {

    private String identificationNumber;
    private String documentType;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String cityOfResidence;
}
