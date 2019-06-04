package it.formazione.sme.soldatiapi.controllers.impl;

import it.formazione.sme.soldatiapi.entities.Pratica;
import it.formazione.sme.soldatiapi.services.PraticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pratiche")
@RequiredArgsConstructor
public class PraticaControllerImpl {

  private final PraticaService praticaService;


  @GetMapping
  public Page<Pratica> qc(Integer idEnte, String idGrado) {
    return praticaService.queryComplessa(idEnte, idGrado, 0, 50);
  }

}
