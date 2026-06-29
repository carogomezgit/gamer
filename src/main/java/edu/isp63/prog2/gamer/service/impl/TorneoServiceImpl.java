package edu.isp63.prog2.gamer.service.impl;

import edu.isp63.prog2.gamer.dto.TorneoCreateDTO;
import edu.isp63.prog2.gamer.dto.TorneoResponseDTO;
import edu.isp63.prog2.gamer.entity.Torneo;
import edu.isp63.prog2.gamer.repository.TorneoRepository;
import edu.isp63.prog2.gamer.service.TorneoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoServiceImpl implements TorneoService {
  // inyeccion de dependencia de torneo repository por constructor
  private TorneoRepository torneoRepository;

  public TorneoServiceImpl(TorneoRepository torneoRepository) {
    this.torneoRepository = torneoRepository;
  }

  @Override
  public List<TorneoResponseDTO> listarTodosTorneos(Integer torneoId) {
    return torneoRepository.findAll()
        .stream()
        .map(this::toResponseDTO)
        .toList();
  }

  @Override
  public TorneoResponseDTO crearTorneo(TorneoCreateDTO torneo) {
    Torneo torneoEntity = new Torneo();

    torneoEntity.setNombreTorneo(torneo.nombreTorneo());
    torneoEntity.setNombreJuego(torneo.nombreJuego());
    torneoEntity.setPlataforma(torneo.plataforma());
    torneoEntity.setCupo(torneo.cupo());
    torneoEntity.setPrecio(torneo.precio());

    // crear llamando al save
    Torneo torneoGuardado = torneoRepository.save(torneoEntity);
    // convertir torneo a torneoResponse
    TorneoResponseDTO torneoResponse = toResponseDTO(torneoGuardado);
    // devolver torneoResponse
    return torneoResponse;
  }

  @Override
  public List<TorneoResponseDTO> buscarPorNombre(String nombreTorneo) {
    return torneoRepository.findByNombreIgnoreCase(nombreTorneo)
        .stream()
        .map(this::toResponseDTO)
        .toList();
  }

  @Override
  public List<TorneoResponseDTO> buscarPorPlataforma(String plataforma) {
    return torneoRepository.findByPlataforma(plataforma)
        .stream()
        .map(this::toResponseDTO)
        .toList();
  }

  private TorneoResponseDTO toResponseDTO(Torneo torneo) {
    return new TorneoResponseDTO(torneo.getId(),
        torneo.getNombreTorneo(),
        torneo.getNombreJuego(),
        torneo.getPrecio(),
        torneo.getCupo(),
        torneo.getPlataforma());
  }
}
