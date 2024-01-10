package br.com.koi.exemplo.controler;

import br.com.koi.exemplo.dto.ImpostoDTO;
import br.com.koi.exemplo.model.Imposto;
import br.com.koi.exemplo.service.ImpostoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ImpostoControler
{
    @Autowired
    private ImpostoService service;

    @PostMapping(path = "/api/exemplo/imposto")
    public ResponseEntity<Imposto> inserirImposto (@RequestBody @Valid ImpostoDTO dto)
    {
      var impostoModel = new Imposto();
        BeanUtils.copyProperties(dto,impostoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(impostoModel));
    }

    @GetMapping(path="/api/exemplo/imposto")
    public ResponseEntity<List<Imposto>> consultarImpostos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }


    @GetMapping(path="/api/exemplo/imposto/{codigo}")
    public ResponseEntity< Object> consultarImposto(@PathVariable (name = "codigo") Integer codigo)
    {
        Optional<Imposto> impostoOptional = service.findById(codigo);
        if (!impostoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("imposto nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(impostoOptional.get());
    }


    @DeleteMapping(path="/api/exemplo/imposto/{codigo}")
    public ResponseEntity< Object> excluirImposto(@PathVariable (name = "codigo") Integer codigo)
    {
        Optional<Imposto> impostoOptional = service.findById(codigo);
        if (!impostoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("imposto nao encontrado");
        }
        service.deleteImposto(impostoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("imposto excluido com sucesso");
    }


    @PutMapping(path="/api/exemplo/imposto/{codigo}")
    public ResponseEntity< Object> alterarImposto(@PathVariable (name = "codigo") Integer codigo,
                                                  @RequestBody @Valid ImpostoDTO dto)
    {
        Optional<Imposto> impostoOptional = service.findById(codigo);
        if (!impostoOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("imposto nao encontrado");
        }
        var impostoModel = new Imposto();
        BeanUtils.copyProperties(dto, impostoModel);
        impostoModel.setCodigo(impostoOptional.get().getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(impostoModel));
    }
}
