package com.example.ProyectoFinal.Controller;

import com.example.ProyectoFinal.Entity.Post;
import com.example.ProyectoFinal.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    //obtener todos los post
    @GetMapping()
    public ResponseEntity<?> getPost() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> postPorTitulo (@RequestParam String titulo) {
        List<Post> postTitulo = postService.findByTitulo(titulo);
        return new ResponseEntity<>(postTitulo, HttpStatus.OK); }
/*
    @GetMapping("/searchPublicado")
    public ResponseEntity<?> postSinPublicar(@RequestParam Boolean published) {
        List<Post> postSinPublicar = postService.findNotPublished(published);
        return new ResponseEntity<>(postSinPublicar, HttpStatus.OK); }
*/
    //crear post
    @PostMapping
    public ResponseEntity<?> crearPost(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post)) ;}

    //modificar post por id
    @PutMapping("/{postId}")
    public ResponseEntity<?> editPost(@RequestBody Post postDetails, @PathVariable Long postId) {
        Optional<Post> post = postService.findById(postId);
        if (!post.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        post.get().setTitulo(postDetails.getTitulo());
        post.get().setDescripcion(postDetails.getDescripcion());
        post.get().setContenido(postDetails.getContenido());
        post.get().setPublicado(postDetails.getPublicado());
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post.get()));
    }

    //borrar post segun id
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return ResponseEntity.ok().build();
    }
}
