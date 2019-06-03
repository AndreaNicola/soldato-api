package it.formazione.sme.soldatiapi.controllers;

import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@RequestMapping("gradi")
public interface GradoController {

  @GetMapping
  Collection<Grado> list();

  @GetMapping("{id}")
  ResponseEntity<Grado> get(@PathVariable String id);

  @GetMapping("{id}/soldati")
  ResponseEntity<Collection<Soldato>> getSoldati(@PathVariable String id);

  @GetMapping("{id}/soldati-paginati")
  ResponseEntity<Page<Soldato>> getSoldatiPaginati(@PathVariable String id,
                                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "50") Integer size
  );


}
