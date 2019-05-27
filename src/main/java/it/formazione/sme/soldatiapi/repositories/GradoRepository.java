package it.formazione.sme.soldatiapi.repositories;

import it.formazione.sme.soldatiapi.entities.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradoRepository extends JpaRepository<Grado, String> {
}
