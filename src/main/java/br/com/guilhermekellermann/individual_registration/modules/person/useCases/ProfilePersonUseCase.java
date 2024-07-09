package br.com.guilhermekellermann.individual_registration.modules.person.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilhermekellermann.individual_registration.modules.exceptions.PersonNotFoundException;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;
import br.com.guilhermekellermann.individual_registration.modules.person.dto.ProfilePersonResponseDTO;

@Service
public class ProfilePersonUseCase {
    
    @Autowired
    private PersonRepository personRepository;

    public ProfilePersonResponseDTO execute(String cpfPerson) {
        var person = this.personRepository.findById(cpfPerson)
        .orElseThrow(() -> {
            throw new PersonNotFoundException();
        });

        var personDTO = ProfilePersonResponseDTO.builder()
            .address(person.getAddress())
            .cep(person.getCep())
            .cityName(person.getCityName())
            .complement(person.getComplement())
            .cpf(person.getCpf())
            .district(person.getDistrict())
            .name(person.getName())
            .phoneNumber(person.getPhoneNumber())
            .state(person.getState())
            .build();

        return personDTO;
    }
}
