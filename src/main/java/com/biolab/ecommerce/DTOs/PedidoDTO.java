package com.biolab.ecommerce.DTOs;

import com.biolab.ecommerce.entities.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private long id;
    private Instant momento;
    private StatusPedido status;
    private long idCliente;

    public PedidoDTO(long idCliente) {
        this.momento = Instant.now(); // coloca o momento do pedido automaticamente
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO; // coloca automaticamente o status como aguardando
        this.idCliente = idCliente;
    }


}
