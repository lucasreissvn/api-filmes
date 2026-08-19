# API de Filmes

API REST de filmes desenvolvida com **Spring Boot**, com o objetivo de praticar conceitos de desenvolvimento backend com Java e o ecossistema Spring.

## Tecnologias

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation
* H2 Database
* Maven

## Funcionalidades

* CRUD de filmes
* DTOs para recebimento e validação dos dados de entrada
* Validação dos dados de entrada
* Tratamento global de exceções com `GlobalExceptionHandler`
* Persistência com Spring Data JPA
* Relacionamento entre entidades
* Relacionamento unidirecional entre `Filme` e `Diretor`

### Relacionamento

Um filme pode possuir um diretor, utilizando uma relação unidirecional:

```text
Filme ────────> Diretor
```

## Estrutura

O projeto utiliza uma arquitetura em camadas, separando as responsabilidades da aplicação:

```text
src/main/java
└── ...
    ├── resources
    ├── services
    ├── repositories
    ├── entities
    ├── dto
    └── exceptions
```

* **Resources:** responsáveis pelos endpoints da API e comunicação HTTP.
* **Services:** contêm as regras e operações da aplicação.
* **Repositories:** responsáveis pela persistência dos dados.
* **Entities:** representam as entidades do banco de dados.
* **DTOs:** utilizados para receber e validar os dados enviados à API.
* **Exceptions:** responsáveis pelo tratamento centralizado das exceções.

## Objetivo

Projeto desenvolvido para praticar o desenvolvimento de **APIs REST com Spring Boot**, aplicando conceitos como arquitetura em camadas, DTOs, validação de dados, tratamento de exceções, JPA e relacionamento entre entidades.

**Status:** Concluído.

## Como executar

### Pré-requisitos

* Java 17 ou superior

### Executando a aplicação

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
cd <NOME_DO_PROJETO>
```

Inicie a aplicação utilizando o Maven Wrapper:

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

**Windows:**

```bash
mvnw.cmd spring-boot:run
```

A aplicação utiliza o **H2 Database em memória**, portanto não é necessário instalar ou configurar um banco de dados externo.
