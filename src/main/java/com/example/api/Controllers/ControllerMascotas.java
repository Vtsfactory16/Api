package com.example.api.Controllers;

import com.example.api.Models.dao.IMascotasDAO;
import com.example.api.Models.entidades.EntidadMascotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mascotas")
public class ControllerMascotas {

    private final IMascotasDAO mascotasDAO;

    @Autowired
    public ControllerMascotas(IMascotasDAO mascotasDAO) {
        this.mascotasDAO = mascotasDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadMascotas> obtenerMascotaPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadMascotas> mascota = mascotasDAO.findById(id);
        return mascota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<EntidadMascotas>> obtenerMascotasPorUsuario(@PathVariable(value = "idUsuario") Integer idUsuario) {
        List<EntidadMascotas> mascotas = mascotasDAO.findByUsuariosByIdUsuarioId(idUsuario);
        return ResponseEntity.ok().body(mascotas);
    }


    @PostMapping
    public ResponseEntity<EntidadMascotas> crearMascota(@Validated @RequestBody EntidadMascotas mascota) {
        EntidadMascotas nuevaMascota = mascotasDAO.save(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadMascotas> actualizarMascota(@Validated @RequestBody EntidadMascotas nuevaMascota,
                                                             @PathVariable(value = "id") int id) {
        Optional<EntidadMascotas> mascotaExistente = mascotasDAO.findById(id);
        if (mascotaExistente.isPresent()) {
            EntidadMascotas mascota = mascotaExistente.get();
            mascota.setNombre(nuevaMascota.getNombre());
            mascota.setRaza(nuevaMascota.getRaza());
            mascota.setPeso(nuevaMascota.getPeso());
            mascota.setEdad(nuevaMascota.getEdad());
            mascota.setDescripcion(nuevaMascota.getDescripcion());
            // Puedes continuar actualizando los demás campos según sea necesario

            EntidadMascotas mascotaActualizada = mascotasDAO.save(mascota);
            return ResponseEntity.ok().body(mascotaActualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMascota(@PathVariable(value = "id") int id) {
        Optional<EntidadMascotas> mascotaExistente = mascotasDAO.findById(id);
        if (mascotaExistente.isPresent()) {
            mascotasDAO.deleteById(id);
            return ResponseEntity.ok().body("{\"status\": \"Mascota eliminada\"}");
        }
        return ResponseEntity.notFound().build();
    }
}
