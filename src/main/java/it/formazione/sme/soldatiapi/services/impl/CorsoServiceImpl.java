package it.formazione.sme.soldatiapi.services.impl;

import it.formazione.sme.soldatiapi.bodies.CorsoBody;
import it.formazione.sme.soldatiapi.entities.Corso;
import it.formazione.sme.soldatiapi.exceptions.CorsoConLoStessoNomeException;
import it.formazione.sme.soldatiapi.repositories.CorsoRepository;
import it.formazione.sme.soldatiapi.services.CorsoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CorsoServiceImpl implements CorsoService {

  private final CorsoRepository corsoRepository;

  @Override
  public Optional<Corso> findById(UUID id) {
    return corsoRepository.findById(id);
  }

  @Override
  public Collection<Corso> list() {
    return corsoRepository.findAll();
  }

  @Override
  public Optional<Corso> deleteById(UUID id) {
    Optional<Corso> optionalCorso = this.findById(id);
    optionalCorso.ifPresent(corsoRepository::delete);
    return optionalCorso;
  }

  @Override
  public Corso insert(CorsoBody corsoBody) {


    Corso corso = new Corso();
    corso.setId(UUID.randomUUID());
    corso.setNome(corsoBody.getNome().trim().toUpperCase());
    corso.setDescrizione(corsoBody.getDescrizione().trim());

    Collection<Corso> corsiConLoStessoNome = corsoRepository.findAllByNome(corso.getNome());
    if (!corsiConLoStessoNome.isEmpty()) {
      throw new CorsoConLoStessoNomeException(corso.getNome());
    }

    return corsoRepository.save(corso);
  }

  @Override
  public Optional<Corso> update(UUID id, CorsoBody corsoBody) {

    Optional<Corso> optionalCorso = findById(id);
    optionalCorso.ifPresent(corso -> {

      corso.setNome(corsoBody.getNome().trim().toUpperCase());
      corso.setDescrizione(corsoBody.getDescrizione().trim());

      List<Corso> corsiConLoStessoNome = corsoRepository.findAllByNome(corso.getNome());
      if (!corsiConLoStessoNome.isEmpty()) {
        Corso corsoNomeUguale = corsiConLoStessoNome.get(0);
        if (!corso.getId().equals(corsoNomeUguale)) {
          throw new CorsoConLoStessoNomeException(corso.getNome());
        }
      }

      corsoRepository.save(corso);

    });

    return optionalCorso;
  }

}
