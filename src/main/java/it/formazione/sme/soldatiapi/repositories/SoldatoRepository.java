package it.formazione.sme.soldatiapi.repositories;

import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SoldatoRepository extends JpaRepository<Soldato, Integer> {
    Optional<Soldato> findByEmail(String email);


}
