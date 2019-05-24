package it.formazione.sme.soldatiapi.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Soldato {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer matricola;
  private String nome;
  private String cognome;

  private LocalDate dataDiNascita;

  public Integer getMatricola() {
    return matricola;
  }

  public void setMatricola(Integer matricola) {
    this.matricola = matricola;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public LocalDate getDataDiNascita() {
    return dataDiNascita;
  }

  public void setDataDiNascita(LocalDate dataDiNascita) {
    this.dataDiNascita = dataDiNascita;
  }

}
