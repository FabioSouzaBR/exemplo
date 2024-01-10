package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDAO extends JpaRepository<Pedido, Integer>

{
    public boolean existsByNumero(Integer numero);
}
