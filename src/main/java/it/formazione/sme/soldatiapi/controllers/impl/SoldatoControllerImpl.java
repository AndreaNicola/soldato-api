package it.formazione.sme.soldatiapi.controllers.impl;

import it.formazione.sme.soldatiapi.bodies.SoldatoBody;
import it.formazione.sme.soldatiapi.controllers.SoldatoController;
import it.formazione.sme.soldatiapi.entities.Soldato;
import it.formazione.sme.soldatiapi.services.SoldatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class SoldatoControllerImpl implements SoldatoController {

    private final SoldatoService soldatoService;

    @Override
    public Collection<Soldato> list() {
        return soldatoService.list();
    }

    @Override
    public ResponseEntity<Soldato> findById(@PathVariable Integer id) {
        return ResponseEntity.of(soldatoService.findById(id));
    }

    @Override
    public ResponseEntity<Soldato> deleteById(@PathVariable Integer id) {
        return ResponseEntity.of(soldatoService.delete(id));
    }

    @Override
    public Soldato insert(@RequestBody @Valid SoldatoBody soldatoBody) {
        return soldatoService.insert(soldatoBody);
    }

    @Override
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid SoldatoBody soldatoBody) {
        return ResponseEntity.of(soldatoService.update(id, soldatoBody));
    }

}
