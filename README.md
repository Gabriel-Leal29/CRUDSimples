📌 Descrição do CRUD – Entidades Pai e Filho (Java Spring Boot)

- Projeto CRUD utilizando as entidades Pai e Filho, com relacionamento OneToMany / ManyToOne. O sistema segue boas práticas como uso de DTOs, Mapper, nomes em camelCase e arquitetura em camadas (Controller → Service → Repository).

🔹 Entidades

Pai
- id
- nome
- lista de filhos

Filho
- id
- nome
- idade

- pai associado

🔹 DTOs

- Utilizados para entrada (Request) e saída (Response) de dados, evitando expor diretamente as entidades.

🔹 Mapper

Converte:
- Entity ↔ DTO
- Mantém controllers limpos e reduz acoplamento.

🔹 Services

- PaiService: salvar, listar, buscar por id, atualizar, deletar.
- FilhoService: salvar, listar, buscar por id, atualizar somente nome, deletar.

🔹 Endpoints REST

Pais
- GET /pais
- POST /pais
- PUT /pais/{id}
- DELETE /pais/{id}

Filhos
- GET /filhos
-POST /filhos
- PUT /filhos/{id}
- DELETE /filhos/{id}

🔹 Fluxo

- Controller recebe DTO → chama Service → Service usa Mapper → Repository acessa o banco → retorna DTO ao cliente.
