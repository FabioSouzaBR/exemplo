package br.com.koi.exemplo.controler;

import br.com.koi.exemplo.dto.ItemPedidoDTO;
import br.com.koi.exemplo.model.ItemPedido;
import br.com.koi.exemplo.service.ItemPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemPedidoControler
{
    @Autowired
    public ItemPedidoService service;

    @PostMapping(path="/api/exemplo/itempedido")
    public ResponseEntity <ItemPedido> inserirItemPedido (@RequestBody @Valid ItemPedidoDTO dto)
    {
        var itempedidoModel = new ItemPedido();
        BeanUtils.copyProperties(dto,itempedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(itempedidoModel));
    }

    @GetMapping(path="/api/exemplo/itempedido")
    public ResponseEntity <List<ItemPedido>> selecionarTodos()
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findAll());
    }

    @GetMapping(path="/api/exemplo/itempedido/{codigo}")
    public ResponseEntity <Object> selecionarItemPedido(@PathVariable(name ="codigo") Integer codigo)
    {
        Optional<ItemPedido> itempedidoOptional = service.findById(codigo);
        if(!itempedidoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(itempedidoOptional.get());
    }

    @DeleteMapping(path="/api/exemplo/itempedido/{codigo}")
    public ResponseEntity <Object> apagarItemPedido(@PathVariable(name ="codigo") Integer codigo) {
        Optional<ItemPedido> itempedidoOptional = service.findById(codigo);
        if (!itempedidoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item nao encontrado");
        }
        service.delete(itempedidoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item pedido excluido com sucesso");

    }

    @PutMapping(path="/api/exemplo/itempedido/{codigo}")
    public ResponseEntity <Object> selecionarItemPedido(@PathVariable(name ="codigo") Integer codigo,
                                                        @RequestBody @Valid ItemPedidoDTO dto)
    {
        Optional<ItemPedido> itempedidoOptional = service.findById(codigo);
        if (!itempedidoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item nao encontrado");
        }

        var itempedidoModel = new ItemPedido();
        BeanUtils.copyProperties(dto, itempedidoModel);
        itempedidoModel.setCodprod(itempedidoOptional.get().getCodprod());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(itempedidoModel));
    }
}
