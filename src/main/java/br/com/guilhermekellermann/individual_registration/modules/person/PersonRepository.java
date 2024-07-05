package br.com.guilhermekellermann.individual_registration.modules.person;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<PersonEntity, String> {
    Optional<PersonEntity> findByCpf(String cpf);
}
