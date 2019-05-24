package it.formazione.sme.soldatiapi.controllers;

import it.formazione.sme.soldatiapi.bodies.SoldatoBody;
import it.formazione.sme.soldatiapi.entities.Soldato;
import it.formazione.sme.soldatiapi.services.SoldatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("soldati")
public class SoldatoController {

  private final SoldatoService soldatoService;

  public SoldatoController(SoldatoService soldatoService) {
    this.soldatoService = soldatoService;
  }

  @GetMapping
  public Collection<Soldato> list() {
    return soldatoService.list();
  }

  @GetMapping("{id}")
  public ResponseEntity<Soldato> findById(@PathVariable Integer id) {
    return ResponseEntity.of(soldatoService.findById(id));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Soldato> deleteById(@PathVariable Integer id) {
    return ResponseEntity.of(soldatoService.delete(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Soldato insert(@RequestBody @Valid SoldatoBody soldatoBody) {
    return soldatoService.insert(soldatoBody);
  }

  @PutMapping("{id}")
  public ResponseEntity insert(@PathVariable Integer id, @RequestBody @Valid SoldatoBody soldatoBody) {
    return ResponseEntity.of(soldatoService.update(id, soldatoBody));
  }

}
