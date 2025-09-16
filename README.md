LyceumAPI - API de Gerenciamento de matriculas de faculdades

## 📋 Descrição

LyceumAPI é uma API REST desenvolvida em Spring Boot que permite cadastrar, consultar e atualizar informações de estudantes, matrículas e matérias.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.5** - Framework para desenvolvimento de aplicações Java
- **Spring Web** - Módulo para criação de APIs REST
- **Maven** - Gerenciador de dependências e build

## 📁 Estrutura do Projeto

```
Lyceum-API/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/dev/Lyceum/API/
│   │   │       ├── core/
│   │   │       │   ├── domain                      # Core businnes rules
│   │   │       │   ├── gateway                     # Gateway to communication
│   │   │       │   └── usecases                    # Core usecases
│   │   │       ├── infra/
│   │   │       │   ├── bean                        # Bean configurations
│   │   │       │   ├── exception                   # Exception handlers
│   │   │       │   ├── gateway                     # Gateway to communication
│   │   │       │   ├── mapper                      # Map between entities, dto and domain
│   │   │       │   ├── persistence                 # External integrations and database
│   │   │       │   ├── presentation                # Controllers and REST endpoints
│   │   │       │   └── utils                       # ID Generator controller
│   │   │       └── LyceumApiApplication.java
│   │   └── resources/
│   │       ├── db/migration                        # Flyway Migrations
│   │       └── application.yml                     # Application configuration
│   └── test/
└── pom.xml
```

## 🛠️ Como Executar

### Pré-requisitos
- Java 21 ou superior
- Docker
- Maven 3.6+ (Opcional, se não utilizar Docker)
- Postman

### Passos para execução
1. Clone o repositório
2. Navegue até a pasta do projeto: `cd Lyceum-API`
3. Execute o projeto: `./mvnw spring-boot:run`
4. A aplicação estará disponível no Postman em: `http://localhost:8080`

## 📡 Endpoints da API

### 👤 User 

####  Criação de usuários
- **URL**: `POST /user/create`
- **Parâmetros via corpo da requisição**: 
  - `name` - nome do usuário,
  - `email` - email do usuário,
  - `identifier` - número da identificação pessoal, sem formatação. Podendo ser, por exemplo: CPF (Brasil), DNI (Argentina), Social Security Number (Inglaterra), etc.
- **Exemplo**: 
    - `name` - `"João da Silva"`,
    - `email` - `"joao_silva@email.com"`,
    - `identifier` - `"12345678900"`
- **Resposta**: Novo objeto com informações fornecidas.

#### Consulta de usuários
- **URL**: `GET /user`
- **Parâmetros**: Sem parâmetros.
- **Resposta**: Uma lista com todos os usuários já cadastrados.

#### Consulta de usuário específico
- **URL**: `GET /user/search/{id}`
- **Parâmetros**: `id` - O identificador do usuário desejado.
- **Exemplo**: `GET /user/search/1`
- **Resposta**: Objeto com informações do usuário.


#### 📊 Exemplo de Resposta

```json
{
  "id": 1,
  "name": "João da Silva",
  "email": "joao_silva@email.com",
  "identifier": "12345678900"
}
```

### 🙋 Aluno 

#### Criação de aluno
- **URL**: `POST /student/register`
- **Parâmetros via corpo da requisição**:
    - `user` - O identificador do usuário,
    - `studentIdentifier` - matrícula do aluno, será gerada automaticamente quando o aluno for matrículado.
    - `isActive` - Booleano (true ou false) para saber se o aluno está ativo ou não.
- **Exemplo**:
    - `user` - `1`,
    - `studentIdentifier` - `null`,
    - `isActive` - `true`
- **Resposta**: Novo objeto com informações fornecidas.

#### Consulta de alunos
- **URL**: `GET /student`
- **Parâmetros**: Sem parâmetros.
- **Resposta**: Uma lista com todos os alunos já cadastrados.

#### Consulta de aluno específico
- **URL**: `GET /student/search/{id}`
- **Parâmetros**: `id` - O identificador do aluno desejado.
- **Exemplo**: `GET /student/search/1`
- **Resposta**: Objeto com informações do aluno.


#### 📊 Exemplo de Resposta

```json
{
  "id": 1,
  "user": {
    "id": 1,
    "name": "João da Silva",
    "email": "joao_silva@email.com",
    "identifier": "12345678900"
  },
  "studentIdentifier": null,
  "isActive": true
}
```

### 📚 Matéria

#### Criação de matéria
- **URL**: `POST /subject/create`
- **Parâmetros via corpo da requisição**:
    - `name` - nome da matéria,
- **Exemplo**:
    - `name` - `"Algoritmos e Estrutura de Dados"`,
- **Resposta**: Novo objeto com informações fornecidas.

#### Consulta de matérias
- **URL**: `GET /subject`
- **Parâmetros**: Sem parâmetros.
- **Resposta**: Uma lista com todas as matérias já cadastradas.

#### Consulta de matéria específica
- **URL**: `GET /subject/search/{id}`
- **Parâmetros**: `id` - O identificador da matéria desejada.
- **Exemplo**: `GET /subject/search/1`
- **Resposta**: Objeto com informações da matéria.


#### 📊 Exemplo de Resposta

```json
{
  "id": 1,
  "name": "Algoritmos e Estrutura de Dados"
}
```

### 🎒 Matrícula

#### Criação de matrícula
- **URL**: `POST /enrollment/create`
- **Parâmetros via corpo da requisição**:
    - `student` - O identificador do aluno,
    - `subjects` - lista com todos os registros, será gerada automaticamente quando o aluno for registrado em uma matéria.
- **Exemplo**:
    - `student` - `1`,
    - `subjects` - `null`
- **Resposta**: Novo objeto com informações fornecidas.

#### Consulta de matrículas
- **URL**: `GET /enrollment`
- **Parâmetros**: Sem parâmetros.
- **Resposta**: Uma lista com todas as matrículas já cadastrados.

#### Consulta de matrícula específica
- **URL**: `GET /enrollment/search/{id}`
- **Parâmetros**: `id` - A matrícula desejada.
- **Exemplo**: `GET /enrollment/search/2025abcd75489a2s`
- **Resposta**: Objeto com informações da matrícula.


#### 📊 Exemplo de Resposta

```json
{
  "id": "2025abcd75489a2s",
  "student": {
    "id": 1,
    "user": {
      "id": 1,
      "name": "João da Silva",
      "email": "joao_silva@email.com",
      "identifier": "12345678900"
    },
    "studentIdentifier": "2025abcd75489a2s",
    "isActive": true
  },
  "subjects": null
}
```

### 📂 Registro

#### Criação de registro
- **URL**: `POST /registration/create`
- **Parâmetros via corpo da requisição**:
    - `subject` - O identificador da matéria,
    - `enrollment` - O identificador da matrícula,
    - `grade` - nota (apenas se o statusSubject for "COMPLETED",
    - `statusSubject` - enumeração, podendo ser um dos seguintes tipos: "COMPLETED","FAILED", "IN_PROGRESS", "REGISTERED".
- **Exemplo**:
    - `subject` - `1`,
    - `enrollment` - `1`,
    - `grade` - `null`,
    - `statusSubject` - `IN_PROGRESS`
- **Resposta**: Novo objeto com informações fornecidas.

#### Consulta de registros
- **URL**: `GET /registration`
- **Parâmetros**: Sem parâmetros.
- **Resposta**: Uma lista com todos os registros já cadastrados.

#### Consulta de registro específico
- **URL**: `GET /registration/search/{id}`
- **Parâmetros**: `id` - O identificador do registro desejado.
- **Exemplo**: `GET /enrollment/search/1`
- **Resposta**: Objeto com informações do registro.


#### 📊 Exemplo de Resposta

```json
{
  "id": 1,
  "subject": {
    "id": 1,
    "name": "Algoritmos e Estrutura de Dados"
  },
  "enrollment": {
    "id": "2025abcd75489a2s",
    "student": {
      "id": 1,
      "user": {
        "id": 1,
        "name": "João da Silva",
        "email": "joao_silva@email.com",
        "identifier": "12345678900"
      },
      "studentIdentifier": "2025abcd75489a2s",
      "isActive": true
    },
    "subjects": {
      "id": 1
    }
  },
  "grade": null,
  "subjectStatus": "IN_PROGRESS"
}
```


## 🏗️ Arquitetura

- **Controller Layer**: Gerencia as requisições HTTP
- **Domain Layer**: Define as entidades do sistema

## 🔧 Configurações

O projeto utiliza as configurações padrão do Spring Boot. Para personalizar, edite o arquivo `application.yml`.

## 📈 Melhorias Futuras

- [ ] Implementar frontend
- [ ] Finalizar CRUD para todas as entidades
- [ ] Melhorar tratamento de erros
- [ ] Adicionar documentação com Swagger
- [ ] Implementar testes unitários e de integração

## 👨‍💻 Desenvolvido por

Este projeto foi desenvolvido por **[Mariana Milani Assunção](https://github.com/MariiMilani)** visando consolidar conceitos mais avançados de Java e arquitetura limpa.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.