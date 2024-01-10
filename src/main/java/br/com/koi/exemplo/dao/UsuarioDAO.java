package br.com.koi.exemplo.dao;

import br.com.koi.exemplo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario,Integer>
{
    public boolean existsByLogin(String Login);

}


