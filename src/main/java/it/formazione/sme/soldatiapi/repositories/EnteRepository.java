package it.formazione.sme.soldatiapi.repositories;

import it.formazione.sme.soldatiapi.entities.Ente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnteRepository extends JpaRepository<Ente, Integer> {
}
