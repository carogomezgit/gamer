package edu.isp63.prog2.gamer.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record TorneoCreateDTO(
    @NotBlank(message = "El nombre del torneo no debe estar vacío")
    String nombreTorneo,

    @NotBlank(message = "El nombre del juego no debe estar vacío")
    String nombreJuego,
    BigDecimal precio,
    int cupo,

    @NotBlank(message = "El nombre de la plataforma no debe estar vacío")
    String plataforma
    ) {
}
