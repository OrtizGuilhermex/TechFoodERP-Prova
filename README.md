
🚀 TechFood ERP - Evolução de Arquitetura
Este repositório documenta a refatoração completa do sistema TechFood ERP. O projeto deixou de ser uma aplicação Java monolítica simples para se tornar um ecossistema robusto baseado em Spring Boot, utilizando persistência de dados real e padrões de design avançados.

🛠️ O Problema: Código Original (Legado)
No início, o sistema era baseado em uma única classe Main com as seguintes limitações:

Persistência Volátil: Os dados eram salvos em Vetores Estáticos (String[], double[]). Ao fechar o programa, todos os dados eram perdidos.

Violação de SRP (Single Responsibility Principle): A classe Main fazia tudo: gerenciava o teclado, calculava impostos, aplicava descontos e simulava o banco de dados.

Violação de OCP (Open/Closed Principle): Para adicionar uma nova forma de pagamento ou um novo tipo de frete, era necessário encher o código de if/else, aumentando o risco de bugs em funções existentes.

Dificuldade de Manutenção: O código era "macarrônico", onde uma pequena alteração no estoque poderia quebrar a lógica de vendas.

🏗️ A Solução: Nova Arquitetura (Spring Boot + SOLID)
A nova versão foi reestruturada seguindo as melhores práticas do mercado:

1. Camada de Domínio (Model & Strategy)
Entidades JPA: Substituímos vetores por classes de modelo (Funcionario, Cardapio, Estoque) mapeadas com Hibernate para um banco de dados relacional.

Padrão Strategy: Implementamos interfaces para pagamentos e fretes.

Pagamento: PixStrategy, CreditoStrategy, DebitoStrategy, EspecieStrategy.

Frete: FreteStrategy (para diferenciar Presencial de Delivery).

Isso permite adicionar novos métodos de pagamento sem tocar na lógica de venda.

2. Camada de Infraestrutura (Repository & Controller)
Spring Data JPA: Criamos interfaces Repository que eliminam a necessidade de escrever SQL manualmente para operações básicas (CRUD).

Controllers: Implementamos controladores para expor a lógica do sistema, preparando o terreno para uma futura integração com API Web ou Mobile.

3. Camada de Serviço (Business Logic)
As classes FuncionarioService, CardapioService e VendaService agora concentram toda a regra de negócio, garantindo que a View seja apenas uma interface de usuário.

4. Interface de Usuário (View)
Criamos o mainMenu utilizando CommandLineRunner. Ele funciona como um menu interativo via terminal que se comunica diretamente com os serviços do Spring, garantindo uma experiência de usuário fluida e persistente.

📁 Estrutura de Pastas Atual
Plaintext
com.centroweg.techfood
├── domain
│   ├── model       # Entidades (Funcionario, Cardapio, Estoque)
│   └── strategy    # Interfaces de Estratégia (Pagamento, Frete)
├── infra
│   ├── controller  # Porta de entrada da lógica
│   ├── repository  # Comunicação com o Banco de Dados (JPA)
│   └── strategy    # Implementações das estratégias (Pix, Crédito, etc.)
├── service         # Regras de negócio e transações
└── view            # Interface de Terminal (mainMenu)
⚙️ Tecnologias Utilizadas
Java 17+

Spring Boot 3.x

Spring Data JPA

Lombok (Produtividade com Getters/Setters)

MySQL/H2 (Persistência de dados)

📈 Principais Melhorias Alcançadas
Persistência Real: Agora você pode fechar o sistema e os funcionários/pratos continuam salvos no banco de dados.

Escalabilidade: O sistema está pronto para crescer. Adicionar uma nova regra de negócio agora leva minutos, não horas.

Segurança de Dados: O uso de @Transactional garante que, se uma venda falhar no meio do processo, o estoque não seja baixado incorretamente (Atomicidade).

Desenvolvido como parte da modernização do TechFood ERP.
