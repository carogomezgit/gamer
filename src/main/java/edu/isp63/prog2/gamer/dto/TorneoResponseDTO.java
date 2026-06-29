package edu.isp63.prog2.gamer.dto;

import java.math.BigDecimal;

public record TorneoResponseDTO(
    String nombreTorneo,
    String nombreJuego,
    BigDecimal precio,
    int cupo,
    String plataforma
) {
}
