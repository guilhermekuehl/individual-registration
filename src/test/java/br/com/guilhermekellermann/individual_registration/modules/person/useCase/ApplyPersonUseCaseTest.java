package br.com.guilhermekellermann.individual_registration.modules.person.useCase;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.guilhermekellermann.individual_registration.modules.exceptions.PersonFoundException;
import br.com.guilhermekellermann.individual_registration.modules.person.PersonRepository;
import br.com.guilhermekellermann.individual_registration.modules.person.useCases.ApplyPersonUseCase;

@ExtendWith(MockitoExtension.class)
public class ApplyPersonUseCaseTest {
    
    @InjectMocks
    private ApplyPersonUseCase applyPersonUseCase;

    @Mock
    private PersonRepository personRepository;

    @Test
    @DisplayName("should not be able to create a person with person found")
    public void should_not_be_able_to_create_a_person_with_person_found() {
        var cpf = "10452148928";
        try {
            applyPersonUseCase.execute(cpf);
        } catch (Exception e) {
            assertInstanceOf(PersonFoundException.class, e);
        }
    }
}
