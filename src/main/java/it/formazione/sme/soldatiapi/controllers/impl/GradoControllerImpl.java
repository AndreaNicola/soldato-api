package it.formazione.sme.soldatiapi.controllers.impl;

import it.formazione.sme.soldatiapi.controllers.GradoController;
import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import it.formazione.sme.soldatiapi.services.GradoService;
import it.formazione.sme.soldatiapi.services.SoldatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GradoControllerImpl implements GradoController {

    private final GradoService gradoService;
    private final SoldatoService soldatoService;

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

    @Override
    public ResponseEntity<Page<Soldato>> getSoldatiPaginati(String id, Integer page, Integer size) {
        Optional<Page<Soldato>> optionalPagina = gradoService
         .get(id)
         .map(g -> soldatoService.ricercaPaginataPerGrado(g, page, size));
        return ResponseEntity.of(optionalPagina);
    }
}
