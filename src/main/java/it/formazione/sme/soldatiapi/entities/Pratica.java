package it.formazione.sme.soldatiapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pratica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String colonnaACaso1;
  private String colonnaACaso2;

  @ManyToOne
  private Soldato richiedente;

  @ManyToOne
  private Ente enteAssegnatario;

}
