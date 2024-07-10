package br.com.guilhermekellermann.individual_registration.modules.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        super("Ainda não há pessoas cadastradas");
    }
}
