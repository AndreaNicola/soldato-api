package it.formazione.sme.soldatiapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(@NotBlank @Email String email) {
        super("Soldato con email " + email + " già presente");
    }
}
