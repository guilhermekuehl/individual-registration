package br.com.guilhermekellermann.individual_registration.modules.person.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilhermekellermann.individual_registration.modules.exceptions.PersonNotFoundException;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonEntity;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;

@Service
public class ProfilePersonUseCase {
    
    @Autowired
    private PersonRepository personRepository;

    public List<PersonEntity> execute() {
        if (this.personRepository.count() == 0) {
            throw new PersonNotFoundException();
        }

        var people = this.personRepository.findAll();

        return people;
    }
}
