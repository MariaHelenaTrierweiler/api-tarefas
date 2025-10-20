# API de Gerenciamento de Tarefas

![Badge do Java](https://img.shields.io/badge/Java-25-blue?logo=java&logoColor=white)
![Badge do Spring](https://img.shields.io/badge/Spring_Boot-3.x.x-green?logo=spring&logoColor=white)
![Badge da Licença](https://img.shields.io/badge/License-MIT-green)

Este é um projeto de uma API RESTful para gerenciamento de tarefas, desenvolvido em Java com Spring Boot. A API permite o cadastro, consulta, atualização e remoção de tarefas.

Este projeto foi criado como parte do trabalho de Desenvolvimento Web Back-end.

## Funcionalidades

A API permite realizar as seguintes operações (CRUD):

- [x] **Criar** uma nova tarefa.
- [x] **Consultar** (Listar) todas as tarefas cadastradas.
- [x] **Consultar** (Buscar) uma tarefa específica pelo seu ID.
- [x] **Atualizar** os dados de uma tarefa existente.
- [x] **Remover** uma tarefa.

## Tecnologias Utilizadas

- **Java 25**
- **Spring Boot**
  - **Spring Web:** Para a criação dos endpoints RESTful.
  - **Spring Data JPA:** Para a persistência de dados.
- **Hibernate:** Implementação do JPA para mapeamento objeto-relacional (ORM).
- **Maven:** Gerenciador de dependências e build do projeto.
- **MySQL:** Banco de dados relacional para armazenamento das tarefas.
- **Postman:** Utilizado para testar e documentar os endpoints da API.

## Como Executar o Projeto

Para rodar este projeto localmente, siga os passos abaixo.

### Pré-requisitos

- [Java JDK 25](https://adoptium.net/temurin/releases/?version=25) ou superior.
- [Apache Maven](https://maven.apache.org/download.cgi).
- Um cliente Git (ex: [Git for Windows](https://git-scm.com/downloads)).
- Uma instância do [MySQL](https://dev.mysql.com/downloads/installer/) rodando.

### 1. Clonar o Repositório

Abra um terminal e clone este repositório para sua máquina local:

```bash
git clone https://github.com/MariaHelenaTrierweiler/api-tarefas.git
cd api-tarefas
