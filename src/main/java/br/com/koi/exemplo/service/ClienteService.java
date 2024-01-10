package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.ClienteDAO;
import br.com.koi.exemplo.model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService
{
    @Autowired
    private ClienteDAO dao;

    @Transactional
    public Cliente save(Cliente cliente) {
        return dao.save(cliente);
    }

    public List<Cliente> findAll() {
        return dao.findAll();
    }

    public Optional<Cliente> findById(Integer codigo) {
        return dao.findById(codigo);
    }

    @Transactional
    public void delete(Cliente cliente)
    {
         dao.delete(cliente);
    }
}
