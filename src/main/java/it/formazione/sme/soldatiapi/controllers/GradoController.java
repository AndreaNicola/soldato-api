package it.formazione.sme.soldatiapi.controllers;

import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RequestMapping("gradi")
public interface GradoController {

    @GetMapping
    Collection<Grado> list();

    @GetMapping("{id}")
    ResponseEntity<Grado> get(@PathVariable String id);

    @GetMapping("{id}/soldati")
    ResponseEntity<Collection<Soldato>> getSoldati(@PathVariable String id);


}
