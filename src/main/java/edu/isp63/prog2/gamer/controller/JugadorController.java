package edu.isp63.prog2.gamer.controller;

import edu.isp63.prog2.gamer.dto.JugadorCreateDTO;
import edu.isp63.prog2.gamer.dto.JugadorResponseDTO;
import edu.isp63.prog2.gamer.service.JugadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
