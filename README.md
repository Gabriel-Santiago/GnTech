# 🏢 Imobiliária API

API REST desenvolvida em **Java 21 + Spring Boot**, com ambiente **Dockerizado**, para gerenciamento de **Imobiliárias** e seus **Imóveis**.

O projeto simula um sistema de imobiliária onde uma **Imobiliária** é responsável por cadastrar, gerenciar e remover seus **Imóveis** disponíveis para aluguel.

---

## 📌 Visão Geral

* Uma **Imobiliária** pode gerenciar vários **Imóveis**
* Cada **Imóvel** pertence a uma única **Imobiliária**
* O sistema permite cadastro, consulta, atualização e remoção

Arquitetura baseada em:

* Api
* Config
* Controller
* DTO
* Entity
* Enum
* Exception
* Service
* Repository
* Validator

---

## 🛠 Tecnologias Utilizadas

* **Java 21 (LTS)**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **Docker & Docker Compose**
* **Maven**
* **Postman** (para testes)

---

## 📁 Estrutura do Projeto

```bash
imobiliaria/
├── src/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🐳 Docker

O projeto utiliza Docker para subir:

* API Spring Boot
* Banco de dados PostgreSQL

### 🔹 Dockerfile (Java 21)

```dockerfile
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/imobiliaria-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

### 🔹 docker-compose.yml

```yaml
services:
  db:
    image: postgres:15
    container_name: postgres_imobiliaria
    restart: always
    environment:
      POSTGRES_DB: imobiliaria
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"

  api:
    build: .
    container_name: imobiliaria_api
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/imobiliaria
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres
      SPRING_PROFILES_ACTIVE: docker
```

---

## ▶️ Como Executar o Projeto

### 1️⃣ Gerar o JAR

```bash
mvn clean package -DskipTests
```

### 2️⃣ Subir o ambiente com Docker

```bash
docker compose up --build
```

### 3️⃣ Verificar containers

```bash
docker ps
```

A API ficará disponível em:

```
http://localhost:8080
```

> Mesmo utilizando **WSL**, o acesso é feito normalmente via `localhost`.

---

## 🔗 Endpoints Disponíveis

### 🏢 Imobiliária (`/imobiliaria`)

| Método | Rota        | Descrição             |
| ------ | ----------- | --------------------- |
| POST   | `/cadastro` | Cadastrar imobiliária |
| GET    | `/`         | Listar imobiliárias   |
| PATCH  | `/email`    | Atualizar email       |
| PATCH  | `/telefone` | Atualizar telefone    |
| DELETE | `/`         | Remover imobiliária   |

---

### 🏠 Imóvel (`/imovel`)

| Método | Rota                | Descrição                 |
| ------ | ------------------- | ------------------------- |
| POST   | `/cadastro`         | Cadastrar imóvel          |
| GET    | `/`                 | Listar todos              |
| GET    | `/imobiliaria/{id}` | Buscar por imobiliária    |
| GET    | `/tipo`             | Buscar por tipo           |
| GET    | `/bairro`           | Buscar por bairro         |
| GET    | `/cidade`           | Buscar por cidade         |
| GET    | `/estado`           | Buscar por estado         |
| PATCH  | `/valor-diaria`     | Atualizar valor da diária |
| DELETE | `/`                 | Remover imóvel            |

---

## 🧪 Testes com Postman

Todos os endpoints podem ser testados via **Postman** utilizando:

```
http://localhost:8080
```

Uma **collection do Postman** pode ser importada para facilitar os testes de todos os fluxos.

---

## 🔐 Regras de Negócio

* Um imóvel só pode ser removido se a **senha da imobiliária** for válida
* A imobiliária é responsável por todos os seus imóveis
* O cálculo de dias restantes é feito automaticamente quando o imóvel está alugado

---

## 🌐 Consumo de APIs Externas

O sistema realiza integração com **APIs públicas externas** para enriquecimento e validação dos dados armazenados no banco de dados.

### APIs utilizadas

* **ViaCEP**
  Utilizada para obtenção automática de dados de endereço a partir do **CEP** informado no cadastro de imóveis.

  Exemplo de endpoint:

  ```
  GET https://viacep.com.br/ws/{cep}/json
  ```

* **ReceitaWS**
  Utilizada para validação e consulta de dados cadastrais de empresas a partir do **CNPJ** informado no cadastro de imobiliárias.

  Exemplo de endpoint:

  ```
  GET https://www.receitaws.com.br/v1/cnpj/{cnpj}
  ```

## 🚀 Evoluções Futuras

Funcionalidades planejadas:

* Cadastro de **Clientes**
* **Autenticação e Autorização** (JWT / Spring Security)
* Controle de **Aluguéis e Vendas**
* **Frontend** (Web ou Mobile)

---

## 👨‍💻 Autor

Projeto desenvolvido por **Gabriel Santiago** em **API RESTful, Docker e Java moderno**.

---

## ✅ Status do Projeto

✔ API funcional
✔ Docker configurado
✔ Banco isolado
✔ Pronto para evolução 🚀
