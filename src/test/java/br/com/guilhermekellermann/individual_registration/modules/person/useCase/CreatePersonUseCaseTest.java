package br.com.guilhermekellermann.individual_registration.modules.person.useCase;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.com.guilhermekellermann.individual_registration.modules.exceptions.PersonFoundException;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonEntity;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;
import br.com.guilhermekellermann.individual_registration.modules.person.useCases.CreatePersonUseCase;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class CreatePersonUseCaseTest {

    @Autowired
    private CreatePersonUseCase createPersonUseCase;

    @Autowired
    private PersonRepository personRepository;

    @Test()
    @DisplayName("should not be able to create a person with person found")
    public void should_not_be_able_to_create_a_person_with_person_found() {
        var cpf = "10452148928";

        var person1 = new PersonEntity();
        person1.setCpf(cpf);
        personRepository.save(person1);
        var samePerson = new PersonEntity();
        samePerson.setCpf(cpf);

        try {
            createPersonUseCase.execute(samePerson);
        } catch (Exception e) {
            assertInstanceOf(PersonFoundException.class, e);
        }
    }

    @Test
    @DisplayName("Should return a person entity when save")
    public void should_return_a_person_entity_when_save() {
        var cpf = "33547940036";

        var person = new PersonEntity();
        person.setCpf(cpf);

        var personCreated = createPersonUseCase.execute(person);
        assertInstanceOf(PersonEntity.class, personCreated);
        assertNotNull(personCreated.getCpf());
    }
}