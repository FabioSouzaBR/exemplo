package br.com.koi.exemplo.service;

import br.com.koi.exemplo.dao.UsuarioDAO;
import br.com.koi.exemplo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService
{
    @Autowired
    private UsuarioDAO dao;

    @Transactional
    public Usuario save(Usuario usuario)
    {
       return dao.save(usuario);
    }

    public boolean existeLogin(String login) {
        return dao.existsByLogin(login);
    }

    public List<Usuario> findall()
    {
        return dao.findAll();
    }

    public Optional<Usuario> findById(Integer codigo)
    {
        return dao.findById(codigo);
    }

    @Transactional
    public void delete(Usuario usuario)
    {
       dao.delete(usuario);
    }
}
