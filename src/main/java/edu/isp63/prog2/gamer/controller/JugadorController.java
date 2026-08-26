package edu.isp63.prog2.gamer.controller;

import edu.isp63.prog2.gamer.dto.JugadorCreateDTO;
import edu.isp63.prog2.gamer.dto.JugadorResponseDTO;
import edu.isp63.prog2.gamer.service.JugadorService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jugadores")
public class JugadorController {
  // siempre el controlador inyecta service
  private final JugadorService jugadorService;

  public JugadorController(JugadorService jugadorService) {
    this.jugadorService = jugadorService;
  }

  @GetMapping
  List<JugadorResponseDTO> listaJugadores() {
    return jugadorService.listarTodosJugadores();
  }

  // post para crear, @requestbody para recibir un objeto
  // @valid para ejecutar las validaciones del objeto recibido
  @PostMapping
  JugadorResponseDTO crearJugador(@RequestBody JugadorCreateDTO jugador) {
    return jugadorService.crearJugador(jugador);
  }

  @PostMapping("/crear")
  ResponseEntity<JugadorResponseDTO> crearJugadorV2(@Valid @RequestBody JugadorCreateDTO jugador,
                                                    UriComponentsBuilder uriBuilder) {

    // 1. agrego en la firma del metodo ResponseEntity y UriComponentsBuilder
    // 2. guardo en una variable el responseDTO que devuelve el crear
    JugadorResponseDTO jugadorCreado = jugadorService.crearJugador(jugador);

    // 3. crear la url para identificar el objeto creado y devolverlo completo
    URI url = uriBuilder
        .path("/api/v1/jugadores/{id}")  // veo la ruta definida arriba
        .buildAndExpand(jugadorCreado.id()) // uso el dto anterior
        .toUri();

    // 4. devuelvo el responseEntity con la url y el jugador creado
    return ResponseEntity.created(url).body(jugadorCreado);
  }

  @GetMapping("/buscarporid")
  ResponseEntity<JugadorResponseDTO> buscarJugadorPorId(@RequestParam Integer id) {

    JugadorResponseDTO jugadorResponseDTO = jugadorService.buscarJugadorPorId(id);
    if (jugadorResponseDTO != null) {
      return ResponseEntity.ok(jugadorResponseDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/buscarporidv2")
  ResponseEntity<Optional<JugadorResponseDTO>> buscarJugadorPorIdv2(@RequestParam Integer id) {

    Optional<JugadorResponseDTO> jugadorResponseDTO = jugadorService.buscarJugadorPorIdv2(id);
    if (jugadorResponseDTO.isPresent()) {
      return ResponseEntity.ok(jugadorResponseDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
    /*
    return jugadorService.buscarJugadorPorIdv2(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
        
     */
  }

  @PutMapping("/{id}")
  public ResponseEntity<JugadorResponseDTO> actualizar
      (@PathVariable Integer id, @Valid @RequestBody JugadorCreateDTO jugador) {
    return jugadorService.actualizar(id, jugador)
        .map(ResponseEntity::ok) // si lo encontró, ok
        .orElseGet(() -> ResponseEntity.notFound().build()); // si no, notFound
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> eliminar(@PathVariable Integer id) {
    // uso operador ternario
    // si pudo eliminar devuelve no content, sino no encontrado
    return jugadorService.eliminarJugador(id)?
        ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
  }
}
