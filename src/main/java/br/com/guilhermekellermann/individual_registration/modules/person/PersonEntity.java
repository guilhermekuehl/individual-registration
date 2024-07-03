package br.com.guilhermekellermann.individual_registration.modules.person;

import java.util.UUID;

import lombok.Data;

@Data
public class PersonEntity {
    
    private UUID id;
    private String name;
    private String phoneNumber;
    private String CPF;
    private String address;
    private String complement;
    private String CEP;
    private String district;
    private String cityName;
    private String state;
}
