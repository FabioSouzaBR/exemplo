package br.com.koi.exemplo.dao;


import br.com.koi.exemplo.model.Endereco;
import br.com.koi.exemplo.model.Imposto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpostoDAO extends JpaRepository<Imposto, Integer>
{

    boolean existsByDescricao(String descricao);

}