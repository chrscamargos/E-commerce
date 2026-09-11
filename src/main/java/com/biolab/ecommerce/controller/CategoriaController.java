package com.biolab.ecommerce.controller;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<?> criarCat(@RequestBody CategoriaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criarCategoria(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCat(@PathVariable long id){
        return ResponseEntity.ok().body(categoriaService.buscarCatId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCat (@PathVariable long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build(); //metodo de deletar retornando status code 204
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> mostrarCatergorias(){
        return ResponseEntity.ok(categoriaService.mostrarTodasCat());
    }
}
