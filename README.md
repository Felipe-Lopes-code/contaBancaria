# Conta_Bancaria

Sistema bancario em Java para terminal, com operacoes de cadastro e movimentacao de contas, seguindo conceitos de Programacao Orientada a Objetos (POO), separacao em camadas e uso de interface para contrato do repositorio.

## Sumario

- Visao Geral
- Funcionalidades
- Arquitetura e Estrutura do Projeto
- Modelo de Dominio
- Fluxo de Execucao
- Requisitos
- Como Compilar e Executar
- Menu de Operacoes
- Dados Iniciais de Teste
- Regras de Negocio
- Melhorias Futuras
- Autor
- Licenca

## Visao Geral

O projeto simula uma aplicacao de banco via console. A classe principal apresenta um menu interativo que permite:

- criar conta corrente e conta poupanca;
- listar contas;
- buscar conta por numero;
- atualizar dados;
- excluir conta;
- sacar, depositar e transferir valores;
- consultar contas por nome do titular.

Toda a logica de negocio fica centralizada no controller, enquanto os modelos representam os tipos de conta e a interface de repositorio define o contrato de operacoes disponiveis.

## Funcionalidades

- Cadastro de conta com numeracao automatica
- Listagem completa de contas
- Consulta de conta por numero
- Atualizacao de dados com opcao de manter valores atuais
- Exclusao de conta com confirmacao
- Saque com validacao de saldo
- Deposito em conta
- Transferencia entre contas
- Consulta por titular (filtro parcial e case-insensitive)

## Arquitetura e Estrutura do Projeto

O projeto esta organizado por pacotes com responsabilidade bem definida.

```text
src/
	conta/
		util/
			Cores.java
	conta_bancaria/
		Menu.java
		controller/
			ContaController.java
		model/
			Conta.java
			ContaCorrente.java
			ContaPoupanca.java
		repository/
			ContaRepository.java
```

### Responsabilidades por pacote

- conta_bancaria: ponto de entrada da aplicacao e fluxo de interacao com usuario.
- conta_bancaria.controller: regras de negocio e manipulacao da colecao de contas.
- conta_bancaria.model: entidades de dominio (abstracao e especializacao).
- conta_bancaria.repository: contrato das operacoes do sistema.
- conta.util: utilitario para estilos de cores ANSI no terminal.

## Modelo de Dominio

### Conta (classe abstrata)

Representa atributos comuns:

- numero
- agencia
- tipo
- titular
- saldo

Metodos principais:

- sacar(valor)
- depositar(valor)
- visualizar()

### ContaCorrente

Especializa Conta com atributo:

- limite

Sobrescreve sacar para considerar saldo + limite.

### ContaPoupanca

Especializa Conta com atributo:

- aniversario

Mantem o comportamento padrao de saque da classe base.

## Fluxo de Execucao

1. A aplicacao inicia pela classe Menu.
2. Sao criadas contas de teste automaticamente.
3. O menu principal fica em loop ate o usuario escolher sair.
4. Cada opcao aciona um metodo da camada de controller.
5. O controller executa a operacao na colecao em memoria.

## Requisitos

- Java JDK 17 ou superior
- Terminal compativel com saida ANSI (cores)

## Como Compilar e Executar

### Opcao 1: via IDE (Eclipse/VS Code)

1. Abra a pasta do projeto.
2. Execute a classe principal:
	 src/conta_bancaria/Menu.java

### Opcao 2: via terminal (javac/java)

No diretorio raiz do projeto:

```bash
javac -d bin src/conta/util/Cores.java src/conta_bancaria/repository/ContaRepository.java src/conta_bancaria/model/*.java src/conta_bancaria/controller/ContaController.java src/conta_bancaria/Menu.java
java -cp bin conta_bancaria.Menu
```

No Windows PowerShell, se necessario, execute os comandos na mesma ordem acima.

## Menu de Operacoes

- 1: Criar conta
- 2: Listar todas as contas
- 3: Consultar conta por numero
- 4: Atualizar dados da conta
- 5: Apagar conta
- 6: Sacar
- 7: Depositar
- 8: Transferir entre contas
- 9: Consultar por nome do titular
- 0: Sair

## Dados Iniciais de Teste

Ao iniciar, o sistema cria automaticamente:

- 1 Conta Corrente (com limite)
- 1 Conta Poupanca (com aniversario)

Isso facilita testes rapidos de listagem, busca e transferencias.

## Regras de Negocio

- Nao e permitido sacar valor maior que o disponivel:
	- Conta comum: saldo
	- Conta corrente: saldo + limite
- Transferencia depende de:
	- existencia da conta de origem;
	- existencia da conta de destino;
	- saldo suficiente na origem.
- Busca por titular utiliza comparacao parcial sem diferenciar maiusculas/minusculas.

## Melhorias Futuras

- Persistencia em banco de dados ou arquivo
- Validacoes adicionais de entrada
- Tratamento mais robusto de erros de digitacao
- Testes automatizados unitarios
- Extracao da camada de visualizacao para reduzir acoplamento

## Autor

- Felipe Oliveira Lopes
- Generation Brasil
- GitHub: https://github.com/Felipe-Lopes-code

## Licenca

Este projeto esta licenciado sob a Licenca MIT. Consulte o arquivo LICENSE para mais detalhes.
