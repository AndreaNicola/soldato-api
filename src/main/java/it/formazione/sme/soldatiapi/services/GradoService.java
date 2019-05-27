package it.formazione.sme.soldatiapi.services;

import it.formazione.sme.soldatiapi.entities.Grado;

import java.util.Collection;
import java.util.Optional;

public interface GradoService {
    Collection<Grado> list();

    Optional<Grado> get(String id);
}
