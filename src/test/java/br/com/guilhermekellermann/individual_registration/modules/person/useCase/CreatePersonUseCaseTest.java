package br.com.guilhermekellermann.individual_registration.modules.person.useCase;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.guilhermekellermann.individual_registration.modules.exceptions.PersonFoundException;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonEntity;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;
import br.com.guilhermekellermann.individual_registration.modules.person.useCases.CreatePersonUseCase;

@ExtendWith(MockitoExtension.class)
public class CreatePersonUseCaseTest {

    @InjectMocks
    private CreatePersonUseCase createPersonUseCase;

    @Mock
    private PersonRepository personRepository;

    @Test
    @DisplayName("should not be able to create a person with person found")
    public void should_not_be_able_to_create_a_person_with_person_found() {
        var cpf = "10452148928";

        var person = new PersonEntity();
        person.setCpf(cpf);
        personRepository.save(person);

        try {
            createPersonUseCase.execute(person);
        } catch (Exception e) {
            assertInstanceOf(PersonFoundException.class, e);
        }
    }

    @Test
    @DisplayName("Should return a person entity when save")
    public void should_return_a_person_entity_when_save() {
        var cpf = "79178796075";

        var person = new PersonEntity();
        person.setCpf(cpf);

        when(personRepository.save(person)).thenReturn(person);

        var personCreated = createPersonUseCase.execute(person);
        assertInstanceOf(person.getClass(), personCreated);
        assertNotNull(personCreated.getCpf());
    }
}