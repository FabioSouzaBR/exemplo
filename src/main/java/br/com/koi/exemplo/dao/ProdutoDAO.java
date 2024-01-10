package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer>

{
    public boolean existsByDescricao (String descricao);
}

