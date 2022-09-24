package com.squad.cadastro.controller;

import com.squad.cadastro.controller.dto.Cliente;
import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.controller.dto.EnderecoResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin("https://frontend-register-app-squad-cadastro.vercel.app/")
public class CadastroController {

    @GetMapping("/cep/{cep}")
    public EnderecoResponse buscarEndereco(@PathVariable String cep){
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/"+ cep +"/json/", EnderecoResponse.class).getBody();
    }

    @PostMapping("/sum/{a}/{b}")
    public String sum(@PathVariable Integer a, @PathVariable Integer b) {
        return String.valueOf(a+b);
    }

    @PostMapping("/clientes")
    public ClienteDto create(@RequestBody ClienteDto cliente){
        cliente.setId(String.valueOf(UUID.randomUUID()));
        return cliente;
    }
}
