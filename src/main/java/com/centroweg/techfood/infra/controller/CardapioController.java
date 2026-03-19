package com.centroweg.techfood.infra.controller;

import com.centroweg.techfood.domain.model.Cardapio;
import com.centroweg.techfood.domain.model.Funcionario;
import com.centroweg.techfood.service.CardapioService;
import com.centroweg.techfood.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
@RequiredArgsConstructor
public class CardapioController {

    private final CardapioService cardapioService;

    @PostMapping
    public Cardapio cadastrarCardapio (
            @RequestBody Cardapio cardapio
    ){
        return cardapioService.cadastrarCardapio(cardapio);
    }

    @GetMapping
    public List<Cardapio> listarCardapio(){
        return cardapioService.verCardapio();
    }

    @PutMapping("/{id}")
    public Cardapio atualizarCardapio(
            @PathVariable Integer id,
            @RequestBody Cardapio cardapio
    ){
        return cardapioService.atualizarCardapio(id,cardapio);
    }

    @DeleteMapping("/{id}")
    public void demitirFuncionario(
            @PathVariable Integer id
    ){
        cardapioService.exluirCardapio(id);
    }
}
