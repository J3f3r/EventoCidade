# Desafio Evento-Cidade (Validação e Segurança)

## 📌 Sobre o Projeto
Este é um sistema desenvolvido em Java com Spring Boot voltado para o gerenciamento de eventos e suas respectivas cidades. O projeto prático foi consolidado como parte do treinamento de desenvolvimento web avançado, com foco estrito em **Validação de Dados (Bean Validation)** e **Segurança (OAuth2 com tokens JWT)**.

A arquitetura do projeto segue o padrão de camadas de mercado (Controlador, Serviço, Repositório e DTO).

---

## 🛠️ O que foi desenvolvido

### Fornecido no início do Laboratório:
* Estrutura de entidades de banco de dados (`City`, `Event`, `User`, `Role`).
* Classes de mapeamento de dados (DTOs) básicas.
* Suíte de testes automatizados de integração (`EventControllerIT`, `CityControllerIT`).

### Implementado por mim (Caixa de Ferramentas):
* **Camada de Persistência:** Configuração e ajustes dos repositórios JPA (`EventRepository` e `CityRepository`) com tratamento de tipos genéricos e persistência relacional.
* **Camada de Negócio e Controle:** Criação dos endpoints REST no `CityController` e `EventController`, além de regras de negócio de consulta paginada e inserção no `CityService` e `EventService`.
* **Validação Automática (Bean Validation):** * Garantia de campos obrigatórios (`@NotBlank`, `@NotNull`) nos fluxos de inserção.
  * Validação temporal restrita com `@FutureOrPresent` para impedir o agendamento de eventos em datas passadas.
* **Segurança e Autorização:** * Implementação de Spring Security integrado com Spring Authorization Server.
  * Configuração de controle de perfil de acesso (Roles) usando a annotation `@PreAuthorize`.
  * Liberação de rotas públicas de consulta (`GET`), restringindo as operações de escrita (`POST`) apenas para perfis autenticados (`ROLE_ADMIN`, `ROLE_OPERATOR`).

---

## 🏗️ Camadas do Sistema

* **Entities:** Objetos de domínio mapeados para tabelas com JPA.
* **Repositories:** Interfaces de acesso a dados estendendo `JpaRepository`.
* **Services:** Centralizam as regras de negócio e o controle transacional (`@Transactional`).
* **Controllers:** Endpoints expostos da API REST que recebem e processam as requisições HTTP.
* **DTOs:** Objetos de transferência de dados usados para tráfego seguro na rede e validações com Jakarta Validation.

---

## 🚀 Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 4.x**
* **Spring Data JPA**
* **Spring Security / OAuth2 / JWT**
* **H2 Database** (Banco de dados em memória para testes)
* **Jakarta Validation (Hibernate Validator)**

---

## 🧪 Como Executar e Testar

### Pré-requisitos
* Java 21 instalado.
* Maven instalado (ou utilizar o wrapper `./mvnw`).

### Executando a Aplicação
1. Clone o repositório.
2. Navegue até a pasta raiz do projeto.
3. Execute o comando:
   ```bash
   mvn spring-boot:run
4. A API estará disponível em http://localhost:8080.

5. O console do banco de dados H2 poderá ser acessado em      	http://localhost:8080/h2-console.
6. Executando a Suíte de Testes (JUnit)
	```mvn test