package br.com.guilhermekellermann.individual_registration.modules.person.useCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.com.guilhermekellermann.individual_registration.modules.exceptions.PersonNotFoundException;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonEntity;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;
import br.com.guilhermekellermann.individual_registration.modules.person.useCases.ProfilePersonUseCase;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class ProfilePersonUseCaseTest {
    
    @Autowired
    private ProfilePersonUseCase profilePersonUseCase;

    @Autowired
    private PersonRepository personRepository;

    @Test
    @DisplayName("Should not found a person with person not found")
    public void should_not_found_a_person_with_person_not_found() {
        personRepository.deleteAll();
        try {
            profilePersonUseCase.execute();
        } catch (Exception e) {
            assertInstanceOf(PersonNotFoundException.class, e);
        }
    }

    @Test
    @DisplayName("Should return a list of person")
    public void should_return_a_list_of_person() {
        personRepository.deleteAll();

        var cpf1 = "33547940036";
        var cpf2 = "40213359006";
        var cpf3 = "28621839032";

        var person1 = new PersonEntity();
        person1.setCpf(cpf1);
        personRepository.save(person1);

        var person2 = new PersonEntity();
        person2.setCpf(cpf2);
        personRepository.save(person2);

        var person3 = new PersonEntity();
        person3.setCpf(cpf3);
        personRepository.save(person3);

        List<PersonEntity> pessoasRetornadas = profilePersonUseCase.execute();

        assertNotNull(pessoasRetornadas);
        assertEquals(3, pessoasRetornadas.size());
    }
}
