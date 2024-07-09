package br.com.guilhermekellermann.individual_registration.modules.exceptions;

public class PersonFoundException extends RuntimeException {
    public PersonFoundException() {
        super("Pessoa já existe.");
    }
}
