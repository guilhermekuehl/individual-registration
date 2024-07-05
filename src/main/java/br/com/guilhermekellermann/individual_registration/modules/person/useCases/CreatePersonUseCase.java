package br.com.guilhermekellermann.individual_registration.modules.person.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilhermekellermann.individual_registration.modules.person.PersonEntity;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;
import br.com.guilhermekellermann.individual_registration.modules.person.exceptions.PersonFoundException;

@Service
public class CreatePersonUseCase {
    
    @Autowired
    private PersonRepository personRepository;

    public PersonEntity execute(PersonEntity personEntity) {
        this.personRepository
        .findByCPF(personEntity.getCPF())
        .ifPresent((person) -> {
            throw new PersonFoundException();
        });

        return this.personRepository.save(personEntity);

    }
}
