package it.formazione.sme.soldatiapi.services;

import it.formazione.sme.soldatiapi.bodies.SoldatoBody;
import it.formazione.sme.soldatiapi.entities.Soldato;
import it.formazione.sme.soldatiapi.repositories.SoldatoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class SoldatoServiceImpl implements SoldatoService {

  private final SoldatoRepository soldatoRepository;

  public SoldatoServiceImpl(SoldatoRepository soldatoRepository) {
    this.soldatoRepository = soldatoRepository;
  }

  @Override
  public Collection<Soldato> list(){
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
    soldato.setCognome(soldatoBody.getCognome());
    soldato.setNome(soldatoBody.getNome());
    soldato.setDataDiNascita(LocalDate.parse(soldatoBody.getDataDiNascita()));
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

}
