package br.com.guilhermekellermann.individual_registration.modules.person.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilhermekellermann.individual_registration.modules.person.PersonEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping("/")
    public void create(@Valid @RequestBody PersonEntity personEntity) {
        System.out.println("Pessoa");
        System.out.println(personEntity.getName());
    }
    
}
