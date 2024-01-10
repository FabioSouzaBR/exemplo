package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.ProdutoDAO;
import br.com.koi.exemplo.model.Produto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoDAO dao;

    @Transactional
    public Produto save (Produto produto)
    {
        return dao.save(produto);

    }

    public boolean existeProduto(String descricao){
        return dao.existsByDescricao(descricao);

    }

    public List<Produto> findAll(){
        return dao.findAll();
    }

    public Optional<Produto> findById(Integer codigo){
        return dao.findById(codigo);
    }

    @Transactional
    public void deleteProduto(Produto produto)
    {
        dao.delete (produto);
    }

}
