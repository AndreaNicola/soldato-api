package it.formazione.sme.soldatiapi.controllers.impl;

import it.formazione.sme.soldatiapi.controllers.GradoController;
import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import it.formazione.sme.soldatiapi.services.GradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class GradoControllerImpl implements GradoController {

    private final GradoService gradoService;

    @Override
    public Collection<Grado> list() {
        return gradoService.list();
    }

    @Override
    public ResponseEntity<Grado> get(String id) {
        return ResponseEntity.of(gradoService.get(id));
    }

    @Override
    public ResponseEntity<Collection<Soldato>> getSoldati(String id) {
        return ResponseEntity.of(gradoService.get(id).map(Grado::getSoldati));
    }
}
