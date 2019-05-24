package it.formazione.sme.soldatiapi.repositories;

import it.formazione.sme.soldatiapi.entities.Soldato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldatoRepository extends JpaRepository<Soldato, Integer> {
}
