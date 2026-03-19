package com.centroweg.techfood.view;

import com.centroweg.techfood.domain.model.Cardapio;
import com.centroweg.techfood.domain.model.Funcionario;
import com.centroweg.techfood.service.CardapioService;
import com.centroweg.techfood.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class mainMenu implements CommandLineRunner {

    Scanner scanner = new Scanner(System.in);
    private final CardapioService cardapioService;
    private final FuncionarioService funcionarioService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> gerenciarFuncionarios();
                case 2 -> gerenciarCardapio();
                case 3 -> realizarVendas();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n--- TECHFOOD ERP - MENU PRINCIPAL ---");
        System.out.println("1 - Gerenciar Funcionários");
        System.out.println("2 - Gerenciar Cardápio");
        System.out.println("3 - REALIZAR VENDA");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private void gerenciarFuncionarios() {
        System.out.println("\n--- GERENCIAR FUNCIONARIOS ---");
        System.out.println("1 - Contratar Funcionario");
        System.out.println("2 - Listar Funcionarios");
        System.out.println("3 - Editar Funcionario");
        System.out.println("4 - Demitir Funcionario");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                Funcionario funcionario = new Funcionario();
                System.out.println("Nome do funcionario: ");
                funcionario.setNome(scanner.nextLine());
                System.out.println("Cargo do funcionário: ");
                funcionario.setCargo(scanner.nextLine());
                System.out.println("Salário do funcionário: ");
                funcionario.setSalario(scanner.nextDouble());
                funcionarioService.cadastrarFunciobario(funcionario);
            }

            case 2 -> {
                System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
                List<Funcionario> funcionarioList = funcionarioService.verFuncionarios();

                if (funcionarioList.isEmpty()) {
                    System.out.println("Nenhum funcionário cadastrado no banco.");
                } else {
                    funcionarioList.forEach(f -> {
                        System.out.printf("ID: %d | Nome: %-15s | Cargo: %-10s | Salário: R$ %.2f\n",
                                f.getId(), f.getNome(), f.getCargo(), f.getSalario());
                    });
                }
            }

            case 3 -> {
                List<Funcionario> funcionarioList = funcionarioService.verFuncionarios();

                funcionarioList.forEach(f -> {
                    System.out.printf("ID: %d | Nome: %-15s | Cargo: %-10s | Salário: R$ %.2f\n",
                            f.getId(), f.getNome(), f.getCargo(), f.getSalario());
                });

                System.out.println("\n--- EDITAR FUNCIONÁRIO ---");
                System.out.print("Informe o ID do funcionário: ");
                Integer id = scanner.nextInt();
                scanner.nextLine();

                Funcionario novosDados = new Funcionario();
                System.out.print("Novo Nome: ");
                novosDados.setNome(scanner.nextLine());
                System.out.print("Novo Cargo: ");
                novosDados.setCargo(scanner.nextLine());
                System.out.print("Novo Salário: ");
                novosDados.setSalario(scanner.nextDouble());

                funcionarioService.atualizarFuncionario(id, novosDados);
                System.out.println("Funcionário atualizado com sucesso!");
            }

            case 4 -> {
                List<Funcionario> funcionarioList = funcionarioService.verFuncionarios();

                funcionarioList.forEach(f -> {
                    System.out.printf("ID: %d | Nome: %-15s | Cargo: %-10s | Salário: R$ %.2f\n",
                            f.getId(), f.getNome(), f.getCargo(), f.getSalario());
                });

                System.out.print("Digite o ID do funcionário: ");
                Integer id = scanner.nextInt();
                scanner.nextLine();

                funcionarioService.demitirFuncionario(id);
                System.out.println("Funcionário removido com sucesso!");
            }

        }
    }

    private void gerenciarCardapio() {
        System.out.println("\n--- GERENCIAR CARSAPIOS ---");
        System.out.println("1 - Adicionar Cardapio");
        System.out.println("2 - Listar Cardapio");
        System.out.println("3 - Editar Cardapio");
        System.out.println("4 - remover Cardapio");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                Cardapio cardapio = new Cardapio();
                System.out.println("Nome do prato: ");
                cardapio.setNome(scanner.nextLine());
                System.out.println("Preço do prato: ");
                cardapio.setPreco(scanner.nextDouble());
                cardapioService.cadastrarCardapio(cardapio);
            }

            case 2 -> {
                System.out.println("\n--- CARDAPIO COMPLETO ---");
                List<Cardapio> cardapioList = cardapioService.verCardapio();

                if (cardapioList.isEmpty()) {
                    System.out.println("Nenhum prato cadastrado no banco.");
                } else {
                    cardapioList.forEach(c -> {
                        System.out.printf("ID: %d | Nome: %-15s | Preço: R$ %.2f\n",
                                c.getId(), c.getNome(), c.getPreco());
                    });
                }
            }

            case 3 -> {
                List<Cardapio> cardapioList = cardapioService.verCardapio();

                cardapioList.forEach(f -> {
                    System.out.printf("ID: %d | Nome: %-15s | Preço: R$ %.2f\n",
                            f.getId(), f.getNome(), f.getPreco());
                });

                System.out.println("\n--- EDITAR CARDAPIO ---");
                System.out.print("Informe o ID do prato: ");
                Integer id = scanner.nextInt();
                scanner.nextLine();

                Cardapio pratoNovo = new Cardapio();
                System.out.print("Novo Nome: ");
                pratoNovo.setNome(scanner.nextLine());
                System.out.print("Novo Preço: ");
                pratoNovo.setPreco(scanner.nextDouble());

                cardapioService.atualizarCardapio(id, pratoNovo);
                System.out.println("Prato atualizado com sucesso!");
            }

            case 4 -> {
                List<Cardapio> cardapioList = cardapioService.verCardapio();

                cardapioList.forEach(f -> {
                    System.out.printf("ID: %d | Nome: %-15s | Preço: R$ %.2f\n",
                            f.getId(), f.getNome(), f.getPreco());
                });

                System.out.print("Digite o ID do prato: ");
                Integer id = scanner.nextInt();
                scanner.nextLine();

                cardapioService.exluirCardapio(id);
                System.out.println("Funcionário removido com sucesso!");
            }

        }

    }

    private void realizarVendas() {
        System.out.println("\n--- REALIZAR VENDAS ---");
        int opcao = scanner.nextInt();
    }

}

