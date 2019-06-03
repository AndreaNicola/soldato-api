package it.formazione.sme.soldatiapi.services.impl;

import it.formazione.sme.soldatiapi.exceptions.GradoNotFoundException;
import it.formazione.sme.soldatiapi.bodies.SoldatoBody;
import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import it.formazione.sme.soldatiapi.exceptions.EmailAlreadyInUseException;
import it.formazione.sme.soldatiapi.repositories.GradoRepository;
import it.formazione.sme.soldatiapi.repositories.SoldatoRepository;
import it.formazione.sme.soldatiapi.services.SoldatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SoldatoServiceImpl implements SoldatoService {

  private final SoldatoRepository soldatoRepository;
  private final GradoRepository gradoRepository;

  @Override
  public Collection<Soldato> list() {
    return soldatoRepository.findAll();
  }

  @Override
  public Optional<Soldato> findById(Integer id) {
    return soldatoRepository.findById(id);
  }

  @Override
  public Optional<Soldato> delete(Integer id) {
    Optional<Soldato> result = this.findById(id);
    result.ifPresent(soldatoRepository::delete);
    return result;
  }

  @Override
  public Soldato insert(SoldatoBody soldatoBody) {

    Soldato soldato = new Soldato();

    Optional<Grado> optionalGrado = gradoRepository.findById(soldatoBody.getGrado());
    optionalGrado.ifPresent(soldato::setGrado);
    optionalGrado.orElseThrow(() -> new GradoNotFoundException(soldatoBody.getGrado()));

    Optional<Soldato> soldatoConStessaEmail = soldatoRepository.findByEmail(soldatoBody.getEmail());
    soldatoConStessaEmail.ifPresent(s -> {
      throw new EmailAlreadyInUseException(soldatoBody.getEmail());
    });


    soldato.setCognome(soldatoBody.getCognome());
    soldato.setNome(soldatoBody.getNome());
    soldato.setDataDiNascita(LocalDate.parse(soldatoBody.getDataDiNascita()));
    soldato.setEmail(soldatoBody.getEmail());


    return soldatoRepository.save(soldato);
  }

  @Override
  public Optional<Soldato> update(Integer id, SoldatoBody soldatoBody) {
    Optional<Soldato> optionalSoldato = this.findById(id);
    optionalSoldato.ifPresent(soldato -> {
      soldato.setCognome(soldatoBody.getCognome());
      soldato.setNome(soldatoBody.getNome());
      soldato.setDataDiNascita(LocalDate.parse(soldatoBody.getDataDiNascita()));
      soldatoRepository.save(soldato);
    });
    return optionalSoldato;
  }

  @Override
  public Page<Soldato> ricercaPaginataPerGrado(Grado grado, Integer page, Integer size) {
    ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues();
    Soldato soldatoDiEsempio = new Soldato();
    soldatoDiEsempio.setGrado(grado);

    Example<Soldato> soldatoExample = Example.of(soldatoDiEsempio, exampleMatcher);
    Sort sort = Sort.by("cognome", "nome");

    PageRequest pageRequest = PageRequest.of(page, size, sort);
    return soldatoRepository.findAll(soldatoExample, pageRequest);

  }

}
