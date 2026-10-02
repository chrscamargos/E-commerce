package com.biolab.ecommerce.services;

import org.springframework.stereotype.Service;

@Service
public class ItemDoPedidoService {
    private final PedidoService pedidoService;
    private final ProdutoService produtoService;

    public ItemDoPedidoService(PedidoService pedidoService, ProdutoService produtoService) {
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;
    }


}
