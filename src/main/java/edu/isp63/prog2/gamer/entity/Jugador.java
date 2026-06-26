package edu.isp63.prog2.gamer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Jugadores")
@Data // getters y setters, toString, equals
@NoArgsConstructor // constructor sin argumentos
@AllArgsConstructor // constructor con argumentos

public class Jugador {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;
  @Column(name="nickname", nullable=false, length=200)
  @NotBlank
  private String nickname;

  @Email
  private String email;

  private String password;
  private String rango="Principiante";

}
