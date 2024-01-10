package br.com.koi.exemplo.controler;

import br.com.koi.exemplo.dto.NotaFiscalDTO;
import br.com.koi.exemplo.model.NotaFiscal;
import br.com.koi.exemplo.service.NotaFiscalService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NotaFiscalControler

{
    @Autowired
    public NotaFiscalService service;

    @PostMapping(path = "/api/exemplo/notafiscal")
    public ResponseEntity <NotaFiscal> inserirNotaFiscal (@RequestBody @Valid NotaFiscalDTO dto)
    {
        var notafiscalModel = new NotaFiscal();
        BeanUtils.copyProperties(dto,notafiscalModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(notafiscalModel));
    }

    @GetMapping(path = "/api/exemplo/notafiscal")
    public ResponseEntity <List<NotaFiscal>> selecionarTodos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(path = "/api/exemplo/notafiscal/{codigo}")
    public ResponseEntity <Object> selecionarNotalFiscal(@PathVariable (name = "codigo") Integer codigo)
    {
        Optional<NotaFiscal> notafiscalOptional = service.findById(codigo);
        if(!notafiscalOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota Fiscal nao encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(notafiscalOptional.get());

    }

    @DeleteMapping(path = "/api/exemplo/notafiscal/{codigo}")
    public ResponseEntity <Object> apagarNotalFiscal(@PathVariable (name = "codigo") Integer codigo)

    {
        Optional<NotaFiscal> notafiscalOptional = service.findById(codigo);
        if (!notafiscalOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota Fiscal nao encontrada");
        }

        service.delete(notafiscalOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido com sucesso");

    }

    @PutMapping(path = "/api/exemplo/notafiscal/{codigo}")
    public ResponseEntity <Object> alterarNotalFiscal(@PathVariable (name = "codigo") Integer codigo,
                                                         @RequestBody @Valid NotaFiscalDTO dto)
    {
        Optional<NotaFiscal> notafiscalOptional = service.findById(codigo);
        if (!notafiscalOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota Fiscal nao encontrada");
        }

        var notafiscalModel = new NotaFiscal();
        BeanUtils.copyProperties(dto, notafiscalModel);
        notafiscalModel.setNumero(notafiscalOptional.get().getNumero());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(notafiscalModel));
    }
}
