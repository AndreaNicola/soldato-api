package it.formazione.sme.soldatiapi.services;

import it.formazione.sme.soldatiapi.entities.Pratica;
import org.springframework.data.domain.Page;

public interface PraticaService {

  Page<Pratica> queryComplessa(Integer idEnte, String idGrado, Integer page, Integer size);


}
