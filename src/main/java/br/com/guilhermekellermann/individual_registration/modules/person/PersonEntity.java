package br.com.guilhermekellermann.individual_registration.modules.person;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "person")
public class PersonEntity {
    
    private String name;

    @Length(min = 8, max = 11, message = "Telefone inválido")
    @Pattern(regexp = "\\S+", message = "O campo [phoneNumber] não deve conter espaço")
    private String phoneNumber;

    @Id
    @CPF
    private String cpf;
    private String address;
    private String complement;
    private String cep;
    private String district;
    private String cityName;
    private String state;
}
