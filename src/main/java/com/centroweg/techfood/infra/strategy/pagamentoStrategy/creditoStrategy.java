package com.centroweg.techfood.infra.strategy.pagamentoStrategy;

import com.centroweg.techfood.domain.strategy.formaPagamentoStrategy;

public class creditoStrategy implements formaPagamentoStrategy {
    @Override
    public double calcularTotal(double total) {
        return total * 1.15;
    }
}
