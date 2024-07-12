package br.com.guilhermekellermann.individual_registration.modules.person.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilhermekellermann.individual_registration.modules.person.PersonEntity;
import br.com.guilhermekellermann.individual_registration.modules.person.useCases.CreatePersonUseCase;
import br.com.guilhermekellermann.individual_registration.modules.person.useCases.ProfilePersonUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private CreatePersonUseCase createPersonUseCase;

    @Autowired
    private ProfilePersonUseCase profilePersonUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody PersonEntity personEntity) {
        try {
            var result = this.createPersonUseCase.execute(personEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        try {
            var profile = this.profilePersonUseCase
                .execute();
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
