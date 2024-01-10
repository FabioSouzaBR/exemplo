package br.com.koi.exemplo.controler;


import br.com.koi.exemplo.dto.UsuarioDTO;
import br.com.koi.exemplo.model.Usuario;
import br.com.koi.exemplo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioControler {
    @Autowired
    private UsuarioService service;

    @PostMapping(path = "/api/exemplo/usuario")
    public ResponseEntity<Object> inserirUsuario(@RequestBody @Valid UsuarioDTO dto) {
        if (service.existeLogin(dto.getLogin())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ja existe usuario com este login");
        }
        var usuarioModel = new Usuario();
        BeanUtils.copyProperties(dto, usuarioModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioModel));
    }



    @GetMapping(path = "/api/exemplo/usuario/{codigo}")
    public ResponseEntity<Object> consultaUsuario(@PathVariable(value = "codigo") Integer codigo)
    {
        Optional<Usuario> optionalUsuario = service.findById(codigo);
        if ( !optionalUsuario.isPresent())
        {
            return ResponseEntity.status(HttpStatus.OK).body("Usuario nao existe com esta codigo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalUsuario);
    }

    @DeleteMapping(path = "/api/exemplo/usuario/{codigo}")
    public ResponseEntity<Object> excluirUsuario(@PathVariable(value = "codigo") Integer codigo)
    {
        Optional<Usuario> optionalUsuario = service.findById(codigo);
        if ( !optionalUsuario.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao existe com esta codigo");
        }
        service.delete(optionalUsuario.get());
        return ResponseEntity.status(HttpStatus.OK).body("usuario excluido com sucesso");
    }


    @PutMapping(path = "/api/exemplo/usuario/{codigo}")
    public ResponseEntity<Object> alterarUsuario(@PathVariable(value = "codigo") Integer codigo,
                                                 @RequestBody @Valid UsuarioDTO dto)
    {
        Optional<Usuario> optionalUsuario = service.findById(codigo);
        if (!optionalUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao existe com esta codigo");
        }
        var usuarioModel = new Usuario();
        BeanUtils.copyProperties(dto, usuarioModel);
        usuarioModel.setCodigo(optionalUsuario.get().getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(usuarioModel));
    }

}