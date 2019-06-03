package it.formazione.sme.soldatiapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CorsoConLoStessoNomeException extends RuntimeException {

  public CorsoConLoStessoNomeException(String nome) {
    super("Esiste già un corso con il nome " + nome);
  }

}
