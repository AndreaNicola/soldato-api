package it.formazione.sme.soldatiapi.repositories;

import it.formazione.sme.soldatiapi.entities.Ente;
import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Pratica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PraticaRepository extends JpaRepository<Pratica, Integer> {

  @Query("select p from Pratica p inner join Soldato s on p.richiedente = s where s.grado = :grado and p.enteAssegnatario = :ente")
  Page<Pratica> queryComplessa(Optional<Grado> grado, Optional<Ente> ente, Pageable pageable);

}
