# CRUD de Clientes

Aplicação REST construída em Java e Spring Boot para gerenciamento de clientes.  
Projeto simples, organizado e ideal para estudos de API, arquitetura em camadas e boas práticas com Spring.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

---

## 📌 Funcionalidades

- Criar um novo cliente
- Listar todos os clientes
- Buscar cliente por ID
- Atualizar dados
- Deletar cliente

A aplicação segue uma arquitetura em camadas (`controller`, `service`, `repository`, `dto`).

---

## 🗂 Estrutura do Projeto

src/main/java/com/clientes/crud

├── controllers

├── dto

├── entities

├── repositories

├── services

└── CrudApplication.java

yaml
Copiar código

---

## ▶️ Como Rodar o Projeto

```bash
# Clonar o repositório
git clone https://github.com/FelixDev01/CRUD-de-Clientes.git

# Entrar na pasta
cd CRUD-de-Clientes

# Rodar
./mvnw spring-boot:run
A API sobe em:
http://localhost:8080

🗃 Banco de Dados
O projeto usa H2 em memória.
Após iniciar, acesse:

http://localhost:8080/h2-console

JDBC URL configurada no projeto.