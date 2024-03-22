package com.example.api.Models.dao;

import com.example.api.Models.entidades.EntidadUsuarios;
import org.springframework.data.repository.CrudRepository;

public interface IUsuariosDAO extends CrudRepository<EntidadUsuarios, Integer> {
}
