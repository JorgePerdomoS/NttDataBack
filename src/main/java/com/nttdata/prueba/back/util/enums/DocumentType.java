package com.nttdata.prueba.back.util.enums;

import lombok.Getter;

@Getter
public enum DocumentType {

    C("Cédula"),
    P("Passport");

    private final String description;

    DocumentType(String description) {
        this.description = description;
    }
}

