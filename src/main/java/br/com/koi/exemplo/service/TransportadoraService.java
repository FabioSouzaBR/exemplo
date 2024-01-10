package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.TransportadoraDAO;
import br.com.koi.exemplo.model.Transportadora;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportadoraService

{
    @Autowired
    private TransportadoraDAO dao;

    @Transactional
    public Transportadora save(Transportadora transportadora)
    {
        return dao.save(transportadora);
    }

    public List<Transportadora> findAall()
    {
        return dao.findAll();
    }

    public Optional<Transportadora> findById(Integer codigo)
    {
        return dao.findById(codigo);
    }

    @Transactional
    public void delete(Transportadora transportadora)
    {
        dao.delete(transportadora);
    }

}

