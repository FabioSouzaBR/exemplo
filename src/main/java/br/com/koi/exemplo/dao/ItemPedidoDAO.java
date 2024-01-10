package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoDAO extends JpaRepository<ItemPedido, Integer>
{
    public boolean existsByproduto(Integer numprod);
}
