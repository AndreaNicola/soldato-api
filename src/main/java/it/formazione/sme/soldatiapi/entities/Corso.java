package it.formazione.sme.soldatiapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.formazione.sme.soldatiapi.SoldatiApiApplication;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
public class Corso {

  @Id
  @Column(name = "cod_corso", length = 36)
  private UUID id;

  @Column(name = "nome_corso", nullable = false)
  private String nome;

  @Column(name = "des_corso", nullable = false)
  private String descrizione;

  @ManyToMany(mappedBy = "corsiFrequentati")
  @JsonBackReference
  private Collection<Soldato> soldatiCheHannoFrequentato;

  @ManyToMany(mappedBy = "corsiInCorso")
  @JsonBackReference
  private Collection<Soldato> soldatiCheStannoFrequentando;


}
