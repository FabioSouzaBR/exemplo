package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.ImpostoDAO;
import br.com.koi.exemplo.model.Imposto;
import br.com.koi.exemplo.model.Produto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpostoService
{
    @Autowired
    private ImpostoDAO dao;

    @Transactional
    public Imposto save(Imposto imposto)
    {
        return dao.save (imposto);
    }

    public List<Imposto> findAll()
    {
        return dao.findAll();
    }

    public Optional<Imposto> findById(Integer codigo){
        return dao.findById(codigo);
    }

    @Transactional
    public void deleteImposto(Imposto imposto)
    {
        dao.delete (imposto);
    }

}
