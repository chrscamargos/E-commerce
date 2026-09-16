package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.entities.Categoria;
import com.biolab.ecommerce.entities.Produto;
import com.biolab.ecommerce.repositories.CategoriaRepository;
import com.biolab.ecommerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public String criarProduto(ProdutoDTO dto){
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setPreco(dto.getPreco());
        p.setImgUrl(dto.getImgUrl());
        Categoria cat = categoriaRepository.getReferenceById(dto.getId_categoria());
        p.getCategorias().add(cat);
        produtoRepository.save(p);
        return "produto salvo com sucesso";
    }

    public String apagarProduto(long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()){
            return "produto não encontrado";
        } else {
            produtoRepository.deleteById(id);
            return "produto excluído com sucesso";
        }
    }

    public ProdutoDTO buscarProdutoPorId(long id){
        Produto produto = produtoRepository.findById(id).orElseThrow();
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setId(produto.getId());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setImgUrl(produto.getImgUrl());
        return produtoDTO;
    }

    public List<ProdutoDTO> mostrarProdutos (){
        return produtoRepository.findAll().stream().map(produto -> new ProdutoDTO(produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getImgUrl(), produto.getId())).toList();
    }

    public String editarProduto(long id, ProdutoDTO dto){
        Produto editarProd = produtoRepository.findById(id).orElseThrow();
        editarProd.setNome(dto.getNome());
        editarProd.setDescricao(dto.getDescricao());
        editarProd.setPreco(dto.getPreco());
        editarProd.setImgUrl(dto.getImgUrl());
        produtoRepository.save(editarProd);
        return "Produto editado com sucesso";
    }
}
