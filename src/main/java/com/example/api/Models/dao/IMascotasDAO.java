package com.example.api.Models.dao;

import com.example.api.Models.entidades.EntidadMascotas;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMascotasDAO extends CrudRepository<EntidadMascotas, Integer> {
    List<EntidadMascotas> findByUsuariosByIdUsuarioId(Integer idUsuario);
}
