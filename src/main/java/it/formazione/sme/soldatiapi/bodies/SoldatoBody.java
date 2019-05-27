package it.formazione.sme.soldatiapi.bodies;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SoldatoBody {

  @NotBlank(message = "nome obbligatorio")
  private String nome;

  @NotBlank(message = "cognome obbligatorio")
  private String cognome;

  @NotBlank(message = "data di nascita obbligatoria")
  @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "formato data di nascita non corretto")
  private String dataDiNascita;

  @NotBlank
  @Length(min = 2, max = 2)
  private String grado;

  @NotBlank
  @Email
  private String email;

}
