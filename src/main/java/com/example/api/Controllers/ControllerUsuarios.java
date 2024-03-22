package com.example.api.Controllers;

import com.example.api.Models.dao.IUsuariosDAO;
import com.example.api.Models.entidades.EntidadMascotas;
import com.example.api.Models.entidades.EntidadUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class ControllerUsuarios {

    private final IUsuariosDAO usuariosDAO;

    @Autowired
    public ControllerUsuarios(IUsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadUsuarios> obtenerUsuarioPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadUsuarios> usuario = usuariosDAO.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PutMapping("/{id}")
    public ResponseEntity<EntidadUsuarios> actualizarUsuario(@Validated @RequestBody EntidadUsuarios nuevoUsuario,
                                                             @PathVariable(value = "id") int id) {
        Optional<EntidadUsuarios> usuarioExistente = usuariosDAO.findById(id);
        if (usuarioExistente.isPresent()) {
            EntidadUsuarios usuario = usuarioExistente.get();
            usuario.setNombre(nuevoUsuario.getNombre());
            // Aquí actualizarías el resto de los campos según lo necesites

            EntidadUsuarios usuarioActualizado = usuariosDAO.save(usuario);
            return ResponseEntity.ok().body(usuarioActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") int id) {
        Optional<EntidadUsuarios> usuarioExistente = usuariosDAO.findById(id);
        if (usuarioExistente.isPresent()) {
            usuariosDAO.deleteById(id);
            return ResponseEntity.ok().body("{\"status\": \"Usuario eliminado\"}");
        }
        return ResponseEntity.notFound().build();
    }
}
