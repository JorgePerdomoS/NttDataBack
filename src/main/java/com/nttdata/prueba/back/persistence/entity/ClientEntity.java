package com.nttdata.prueba.back.persistence.entity;

import com.nttdata.prueba.back.util.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(unique = true, nullable = false, name = "identification_number")
    private String identificationNumber;
    @Column(nullable = false, name = "document_type")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "first_last_name")
    private String firstLastName;
    @Column(name = "second_last_name")
    private String secondLastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column
    private String address;
    @Column(name = "city_of_residence")
    private String cityOfResidence;
}
