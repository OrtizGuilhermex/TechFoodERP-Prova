package com.centroweg.techfood.infra.strategy.freteStrategy;

import com.centroweg.techfood.domain.strategy.FreteStrategy;

public class DeliveryStrategy implements FreteStrategy {
    @Override
    public double calcularFrete(double valorBase) {
        return valorBase * 1.05;
    }
}
