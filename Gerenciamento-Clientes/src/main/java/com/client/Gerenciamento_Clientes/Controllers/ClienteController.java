package com.client.Gerenciamento_Clientes.Controllers;

import com.client.Gerenciamento_Clientes.Models.ClienteModel;
import com.client.Gerenciamento_Clientes.Services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criar(@RequestBody ClienteModel cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}