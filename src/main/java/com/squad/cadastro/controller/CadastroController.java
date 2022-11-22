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
    public ResponseEntity<?> create(@RequestBody ClienteDto cliente) {
        try {
            return new ResponseEntity<>(this.clienteService.criarCliente(cliente),
                    HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/clientes")
    public List<ClienteDto> getListCliente() {
        return clienteService.getAllClientes();
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
