package com.example.api.Controllers;

import com.example.api.Models.dao.IResenasDAO;
import com.example.api.Models.entidades.EntidadResenas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resenas")
public class ControllerResenas {

    private final IResenasDAO resenasDAO;

    @Autowired
    public ControllerResenas(IResenasDAO resenasDAO) {
        this.resenasDAO = resenasDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadResenas> obtenerResenaPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadResenas> resena = resenasDAO.findById(id);
        return resena.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntidadResenas> crearResena(@Validated @RequestBody EntidadResenas nuevaResena) {
        EntidadResenas resenaCreada = resenasDAO.save(nuevaResena);
        return ResponseEntity.status(HttpStatus.CREATED).body(resenaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadResenas> actualizarResena(@Validated @RequestBody EntidadResenas resenaActualizar,
                                                           @PathVariable(value = "id") int id) {
        Optional<EntidadResenas> optionalResenaExistente = resenasDAO.findById(id);
        if (optionalResenaExistente.isPresent()) {
            EntidadResenas resenaExistente = optionalResenaExistente.get();
            // Actualizar los campos de la reseña existente con los valores de la reseña a actualizar
            resenaExistente.setPuntuacion(resenaActualizar.getPuntuacion());
            resenaExistente.setComentario(resenaActualizar.getComentario());

            // Guardar la reseña actualizada en la base de datos
            EntidadResenas resenaActualizada = resenasDAO.save(resenaExistente);
            return ResponseEntity.ok().body(resenaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarResena(@PathVariable(value = "id") int id) {
        Optional<EntidadResenas> optionalResenaExistente = resenasDAO.findById(id);
        if (optionalResenaExistente.isPresent()) {
            resenasDAO.deleteById(id);
            return ResponseEntity.ok().body("{\"status\": \"Reseña eliminada\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
