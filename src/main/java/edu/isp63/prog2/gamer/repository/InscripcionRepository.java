package edu.isp63.prog2.gamer.repository;

import edu.isp63.prog2.gamer.dto.InscripcionJugadorResponseDTO;
import edu.isp63.prog2.gamer.entity.Inscripcion;
import edu.isp63.prog2.gamer.entity.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {
  List<Inscripcion> findByJugadorId(Integer jugadorId);

  List<Inscripcion> findByTorneoId(Integer torneoId);

  boolean existsByJugadorIdAndTorneoId(String jugadorId, String torneoId);

  long countByTorneoId(Integer torneoId);

  // 4. Eliminar todas las inscripciones asociadas a un torneo dado (a partir del id del torneo)
  void deleteByTorneoId(Integer torneoId);

  // 11. Buscar inscripciones cuya fechaInscripcion esté entre dos fechas dadas.
  List<Inscripcion> findByFechaInscripcionBetween(LocalDate fecha1, LocalDate fecha2);

  // 26. Obtener la primera inscripción (la más antigua)
  // de un jugador dado, a partir de su id, ordenada por fechaInscripcion ascendente.
  List<Inscripcion> findFirstByJugadorIdOrderByFechaInscripcionAsc(Integer jugadorId);

  // 27. Obtener los nombres de juego distintos (sin repetidos)
  // de los torneos en los que un jugador dado está inscripto,
  // navegando la relación hacia torneo.nombreJuego.
  List<String> findDistinctTorneoNombreJuegoByJugadorId(Integer jugadorId);

  // 28. Buscar todas las inscripciones de un jugador a partir de su nickname,
  // navegando la relación jugador.nickname (no del id, sino del atributo anidado).
  List<Inscripcion> findByJugadorNickname(String nickname);

  // 29. Buscar las inscripciones a un juego dado (torneo.nombreJuego)
  // realizadas después de una fecha dada (fechaInscripcion),
  // combinando navegación de relación + comparación de fecha en un mismo método (And + After).
  List<Inscripcion> findByTorneoNombreJuegoAndFechaInscripcionAfter(String nombreJuego, LocalDate fechaInscripcion);


  // JOIN (filtrar por atributo de Jugador)
  @Query("SELECT i FROM Inscripcion i JOIN Jugador j WHERE j.rango=:rango")
  List<Inscripcion> findByRango(@Param("rango") Integer rango);

  // JOIN FETCH (cargar Inscripcion junto con Jugador)
  @Query("SELECT i.id, j.nickname, i.fechaInscripcion " +
      "FROM Inscripcion i JOIN FETCH Jugador j " +
      "WHERE i.fechaInscripcion BETWEEN :fechaDesde AND :fechaHasta")
  List<InscripcionJugadorResponseDTO> findByFechaInscripcionBetweenJPQL
  (@Param("fechaDesde") LocalDate fechaDesde,
   @Param("fechaHasta") LocalDate fechaHasta);
}
