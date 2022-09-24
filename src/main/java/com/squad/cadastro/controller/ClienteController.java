package com.squad.cadastro.controller;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.controller.dto.EnderecoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@CrossOrigin("https://frontend-register-app-squad-cadastro.vercel.app/")
public class ClienteController {

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody ClienteDto cliente) {

        final var result = clienteService.criarCliente(cliente);

        if (result != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Erro ao cadastrar");
    }

    @GetMapping("/cep/{num_cep}")
    public EnderecoResponse buscarCep(@PathVariable String num_cep) {
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/"+ num_cep +"/json/", EnderecoResponse.class).getBody();
    }

}
