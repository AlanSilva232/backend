package com.example.demo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.LocalizacaoEntity;
import com.example.demo.Repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
    @Autowired
    private LocalizacaoRepository localizacaoRepository;
    
    public List<LocalizacaoEntity> listarLocalizacoes() {
        return localizacaoRepository.findAll();
    }

    public LocalizacaoEntity cadastrarLocalizacao(LocalizacaoEntity localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public void excluirLocalizacao(Integer id) {
        localizacaoRepository.deleteById(id);
    }

    public LocalizacaoEntity obterLocalizacaoPorId(Integer id) {
        return localizacaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Localização não encontrada"));
    }
}
