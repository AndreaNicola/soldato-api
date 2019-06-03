package it.formazione.sme.soldatiapi.services;

import it.formazione.sme.soldatiapi.bodies.SoldatoBody;
import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface SoldatoService {
  Collection<Soldato> list();
  Optional<Soldato> findById(Integer id);
  Optional<Soldato> delete(Integer id);
  Soldato insert(SoldatoBody soldatoBody);
  Optional<Soldato> update(Integer id, SoldatoBody soldatoBody);
  Page<Soldato> ricercaPaginataPerGrado(Grado grado, Integer page, Integer size);
}
