package com.centroweg.techfood.infra.strategy.freteStrategy;

import com.centroweg.techfood.domain.strategy.FreteStrategy;

public class presencialStrategy implements FreteStrategy {
    @Override
    public double calcularFrete(double valorBase) {
        return valorBase;
    }
}
