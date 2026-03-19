package com.centroweg.techfood.service;

import com.centroweg.techfood.domain.model.Funcionario;
import com.centroweg.techfood.infra.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrarFunciobario (Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> verFuncionarios(){
        List<Funcionario> funcionarioList = funcionarioRepository.findAll();

        return funcionarioList;
    }

    public Funcionario atualizarFuncionario(Integer id, Funcionario funcionarioDadosNovos) {
        return funcionarioRepository.findById(id)
                .map(funcionarioExistente -> {
            funcionarioExistente.setNome(funcionarioDadosNovos.getNome());
            funcionarioExistente.setCargo(funcionarioDadosNovos.getCargo());
            funcionarioExistente.setSalario(funcionarioDadosNovos.getSalario());
            return funcionarioRepository.save(funcionarioExistente);

        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
    }

    public void demitirFuncionario (Integer id){
        funcionarioRepository.deleteById(id);
    }

}
