package br.com.guilhermekellermann.individual_registration.modules.person.exceptions;

public class PersonFoundException extends RuntimeException {
    public PersonFoundException() {
        super("Pessoa já existe.");
    }
}
