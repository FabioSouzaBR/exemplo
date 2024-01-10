package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.ItemPedidoDAO;
import br.com.koi.exemplo.model.ItemPedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService

{
    @Autowired
    private ItemPedidoDAO dao;

    @Transactional
    public ItemPedido save(ItemPedido itempedido)
    {
        return dao.save(itempedido);
    }

    public List<ItemPedido> findAll()
    {
        return dao.findAll();
    }

    public Optional<ItemPedido> findById(Integer numped)
    {
        return dao.findById(numped);
    }
    @Transactional
    public void delete(ItemPedido itempedido) {
        dao.delete(itempedido   );
    }
}
