package it.formazione.sme.soldatiapi.services.impl;

import it.formazione.sme.soldatiapi.entities.Grado;
import it.formazione.sme.soldatiapi.repositories.GradoRepository;
import it.formazione.sme.soldatiapi.services.GradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradoServiceImpl implements GradoService {

    private final GradoRepository gradoRepository;

    @Override
    public Collection<Grado> list() {
        return gradoRepository.findAll();
    }

    @Override
    public Optional<Grado> get(String id) {
        return gradoRepository.findById(id);
    }
}
