package it.formazione.sme.soldatiapi.repositories;

import it.formazione.sme.soldatiapi.entities.Soldato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoldatoRepository extends JpaRepository<Soldato, Integer> {
    Optional<Soldato> findByEmail(String email);


}
