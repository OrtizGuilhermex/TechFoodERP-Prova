package com.centroweg.techfood.infra.controller;

import com.centroweg.techfood.domain.model.Funcionario;
import com.centroweg.techfood.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario cadastrarFuncionario (
            @RequestBody Funcionario funcionario
    ){
        return funcionarioService.cadastrarFunciobario(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioService.verFuncionarios();
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(
            @PathVariable Integer id,
            @RequestBody Funcionario funcionario
    ){
        return funcionarioService.atualizarFuncionario(id,funcionario);
    }

    @DeleteMapping("/{id}")
    public void demitirFuncionario(
            @PathVariable Integer id
    ){
        funcionarioService.demitirFuncionario(id);
    }

}
