## 🍽️ API <a href="https://api-bistrobooking-production.up.railway.app/swagger-ui.html" target="_blank">BistroBooking</a> - Reserva de Restaurantes <img align="center" alt="Karen-Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"><img align="center" alt="Karen-spring" height="30" width="40" src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg">

### 📖 Sobre o Projeto

- O BistroBooking é uma API que permite o cadastro de clientes e restaurantes, além da realização de reservas informando dia e horário, quantidade de pessoas e o restaurante escolhido.

### 🌐 Como acessar?

- O deploy da API foi realizado na nuvem Railway.
- A documentação e testes podem ser acessados via Swagger, através <a href="https://api-bistrobooking-production.up.railway.app/swagger-ui.html" target="_blank">**deste link**</a>

### 🚀 Tecnologias utilizadas

- **Java:** Linguagem principal utilizada no desenvolvimento.
- **Spring Framework:** Utilizado com Spring Boot, Spring Web e Spring Data.
- **PostgreSQL:** Banco de dados relacional utilizado nos ambientes de desenvolvimento e produção.
- **Docker:** Para o banco de dados do ambiente de desenvolvimento, foi configurado um container do Docker, que roda localmente.
- **Railway:** Plataforma na nuvem utilizada para o deploy da API.

### 🔧 Funcionalidades

- Cadastro de Clientes e Restaurantes: Permite o registro de novos clientes e restaurantes.
- Reserva de Restaurantes: Possibilita realizar reservas especificando data, horário, quantidade de pessoas e o restaurante escolhido.
- Operações CRUD: Suporte completo às operações de criação, leitura, atualização e exclusão (CRUD) para todas as entidades.
    - **Get:** Recupera informações.
    - **Post (Salvar):** Adiciona novos dados.
    - **Put (Atualizar):** Atualiza dados existentes.
    - **Delete:** Remove dados.

### 🗺️ Diagrama de Classes
```mermaid
classDiagram
    class Reserva {
        <<Entity>>
        +Long id
        +Long fk_restaurante
        +Long fk_cliente
        +LocalDateTime dth_reserva
        +int numero_pessoas
        +String status
    }
    
    class Cliente {
        <<Entity>>
        +Long id
        +String nome
        +String email
        +String telefone
    }
    
    class Restaurante {
        <<Entity>>
        +Long id
        +String nome
        +String telefone
        +String descricao
        +String tipo_culinaria
        +Long fk_endereco
    }
    
    class Endereco {
        +Long id
        +String cep
        +String logradouro
        +String complemento
        +String bairro
        +String localidade
        +String uf
    }
    
    Reserva --> Restaurante : fk_restaurante
    Reserva --> Cliente : fk_cliente
    Restaurante --> Endereco : fk_endereco

