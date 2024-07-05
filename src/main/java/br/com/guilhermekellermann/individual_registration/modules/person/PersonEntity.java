package br.com.guilhermekellermann.individual_registration.modules.person;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "person")
public class PersonEntity {
    
    private String name;

    @Length(min = 8, max = 11, message = "Telefone inválido")
    private String phoneNumber;

    @Length(min = 11, max = 11, message = "CPF inválido")
    @Id
    private String CPF;
    private String address;
    private String complement;
    private String CEP;
    private String district;
    private String cityName;
    private String state;
}
