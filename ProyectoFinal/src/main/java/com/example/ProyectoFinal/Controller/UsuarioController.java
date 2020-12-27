package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Usuario;
import com.example.ProyectoFinal.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public Page<Usuario> getPage(Pageable pageable) {
        return usuarioService.findAll(pageable);
    }
    //create a new user
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    //read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long usuarioId){
        Optional<Usuario> oUsuario= usuarioService.findById(usuarioId);
        if(!oUsuario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUsuario);
    }

    // Update an User
    @PutMapping("/{id]")
    public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
        Optional<Usuario> usuario = usuarioService.findById(usuarioId);
        if(!usuario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        usuario.get().setNombre(usuarioDetails.getNombre());
        usuario.get().setEmail(usuarioDetails.getEmail());
        usuario.get().setPassword(usuarioDetails.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
    }

    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long usuarioId) {
        if(!usuarioService.findById(usuarioId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteById(usuarioId);
        return ResponseEntity.ok().build();
    }
}