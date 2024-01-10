package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.NotaFiscalDAO;
import br.com.koi.exemplo.model.NotaFiscal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalService
{
    @Autowired
    private NotaFiscalDAO dao;

    @Transactional
    public NotaFiscal save(NotaFiscal notafiscal)
    {
        return dao.save(notafiscal);
    }

    public List<NotaFiscal> findAll()
    {
        return dao.findAll();
    }

    public Optional<NotaFiscal> findById(Integer numero)
    {
        return dao.findById(numero);
    }

    @Transactional
    public void delete(NotaFiscal notafiscal)
    {
        dao.delete(notafiscal);
    }
}
