package br.com.koi.exemplo.controler;

import br.com.koi.exemplo.dto.ClienteDTO;
import br.com.koi.exemplo.model.Cliente;
import br.com.koi.exemplo.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteControler
{
    @Autowired
    public ClienteService service;

    @PostMapping(path="/api/exemplo/cliente")
    public ResponseEntity <Cliente> inserirCliente (@RequestBody @Valid ClienteDTO dto)
    {
        var clienteModel = new Cliente();
        BeanUtils.copyProperties(dto,clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteModel));
    }

    @GetMapping(path="/api/exemplo/cliente")
    public ResponseEntity<List<Cliente>> selecionarTodos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(path="/api/exemplo/cliente/{codigo}")
    public ResponseEntity<Object> selecionarCliente(@PathVariable (name = "codigo") Integer codigo)
    {
        Optional<Cliente> clienteOptional = service.findById(codigo);
        if( !clienteOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());

    }

    @DeleteMapping(path="/api/exemplo/cliente/{codigo}")
    public ResponseEntity<Object> excluirCliente(@PathVariable (name = "codigo") Integer codigo) {
        Optional<Cliente> clienteOptional = service.findById(codigo);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }
        service.delete(clienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido com sucesso");
    }

    @PutMapping(path="/api/exemplo/cliente/{codigo}")
    public ResponseEntity<Object> alterarrCliente(@PathVariable (name = "codigo") Integer codigo,
                                                  @RequestBody @Valid ClienteDTO dto)
    {
        Optional<Cliente> clienteOptional = service.findById(codigo);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }
        var clienteModel = new Cliente();
        BeanUtils.copyProperties(dto,clienteModel);
        clienteModel.setCodcli(clienteOptional.get().getCodcli());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(clienteModel));
    }

}
