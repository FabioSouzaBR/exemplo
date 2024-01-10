package br.com.koi.exemplo.controler;

import br.com.koi.exemplo.dto.TransportadoraDTO;
import br.com.koi.exemplo.model.Transportadora;
import br.com.koi.exemplo.service.TransportadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransportadoraControler
{

    @Autowired
    public TransportadoraService service;

    @PostMapping(path = "/api/exemplo/transportadora")
    public ResponseEntity<Transportadora> inserirTransportadora (@RequestBody @Valid TransportadoraDTO dto)
    {
        var transportadoraModel = new Transportadora();
        BeanUtils.copyProperties(dto, transportadoraModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transportadoraModel));
    }

    @GetMapping(path = "/api/exemplo/transportadora")
    public ResponseEntity<List<Transportadora>> selecionarTodos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAall());
    }

    @GetMapping(path = "/api/exemplo/transportadora{codigo}")
    public ResponseEntity<Object> selecionarTransportadora(@PathVariable(name ="codigo" ) Integer codigo)
    {
        Optional<Transportadora> transportadoraOptional = service.findById(codigo);
        if( !transportadoraOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transportadora nao encontrada");

        }
        return ResponseEntity.status(HttpStatus.OK).body(transportadoraOptional.get());
    }

    @DeleteMapping(path = "/api/exemplo/transportadora/{codigo}")
    public ResponseEntity<Object> excluirTransportadora(@PathVariable(name ="codigo" ) Integer codigo)
    {
        Optional<Transportadora> transportadoraOptional = service.findById(codigo);
        if (!transportadoraOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transportadora nao encontrada");

        }
        service.delete(transportadoraOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("transportadora excluida com sucesso");
    }

    @PutMapping(path = "/api/exemplo/transportadora/{codigo}")
    public ResponseEntity<Object> alterarTransportadora(@PathVariable(name ="codigo" ) Integer codigo ,
                                                        @RequestBody @Valid TransportadoraDTO dto)
    {
        Optional<Transportadora> transportadoraOptional = service.findById(codigo);
        if (!transportadoraOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transportadora nao encontrada");

        }
        var transportadoraModel = new Transportadora();
        BeanUtils.copyProperties(dto,transportadoraModel);
        transportadoraModel.setCodtransp(transportadoraOptional.get().getCodtransp());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(transportadoraModel));

    }
}
