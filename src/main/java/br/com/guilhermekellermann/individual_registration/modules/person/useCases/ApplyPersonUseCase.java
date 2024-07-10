package br.com.guilhermekellermann.individual_registration.modules.person.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.guilhermekellermann.individual_registration.modules.exceptions.PersonFoundException;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;

public class ApplyPersonUseCase {
    
    @Autowired
    private PersonRepository personRepository;

    public void execute(String cpf) {
        this.personRepository.findByCpf(cpf)
            .orElseThrow(() -> {
                throw new PersonFoundException();
        });
    }
}
