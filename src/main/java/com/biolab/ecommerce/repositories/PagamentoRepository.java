package com.biolab.ecommerce.repositories;

import com.biolab.ecommerce.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {

}
