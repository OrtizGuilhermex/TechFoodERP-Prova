package com.centroweg.techfood.infra.repository;

import com.centroweg.techfood.domain.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Integer> {
}
