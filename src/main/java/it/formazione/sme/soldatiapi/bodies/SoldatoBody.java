package it.formazione.sme.soldatiapi.bodies;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SoldatoBody {

  @NotBlank
  private String nome;

  @NotBlank
  private String cognome;

  @NotBlank
  @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}")
  private String dataDiNascita;

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

  public String getDataDiNascita() {
    return dataDiNascita;
  }

  public void setDataDiNascita(String dataDiNascita) {
    this.dataDiNascita = dataDiNascita;
  }
}
