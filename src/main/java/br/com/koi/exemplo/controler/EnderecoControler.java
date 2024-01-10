package br.com.koi.exemplo.controler;


import br.com.koi.exemplo.dto.EnderecoDTO;
import br.com.koi.exemplo.model.Endereco;
import br.com.koi.exemplo.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EnderecoControler
{
    @Autowired
    private EnderecoService service;

    @PostMapping(path = "/api/exemplo/endereco")
    public ResponseEntity<Endereco> inserirEndereco (@RequestBody @Valid EnderecoDTO dto)
    {
        var enderecoModel = new Endereco ();
        BeanUtils.copyProperties(dto, enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(enderecoModel));
    }

    @GetMapping (path="/api/exemplo/endereco")
    public ResponseEntity<List<Endereco>> selececionarTodos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(path = "/api/exemplo/endereco/{codigo}")
    public ResponseEntity<Object> selecionarEndereco (@PathVariable(name="codigo") Integer codigo)
    {
        Optional<Endereco> enderecoOptional = service.findById(codigo);
        if (!enderecoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enderecp nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoOptional.get());
    }


    @DeleteMapping(path = "/api/exemplo/endereco/{codigo}")
    public ResponseEntity<Object> deletarEndereco (@PathVariable(name="codigo") Integer codigo)
    {

        Optional<Endereco> enderecoOptional = service.findById(codigo);
        if (!enderecoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enderecp nao encontrado");
        }
        service.delete (enderecoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereco excluido com sucesso");
    }

    @PutMapping(path = "/api/exemplo/endereco/{codigo}")
    public ResponseEntity<Object>  alterarEndereco (@PathVariable(name="codigo") Integer codigo,
                                                    @RequestBody @Valid EnderecoDTO dto) {

        Optional<Endereco> enderecoOptional = service.findById(codigo);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enderecp nao encontrado");
        }
        var enderecoModel = new Endereco();
        BeanUtils.copyProperties(dto, enderecoModel);
        enderecoModel.setCodend(enderecoOptional.get().getCodend());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(enderecoModel));
    }
}
