package it.formazione.sme.soldatiapi;

import it.formazione.sme.soldatiapi.entities.Corso;
import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.entities.Soldato;
import it.formazione.sme.soldatiapi.repositories.CorsoRepository;
import it.formazione.sme.soldatiapi.repositories.GradoRepository;
import it.formazione.sme.soldatiapi.repositories.SoldatoRepository;
import it.formazione.sme.soldatiapi.services.GradoService;
import it.formazione.sme.soldatiapi.services.SoldatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@SpringBootApplication
public class SoldatiApiApplication implements CommandLineRunner {

  @Autowired
  private SoldatoRepository soldatoRepository;

  @Autowired
  private GradoRepository gradoRepository;

  @Autowired
  private CorsoRepository corsoRepository;

  public static void main(String[] args) {
    SpringApplication.run(SoldatiApiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

//    Collection<Grado> gradi = gradoRepository.findAll();
//
//    Collection<Corso> corsi = new ArrayList<>();
//    for (int k = 0; k < 100; k++) {
//      Corso corso = new Corso();
//      corso.setNome("corso " + k);
//      corso.setDescrizione("descrizione corso " + k);
//      corso.setId(UUID.randomUUID());
//      corsi.add(corso);
//    }
//
//    corsoRepository.saveAll(corsi);
//
//    int i = 0;
//    for (Grado g : gradi) {
//
//      for (int j = 0; j < 100; j++) {
//        Soldato soldato1 = new Soldato();
//        soldato1.setGrado(g);
//        soldato1.setDataDiNascita(LocalDate.now());
//        soldato1.setNome("" + i);
//        soldato1.setCognome("" + i);
//        soldato1.setEmail("a" + i + "@a.it");
//        soldato1.setCorsiFrequentati(corsi);
//        soldato1.setCorsiInCorso(corsi);
//        soldatoRepository.save(soldato1);
//        i++;
//      }
//
//    }


  }

}
