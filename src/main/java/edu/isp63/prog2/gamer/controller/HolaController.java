package edu.isp63.prog2.gamer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

  // son puntos de acceso o endpoints
  // la operacion es get Y la url es /mensajes
  @GetMapping("/mensajes")
  public String saludar() {
    return "Hola mundo spring boot en gamerAppliction";
  }

  @GetMapping("/mensajes/{nombre}")
  public String saludar(@PathVariable String nombre) {
    return "Hola mundo spring boot en gamerApplication " + nombre;
  }

}
