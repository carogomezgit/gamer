package edu.isp63.prog2.gamer.dto;

import java.time.LocalDate;

public record InscripcionResponseDTO(
    Integer id,
    String nicknameJugador,
    String nombreTorneo,
    LocalDate fechaInscripcion
) {
}
