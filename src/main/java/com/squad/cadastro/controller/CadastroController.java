package com.squad.cadastro.controller;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("https://frontend-register-app-squad-cadastro.vercel.app/**")
public class CadastroController {
    ClienteService clienteService;

    public CadastroController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cep/{cep}")
    public EnderecoApiResponse buscarEndereco(@PathVariable String cep) {
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json/",
                EnderecoApiResponse.class).getBody();
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto cliente) {
        return new ResponseEntity<>(this.clienteService.criarCliente(cliente),
                HttpStatus.CREATED);
    }


    @GetMapping("/clientes")
    public List<ClienteDto> getListCliente() {
        return clienteService.getAll();
    }

    @GetMapping("/clientes/documento/{documento}")
    public ClienteDto getClienteByDocumento(@PathVariable String documento) {
        return clienteService.findByDocumento(documento);
    }

    @GetMapping("/clientes/id/{id}")
    public ClienteDto getClienteById(@PathVariable Long id) {
        return clienteService.findById(id);
    }
}
