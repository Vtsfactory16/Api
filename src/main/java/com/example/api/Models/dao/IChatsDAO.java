package com.example.api.Models.dao;

import com.example.api.Models.entidades.EntidadChats;
import org.springframework.data.repository.CrudRepository;

public interface IChatsDAO extends CrudRepository<EntidadChats, Integer>{
}
