package com.example.demo.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VeiculoEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idveiculo;

    
    private String placa;
    private String modelo;
    private int anoFabricacao;
}