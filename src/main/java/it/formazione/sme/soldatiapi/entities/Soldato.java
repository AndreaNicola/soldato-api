package it.formazione.sme.soldatiapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Soldato {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer matricola;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String cognome;

  @Column(nullable = false, unique = true, length = 50)
  private String email;

  @JsonIgnore
  private String passwordHash;

  @Column(nullable = false)
  private LocalDate dataDiNascita;

  @ManyToOne
  @JsonManagedReference
  private Grado grado;

}
