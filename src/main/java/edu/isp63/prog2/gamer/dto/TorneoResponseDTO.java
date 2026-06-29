package edu.isp63.prog2.gamer.dto;

import java.math.BigDecimal;

public record TorneoResponseDTO(
    Integer id,
    String nombreTorneo,
    String nombreJuego,
    BigDecimal precio,
    int cupo,
    String plataforma
) {
}
