package com.biolab.ecommerce.controller;

import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody ProdutoDTO dto){
       return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProdId(@PathVariable long id){
        return ResponseEntity.ok().body(produtoService.buscarProdutoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> mostrarProds(){
        return ResponseEntity.ok(produtoService.mostrarProdutos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarProd(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        return ResponseEntity.ok(produtoService.editarProduto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletearProd (@PathVariable Long id){
        produtoService.apagarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
