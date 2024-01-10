package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.EnderecoDAO;
import br.com.koi.exemplo.model.Endereco;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService
{
    @Autowired
    private EnderecoDAO dao;

    @Transactional
    public Endereco save (Endereco endereco)
    {
        return dao.save (endereco);
    }

    public boolean existeEndereco (String cep)
    {
        return dao.existsByCep(cep);

    }

    public List<Endereco> findAll()
    {
        return dao.findAll();
    }

    public Optional<Endereco> findById(Integer codigo)
    {
        return dao.findById(codigo);

    }

    @Transactional
    public void delete (Endereco endereco)
    {
        dao.delete(endereco);
    }

}
