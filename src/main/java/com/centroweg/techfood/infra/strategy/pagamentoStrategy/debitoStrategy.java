package com.centroweg.techfood.infra.strategy.pagamentoStrategy;

import com.centroweg.techfood.domain.strategy.formaPagamentoStrategy;

public class debitoStrategy implements formaPagamentoStrategy {
    @Override
    public double calcularTotal(double total) {
        return total;
    }
}
