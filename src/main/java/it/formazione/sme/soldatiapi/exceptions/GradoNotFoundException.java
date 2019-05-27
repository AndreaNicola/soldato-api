package it.formazione.sme.soldatiapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GradoNotFoundException extends RuntimeException {

    public GradoNotFoundException(String idGrado) {
        super("Grado con id " + idGrado + " non trovato");
    }

}
