package it.formazione.sme.soldatiapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Cacheable
public class Grado {

    @Id
    @Column(name = "cod_grado", length = 2)
    private String id;

    @Column(name = "des_grado", nullable = false)
    private String descrizione;

    @OneToMany(mappedBy = "grado")
    @JsonBackReference
    private Collection<Soldato> soldati;

}
