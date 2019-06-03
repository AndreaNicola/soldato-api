package it.formazione.sme.soldatiapi.controllers;

import it.formazione.sme.soldatiapi.bodies.CorsoBody;
import it.formazione.sme.soldatiapi.entities.Corso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@RequestMapping("corsi")
public interface CorsoController {

  @GetMapping
  Collection<Corso> list();

  @GetMapping("{id}")
  ResponseEntity<Corso> findById(@PathVariable UUID id);

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  ResponseEntity<Corso> deleteById(@PathVariable UUID id);

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Corso insert(@RequestBody @Valid CorsoBody soldatoBody);

  @PutMapping("{id}")
  ResponseEntity<Corso> update(@PathVariable UUID id, @RequestBody @Valid CorsoBody soldatoBody);


}
