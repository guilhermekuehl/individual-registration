package br.com.guilhermekellermann.individual_registration.modules.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePersonResponseDTO {
    
    private String name;
    private String phoneNumber;
    private String cpf;
    private String address;
    private String complement;
    private String cep;
    private String district;
    private String cityName;
    private String state;
}
