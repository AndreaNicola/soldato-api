package it.formazione.sme.soldatiapi.controllers;

import it.formazione.sme.soldatiapi.bodies.SoldatoBody;
import it.formazione.sme.soldatiapi.entities.Soldato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RequestMapping("soldati")
public interface SoldatoController {

    @GetMapping
    Collection<Soldato> list();

    @GetMapping("{id}")
    ResponseEntity<Soldato> findById(@PathVariable Integer id);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResponseEntity<Soldato> deleteById(@PathVariable Integer id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Soldato insert(@RequestBody @Valid SoldatoBody soldatoBody);

    @PutMapping("{id}")
    ResponseEntity<Soldato> update(@PathVariable Integer id, @RequestBody @Valid SoldatoBody soldatoBody);

}
