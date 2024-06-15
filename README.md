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

