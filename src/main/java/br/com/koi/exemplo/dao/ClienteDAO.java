package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>

{
    public boolean existsByNome(String nome);
}
