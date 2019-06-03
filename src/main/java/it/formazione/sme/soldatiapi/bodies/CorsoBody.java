package it.formazione.sme.soldatiapi.bodies;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CorsoBody {

  @NotBlank(message = "nome corso obbligatorio")
  private String nome;

  @NotBlank(message = "descrizione corso obbligatoria")
  private String descrizione;

}
