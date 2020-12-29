package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Usuario;
import com.example.ProyectoFinal.Entity.Post;
import com.example.ProyectoFinal.Services.UsuarioService;
import com.example.ProyectoFinal.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PostService postService;
    @GetMapping()
    public Page<Usuario> getPage(Pageable pageable) {
        return usuarioService.findAll(pageable);
    }
    //crear nuevo usuario
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    //obtener todos los usuarios
   @GetMapping()
    public ResponseEntity<?> getUsuario() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK); }

   @GetMapping("/searchCiudad")
    public ResponseEntity<?> usuarioPorCiudad (@RequestParam String ciudad) {
        List<Usuario> usuario= usuarioService.findByCiudad(ciudad);
       return new ResponseEntity<>(usuario, HttpStatus.OK); }

   @GetMapping("/searchFecha")
   public ResponseEntity<?> usuarioPorFecha (@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Usuario> usuario = usuarioService.findByDate(date);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
   }


    //modificar un usuario segun id
    @PutMapping("/usuario")
    public ResponseEntity<?> editUsuario (@RequestBody Usuario usuarioDetails, @PathVariable Long usuarioId) {
        Optional<Usuario> usuario = usuarioService.findById(usuarioId);
        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.get().setNombre(usuarioDetails.getNombre());
        usuario.get().setApellido(usuarioDetails.getApellido());
        usuario.get().setEmail(usuarioDetails.getEmail());
        usuario.get().setPassword(usuarioDetails.getPassword());
        usuario.get().setCiudad(usuarioDetails.getCiudad());
        usuario.get().setProvincia(usuarioDetails.getProvincia());
        usuario.get().setPais(usuarioDetails.getPais());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));

    }

    //borrar un usuario segun id
    @DeleteMapping("/{usuarioId}")
    public  ResponseEntity<?> deleteUsuario (@PathVariable Long usuarioId) {
        usuarioService.deleteById(usuarioId);
        return ResponseEntity.ok().build();
    }



    //crear un nuevo post
    @PostMapping("/{usuarioId}/post")
    public ResponseEntity<?> crearPostUsuario (@PathVariable Long usuarioId, @RequestBody Post postDetails) {
        Optional<Usuario> usuario = usuarioService.findById(usuarioId);
        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuario.get().addPost(postDetails);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
    }
}