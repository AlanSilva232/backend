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

import com.example.demo.Entity.LocalizacaoEntity;

import com.example.demo.Service.LocalizacaoService;


@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @GetMapping
    public ResponseEntity<List<LocalizacaoEntity>> listarLocalizacoes() {
        List<LocalizacaoEntity> localizacoes = localizacaoService.listarLocalizacoes();
        return ResponseEntity.ok(localizacoes);
    }

    @PostMapping
    public ResponseEntity<LocalizacaoEntity> cadastrarLocalizacao(@RequestBody LocalizacaoEntity localizacao) {

        LocalizacaoEntity novaLocalizacao = localizacaoService.cadastrarLocalizacao(localizacao);
        return new ResponseEntity<>(novaLocalizacao, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLocalizacao(@PathVariable Integer id) {
        localizacaoService.excluirLocalizacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoEntity> obterLocalizacaoPorId(@PathVariable Integer id) {
        LocalizacaoEntity localizacao = localizacaoService.obterLocalizacaoPorId(id);
        return ResponseEntity.ok(localizacao);
    }
}