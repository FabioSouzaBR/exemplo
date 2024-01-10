package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Integer>
{

    boolean existsByCep(String cep);

}
