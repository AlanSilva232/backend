package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.LocalizacaoEntity;

@Repository
public interface LocalizacaoRepository extends JpaRepository<LocalizacaoEntity, Integer> {
}