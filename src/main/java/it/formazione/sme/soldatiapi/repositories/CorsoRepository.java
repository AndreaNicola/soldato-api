package it.formazione.sme.soldatiapi.repositories;

import it.formazione.sme.soldatiapi.entities.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface CorsoRepository extends JpaRepository<Corso, UUID> {
  List<Corso> findAllByNome(String nome);
}
