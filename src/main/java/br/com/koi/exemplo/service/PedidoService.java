package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.NotaFiscalDAO;
import br.com.koi.exemplo.dao.PedidoDAO;
import br.com.koi.exemplo.model.NotaFiscal;
import br.com.koi.exemplo.model.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService
{
    @Autowired
    private PedidoDAO dao;

    @Transactional
    public Pedido save(Pedido pedido)
    {
        return dao.save(pedido);
    }

    public List<Pedido> findAll()
    {
        return dao.findAll();
    }

    public Optional<Pedido> findById(Integer numero)
    {
        return dao.findById(numero);
    }

    @Transactional
    public void delete(Pedido pedido)
    {
        dao.delete(pedido);
    }
}

