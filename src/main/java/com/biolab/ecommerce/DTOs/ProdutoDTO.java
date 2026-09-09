package com.biolab.ecommerce.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProdutoDTO {
    private long id;
    @NotBlank
    private String nome;
    private String descricao;
    @NotNull
    private double preco;
    private String imgUrl;
    private long id_categoria;

    public ProdutoDTO(String nome, String descricao, double preco, String imgUrl, long id_categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
        this.id_categoria = id_categoria;
    }
}
