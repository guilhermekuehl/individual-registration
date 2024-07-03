package br.com.guilhermekellermann.individual_registration.modules.person;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class PersonEntity {
    
    private UUID id;
    private String name;

    @Length(min = 8, max = 11)
    private String phoneNumber;

    @Length(min = 11, max = 11, message = "CPF inválido")
    private String CPF;
    private String address;
    private String complement;
    private String CEP;
    private String district;
    private String cityName;
    private String state;
}
