package edu.isp63.prog2.gamer.repository;

import edu.isp63.prog2.gamer.entity.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
  List<Torneo> findByPlataforma(String plataforma);
  List<Torneo> findByNombreTorneoIgnoreCase(String nombreTorneo);

  // 2. Contar cuántos torneos existen para un nombreJuego dado
  Long countByNombreJuego(String nombreJuego);

  // 6. Buscar torneos cuya plataforma sea igual a un valor dado,
  // usando Equals de forma explícita en el nombre del método.
  List<Torneo> findByPlataformaEquals(String plataforma);

  // 7. Buscar torneos cuyo precio sea menor a un valor dado.
  List<Torneo> findByPrecioLessThan(BigDecimal precio);

  // 8. Buscar torneos cuyo cupo sea mayor o igual a un valor dado.
  List<Torneo> findByCupoGreaterThanEqual(Integer cupo);

  // 9. Buscar torneos cuyo precio sea menor o igual a un valor dado.
  List<Torneo> findByCupoLessThanEqual(BigDecimal precio);

  // 10. Buscar torneos cuyo precio esté entre dos valores dados.
  List<Torneo> findByPrecioBetween(BigDecimal precio1, BigDecimal precio2);

  // 12. Buscar torneos cuyo precio sea nulo — torneos sin arancel cargado aún.
  List<Torneo> findByPrecioIsNull(BigDecimal precio);

  // 14. Buscar torneos cuya plataforma esté dentro de una lista de plataformas dada.
  List<Torneo> findByPlataformaIn(List<String> torneos);

  // 17. Buscar torneos cuyo nombreTorneo empiece con un prefijo dado.
  List<Torneo> findByNombreTorneoStartingWith(String nombreTorneo);

  // Buscar torneos cuyo nombreJuego coincida
  // con un valor dado sin distinguir mayúsculas de minúsculas.
  List<Torneo> findByNombreJuegoIgnoreCase(String nombreJuego);

  // 19. Buscar torneos cuyo nombreJuego sea un valor dado
  // y cuyo precio sea menor a un valor dado.
  List<Torneo> findByNombreJuegoEqualsAndPrecioLessThan(String nombreJuego, BigDecimal precio);

  // 22. Buscar torneos cuya plataforma sea un valor dado
  // y cuyo cupo sea mayor a un valor dado,
  // combinando dos tipos de keyword distintos en el mismo método.
  List<Torneo> findByPlataformaAndCupoGreaterThan(String plataforma, int cupo);

  // 24. Buscar torneos por nombreJuego, ordenados por precio de forma descendente.
  List<Torneo> findByNombreJuegoOrderByPrecioDesc(String nombreJuego);

  // 25. Obtener los 3 torneos con mayor cupo
  List<Torneo> findTop3ByOrderByCupoDesc(int cupo);
}
