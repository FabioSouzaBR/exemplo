package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalDAO extends JpaRepository<NotaFiscal, Integer>

{
    public boolean existsByNumero(Integer numero);
}
