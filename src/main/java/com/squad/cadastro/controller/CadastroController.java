package com.squad.cadastro.controller;

import com.squad.cadastro.controller.dto.Cliente;
import com.squad.cadastro.validator.DocumentoValidatorInterface;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin("https://frontend-register-app-squad-cadastro.vercel.app/")
public class CadastroController {
    DocumentoValidatorInterface documentoValidatorInterface;

    public CadastroController(DocumentoValidatorInterface documentoValidatorInterface) {
        this.documentoValidatorInterface = documentoValidatorInterface;
    }

    @GetMapping("/hello")
    public String helloDev() {
        sum(2, 3);
        return "Hello developer \n Este é um exemplo de como fazer uma chamada GET utilizando protocolo HTTP";

    }

    @PostMapping("/sum/{a}/{b}")
    public String sum(@PathVariable Integer a, @PathVariable Integer b) {
        return String.valueOf(a+b);
    }

    @PostMapping("/clientes")
    public Cliente create(@RequestBody Cliente cliente){
        cliente.setId(String.valueOf(UUID.randomUUID()));
        var result = documentoValidatorInterface.validarCPF(cliente.getDocumento());
        if (!result){
            System.out.println("Documento invalido");
        }
        return cliente;
    }
}
