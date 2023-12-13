package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.VeiculoEntity;
import com.example.demo.Service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoControler {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoEntity>> listarVeiculos() {
        List<VeiculoEntity> veiculos = veiculoService.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping
    public ResponseEntity<VeiculoEntity> cadastrarVeiculo(@RequestBody VeiculoEntity veiculo) {
        VeiculoEntity novoVeiculo = veiculoService.cadastrarVeiculo(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Integer id) {
        veiculoService.excluirVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoEntity> obterVeiculoPorId(@PathVariable Integer id) {
        VeiculoEntity veiculo = veiculoService.obterVeiculoPorId(id);
        return ResponseEntity.ok(veiculo);
    }
}