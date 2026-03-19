package com.centroweg.techfood.infra.repository;

import com.centroweg.techfood.domain.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository  extends JpaRepository<Estoque, Integer> {
}
