package edu.isp63.prog2.gamer.service;

import edu.isp63.prog2.gamer.dto.InscripcionJugadorResponseDTO;
import edu.isp63.prog2.gamer.dto.InscripcionResponseDTO;
import edu.isp63.prog2.gamer.entity.Inscripcion;

import java.time.LocalDate;
import java.util.List;

public interface InscripcionService {
  List<InscripcionJugadorResponseDTO> findByFechaInscripcionBetweenJPQL(
      LocalDate fechaDesde, LocalDate fechaHasta
  );

  List<InscripcionResponseDTO> findByRango(Integer rango);


}
