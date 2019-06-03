package it.formazione.sme.soldatiapi.services;

import it.formazione.sme.soldatiapi.bodies.CorsoBody;
import it.formazione.sme.soldatiapi.entities.Corso;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CorsoService {
  Optional<Corso> findById(UUID id);

  Collection<Corso> list();

  Optional<Corso> deleteById(UUID id);

  Corso insert(CorsoBody corsoBody);

  Optional<Corso> update(UUID id, CorsoBody soldatoBody);
}
