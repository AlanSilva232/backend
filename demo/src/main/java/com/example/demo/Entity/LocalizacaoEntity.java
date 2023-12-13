package com.example.demo.Entity;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class LocalizacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "idveiculo", nullable = false)
    private VeiculoEntity veiculo;
}