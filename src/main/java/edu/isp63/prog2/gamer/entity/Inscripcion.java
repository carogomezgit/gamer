package edu.isp63.prog2.gamer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Inscripciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "jugador_id", nullable = false,
      foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGNKEY=jugador_id REFERENCES jugadores(id)" +
      " ON DELETE CASCADE "))
  private Jugador jugador;

  @ManyToOne
  @JoinColumn(name = "torneo_id", nullable = false,
      foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGNKEY=torneo_id REFERENCES torneos(id)" +
          " ON DELETE CASCADE "))
  private Torneo torneo;

  @Column(name = "fecha_inscripcion")
  private LocalDate fechaInscripcion;


}
