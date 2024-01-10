package br.com.koi.exemplo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusControler
{
    @GetMapping(path = "/api/exempo/status")
    public String status()
    {
        return "OK";

    }

}
