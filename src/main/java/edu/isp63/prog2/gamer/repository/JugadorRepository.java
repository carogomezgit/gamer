package edu.isp63.prog2.gamer.repository;


import edu.isp63.prog2.gamer.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
  // se utiliza camelCase para realizar las consultas derivadas
  // busca un jugador por nombre de usuario
  Optional<Jugador> getByNickname(String nickname);

  // si termina con variable nickname ignorando case "S" o con "s"
  Optional<Jugador> getByNicknameEndsWithIgnoreCase(String nickname);

  // busca todos los jugadores que coincida con el rango del string exacto
  List<Jugador> findByRango(String rango);

  // busca todos los jugadores que coincida con el rango del string
  // en alguna parte
  // ordeno por nickname de manera descendiente
  List<Jugador> findByRangoContainingOrderByNicknameDesc (String rango);

  // verifica que existe el email y devuelve true o false
  Boolean existsByEmail(String email);

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


}
