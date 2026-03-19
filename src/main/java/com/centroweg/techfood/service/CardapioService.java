package com.centroweg.techfood.service;

import com.centroweg.techfood.domain.model.Cardapio;
import com.centroweg.techfood.domain.model.Funcionario;
import com.centroweg.techfood.infra.repository.CardapioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardapioService {

    private final CardapioRepository cardapioRepository;

    public Cardapio cadastrarCardapio (Cardapio cardapio){
        return cardapioRepository.save(cardapio);
    }

    public List<Cardapio> verCardapio(){
        List<Cardapio> cardapioList = cardapioRepository.findAll();

        return cardapioList;
    }

    public Cardapio atualizarCardapio(Integer id, Cardapio cardapioDadosNovos) {
        return cardapioRepository.findById(id)
                .map(cardapioExistente -> {
                    cardapioExistente.setNome(cardapioDadosNovos.getNome());
                    cardapioExistente.setPreco(cardapioDadosNovos.getPreco());
                    return cardapioRepository.save(cardapioExistente);

                }).orElseThrow(() -> new RuntimeException("Cardapio não encontrado com o ID: " + id));
    }

    public void exluirCardapio (Integer id){
        cardapioRepository.deleteById(id);
    }
}
