package br.com.koi.exemplo.controler;

import br.com.koi.exemplo.dto.ProdutoDTO;
import br.com.koi.exemplo.model.Produto;
import br.com.koi.exemplo.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProdutoControler
{
    @Autowired
    private ProdutoService service;

    @PostMapping(path = "/api/exemplo/produto")
    public ResponseEntity<Produto> inserirProduto (@RequestBody @Valid ProdutoDTO dto)
    {
        var produtoModel = new Produto();
        BeanUtils.copyProperties(dto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produtoModel));

    }


    @GetMapping(path = "/api/exemplo/produto")
    public ResponseEntity<List<Produto>> selecionarTodos ()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(path = "/api/exemplo/produto/{codigo}")
    public ResponseEntity<Object> selecionarProduto (@PathVariable (name="codigo") Integer codigo)
    {
        Optional<Produto> produtoOptional = service.findById(codigo);
        if (!produtoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao existe");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
    }

    @DeleteMapping(path = "/api/exemplo/produto/{codigo}")
    public ResponseEntity<Object> excluirProduto (@PathVariable(name = "codigo") Integer codigo)
    {
        Optional<Produto> produtoOptional = service.findById(codigo);
        if (!produtoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao existe");
        }
        service.deleteProduto(produtoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido com sucesso");
    }

    @PutMapping(path = "/api/exemplo/produto/{codigo}")
    public ResponseEntity<Object> alterarProduto (@PathVariable(name = "codigo") Integer codigo,
                                                  @RequestBody @Valid ProdutoDTO dto)
    {
        Optional<Produto> produtoOptional = service.findById(codigo);
        if (!produtoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao existe");
        }
        var produtoModel = new Produto();
        BeanUtils.copyProperties(dto ,  produtoModel);
        produtoModel.setCodprod(produtoOptional.get().getCodprod());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(produtoModel));
    }
}
