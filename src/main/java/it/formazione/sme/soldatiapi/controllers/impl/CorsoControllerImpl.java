package it.formazione.sme.soldatiapi.controllers.impl;

import it.formazione.sme.soldatiapi.bodies.CorsoBody;
import it.formazione.sme.soldatiapi.controllers.CorsoController;
import it.formazione.sme.soldatiapi.entities.Corso;
import it.formazione.sme.soldatiapi.services.CorsoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CorsoControllerImpl implements CorsoController {

  private final CorsoService corsoService;

  @Override
  public Collection<Corso> list() {
    return corsoService.list();
  }

  @Override
  public ResponseEntity<Corso> findById(UUID id) {
    Optional<Corso> optionalCorso = corsoService.findById(id);
    return ResponseEntity.of(optionalCorso);
  }

  @Override
  public ResponseEntity<Corso> deleteById(UUID id) {
    Optional<Corso> optionalCorso = corsoService.deleteById(id);
    return ResponseEntity.of(optionalCorso);
  }

  @Override
  public Corso insert(@Valid CorsoBody corsoBody) {
    return corsoService.insert(corsoBody);
  }

  @Override
  public ResponseEntity<Corso> update(UUID id, @Valid CorsoBody corsoBody) {
    Optional<Corso> optionalCorso = corsoService.update(id, corsoBody);
    return ResponseEntity.of(optionalCorso);
  }
}
