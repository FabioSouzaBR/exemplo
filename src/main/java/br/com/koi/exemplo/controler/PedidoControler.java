package br.com.koi.exemplo.controler;

import br.com.koi.exemplo.dto.PedidoDTO;
import br.com.koi.exemplo.model.Pedido;
import br.com.koi.exemplo.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidoControler
{
    @Autowired
    public PedidoService service;

    @PostMapping(path = "/api/exemplo/pedido")
    public ResponseEntity<Pedido> inserirPedido (@RequestBody @Valid PedidoDTO dto)
    {
        var pedidoModel = new Pedido();
        BeanUtils.copyProperties(dto,pedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidoModel));
    }

    @GetMapping(path = "/api/exemplo/pedido")
    public ResponseEntity <List<Pedido>> selecionarTodos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(path = "/api/exemplo/pedido/{codigo}")
    public ResponseEntity <Object> selecionarPedido(@PathVariable(name = "codigo") Integer codigo)
    {
        Optional<Pedido> pedidoOptional = service.findById(codigo);
        if(!pedidoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidoOptional.get());

    }

    @DeleteMapping(path = "/api/exemplo/pedido/{codigo}")
    public ResponseEntity <Object> apagarPedido(@PathVariable (name = "codigo") Integer codigo) {
        Optional<Pedido> pedidoOptional = service.findById(codigo);
        if (!pedidoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido nao encontrado");
        }

        service.delete(pedidoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pedido excluido com sucesso");

    }

    @PutMapping(path = "/api/exemplo/pedido/{codigo}")
    public ResponseEntity <Object> alterarPedido(@PathVariable (name = "codigo") Integer codigo,
                                                    @RequestBody @Valid PedidoDTO dto)
    {
        Optional<Pedido> pedidoOptional = service.findById(codigo);
        if (!pedidoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido nao encontrado");
        }

        var pedidoModel = new Pedido();
        BeanUtils.copyProperties(dto, pedidoModel);
        pedidoModel.setNumero(pedidoOptional.get().getNumero());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(pedidoModel));
    }
}
