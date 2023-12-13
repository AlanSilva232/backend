package com.example.demo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.VeiculoEntity;
import com.example.demo.Repository.VeiculoRepository;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoEntity> listarVeiculos() {
        List<VeiculoEntity> veiculoEntities = veiculoRepository.findAll();
            return veiculoEntities;
    }

    public VeiculoEntity cadastrarVeiculo(VeiculoEntity veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void excluirVeiculo(Integer idveiculo) {
        veiculoRepository.deleteById(idveiculo);
    }

    public VeiculoEntity obterVeiculoPorId(Integer idveiculo) {
        return veiculoRepository.findById(idveiculo)
                .orElseThrow(() -> new NoSuchElementException("Veículo não encontrado"));
    }

}
