package com.biolab.ecommerce.DTOs;

import com.biolab.ecommerce.entities.ItemDoPedidoPK;
import com.biolab.ecommerce.entities.Pedido;
import com.biolab.ecommerce.entities.Produto;
import jakarta.persistence.EmbeddedId;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedidoDTO {
    private int quantidade;
    private double preco;
    @EmbeddedId
    private ItemDoPedidoPK id = new ItemDoPedidoPK();

    public ItemDoPedidoDTO(int quantidade, double preco, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        id.setPedido(pedido);
        id.setProduto(produto);
    }
}
