package it.formazione.sme.soldatiapi.services.impl;

import it.formazione.sme.soldatiapi.entities.Ente;
import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Pratica;
import it.formazione.sme.soldatiapi.repositories.EnteRepository;
import it.formazione.sme.soldatiapi.repositories.GradoRepository;
import it.formazione.sme.soldatiapi.repositories.PraticaRepository;
import it.formazione.sme.soldatiapi.services.PraticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PraticaServiceImpl implements PraticaService {

  private final PraticaRepository praticaRepository;
  private final EnteRepository enteRepository;
  private final GradoRepository gradoRepository;

  @Override
  public Page<Pratica> queryComplessa(Integer idEnte, String idGrado, Integer page, Integer size) {

    Optional<Ente> optionalEnte = enteRepository.findById(idEnte);
    Optional<Grado> optionalGrado = gradoRepository.findById(idGrado);
    Pageable pageRequest = PageRequest.of(page, size);

    return praticaRepository.queryComplessa(optionalGrado, optionalEnte, pageRequest);

  }

}
