package com.example.api.Models.dao;

import com.example.api.Models.entidades.EntidadMascotas;
import org.springframework.data.repository.CrudRepository;

public interface IMascotasDAO extends CrudRepository<EntidadMascotas, Integer> {
}
