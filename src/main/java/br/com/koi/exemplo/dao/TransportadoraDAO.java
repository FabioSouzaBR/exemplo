package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadoraDAO extends JpaRepository<Transportadora, Integer>
{
    public boolean existsByNome(String nome);

}
