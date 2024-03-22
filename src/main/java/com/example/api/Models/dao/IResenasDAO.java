package com.example.api.Models.dao;

import com.example.api.Models.entidades.EntidadResenas;
import org.springframework.data.repository.CrudRepository;

public interface IResenasDAO extends CrudRepository<EntidadResenas, Integer>{
}
