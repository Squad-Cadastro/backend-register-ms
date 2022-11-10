package com.squad.cadastro.controller;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.controller.dto.EnderecoDto;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.validator.ValidatorInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("https://frontend-register-app-squad-cadastro.vercel.app/")
public class CadastroController {
    ValidatorInterface validatorInterface;

    ClienteService clienteService;

    public CadastroController(ValidatorInterface validatorInterface, ClienteService clienteService) {
        this.validatorInterface = validatorInterface;
        this.clienteService = clienteService;
    }

    @GetMapping("/cep/{cep}")
    public EnderecoApiResponse buscarEndereco(@PathVariable String cep){
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/"+ cep +"/json/",
            EnderecoApiResponse.class).getBody();
    }

    @PostMapping("/sum/{a}/{b}")
    public String sum(@PathVariable Integer a, @PathVariable Integer b) {
        return String.valueOf(a+b);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody ClienteDto cliente, EnderecoDto endereco){
        if (validatorInterface.validarEmail(cliente.getEmail())){
            return new ResponseEntity<>("Email invalido",
                    HttpStatus.BAD_REQUEST);
        }
        if (validatorInterface.validarCPF(cliente.getDocumento())) {
            return new ResponseEntity<>(clienteService.criarCliente(cliente),
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Documento invalido",
                    HttpStatus.BAD_REQUEST);

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
