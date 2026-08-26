package edu.isp63.prog2.gamer.repository;


import edu.isp63.prog2.gamer.entity.Jugador;
import edu.isp63.prog2.gamer.entity.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
  // se utiliza camelCase para realizar las consultas derivadas
  // si termina con variable nickname ignorando case "S" o con "s"
  Optional<Jugador> getByNicknameEndsWithIgnoreCase(String nickname);

  // busca todos los jugadores que coincida con el rango del string exacto
  List<Jugador> findByRango(String rango);

  // busca todos los jugadores que coincida con el rango del string
  // en alguna parte
  // ordeno por nickname de manera descendiente
  List<Jugador> findByRangoContainingOrderByNicknameDesc (String rango);

  // unir criterios con AND
  List<Jugador> findByEmailContainingAndNickname(String arroba, String nickname);

  // busca los primeros 3 jugadores que encuentre con ese rango y los ordena por email
  List<Jugador> findTop3ByRangoOrderByEmailAsc(String rango);

  // criterios numericos
  // prefijo atributo criterio
  // devuelve lista de jugadores cuyo id sea menor al parametro
  List<Jugador> findByIdLessThan(Integer menor);

  // lista de jugadores en el rango definido
  List<Jugador> findByIdBetween(Integer menor, Integer mayor);


  // 1. Buscar un jugador por su nickname exacto
  Optional<Jugador> getByNickname(String nickname);

  // 3. Verificar si existe un jugador con un email dado
  Boolean existsByEmail(String email);

  // 5. Buscar jugadores cuyo rango sea distinto de "Principiante"
  List<Jugador> findByRangoNot(String rango);

  // 13. Buscar jugadores cuyo email no sea nulo.
  List<Jugador> findByEmailIsNotNull(String email);

  // 15. Buscar jugadores cuyo rango no esté dentro de una lista de rangos dada.
  List<Jugador> findByRangoIn(List<String> jugadores);

  // 16. Buscar jugadores cuyo nickname contenga una subcadena dada.
  List<Jugador> findByNicknameContaining(String nickname);

  // 18. Buscar jugadores cuyo email termine con un dominio dado,
  // por ejemplo "@gmail.com".
  List<Jugador> findByEmailEndingWith(String email);

  // 21. Buscar jugadores cuyo rango sea "Avanzado" o "Experto"
  List<Jugador> findByRangoOrRango(String rango1, String rango2);

  // 23. Obtener todos los jugadores ordenados por nickname de forma ascendente sin condición.
  List<Jugador> findAllByOrderByNickname(String nickname);




}
