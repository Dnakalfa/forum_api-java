# Forum API

## Descrição

Forum API é uma aplicação RESTful criada com Spring Boot para gerenciamento de tópicos de um fórum fictício. Ela utiliza autenticação baseada em JWT (JSON Web Tokens) para segurança e permissões. Esta API permite:

- Registro e login de usuários.
- Criação, listagem, edição e exclusão de tópicos.

O projeto utiliza banco de dados H2 em memória para desenvolvimento e testes.

---

## Requisitos

- Java 17+
- Maven 3.8+
- IDE como IntelliJ IDEA ou Eclipse

---

## Configuração do Projeto

1. **Clone o repositório**:
   ```bash
   git clone <https://github.com/Dnakalfa/forum_api-java>
   cd forum_api-java
   ```

2. **Configure o banco de dados H2**:
   - O arquivo `application.properties` está configurado para usar um banco H2 em memória.
   - Para acessar o console H2, habilite o console com:
     ```properties
     spring.h2.console.enabled=true
     spring.h2.console.path=/h2-console
     ```
   - Acesse: `http://localhost:8080/h2-console` com as credenciais padrão:
     - **JDBC URL**: `jdbc:h2:mem:forum`
     - **Username**: `sa`
     - **Password**: *(em branco)*

3. **Compile o projeto**:
   ```bash
   mvn clean install
   ```

4. **Inicie a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

---

## Endpoints

### Autenticação

- **Registro de Usuário**:
  - **POST** `/auth/register`
  - **Body** (JSON):
    ```json
    {
        "username": "seu_username",
        "password": "sua_senha"
    }
    ```

- **Login de Usuário**:
  - **POST** `/auth/login`
  - **Body** (JSON):
    ```json
    {
        "username": "seu_username",
        "password": "sua_senha"
    }
    ```
  - **Resposta**: Retorna um token JWT que deve ser usado nos endpoints protegidos.

### Tópicos

- **Listar Tópicos**:
  - **GET** `/topicos`
  - **Permissão**: Aberto a todos.

- **Adicionar Tópico**:
  - **POST** `/topicos`
  - **Body** (JSON):
    ```json
    {
        "titulo": "Meu Tópico",
        "mensagem": "Mensagem do tópico."
    }
    ```
  - **Permissão**: Token JWT obrigatório no cabeçalho `Authorization`.

- **Editar Tópico**:
  - **PUT** `/topicos/{id}`
  - **Body** (JSON):
    ```json
    {
        "titulo": "Novo Tópico",
        "mensagem": "Nova mensagem do tópico."
    }
    ```
  - **Permissão**: Token JWT obrigatório.

- **Excluir Tópico**:
  - **DELETE** `/topicos/{id}`
  - **Permissão**: Token JWT obrigatório.

---

## Estrutura do Projeto

- **Modelo**: `Usuario` e `Topico`
- **Repositórios**: `UsuarioRepository` e `TopicoRepository`
- **Serviços**:
  - `JwtService`: Gerencia tokens JWT.
- **Controladores**:
  - `AuthController`: Gerencia autenticação e registro.
  - `TopicoController`: Gerencia operações de tópicos.
- **Configuração**:
  - `SecurityConfig`: Configurações de segurança e filtros JWT.

---

## Exemplo de Uso com Postman

1. **Registrar um usuário**:
   - Enviar um POST para `/auth/register` com um corpo JSON.

2. **Obter o token JWT**:
   - Enviar um POST para `/auth/login` com as credenciais do usuário.

3. **Usar o token para acessar endpoints protegidos**:
   - Enviar o token JWT no cabeçalho `Authorization`:
     ```
     Authorization: Bearer <seu_token_jwt>
     ```

4. **Criar, listar, editar ou excluir tópicos**.

---

## Tecnologias Utilizadas

- **Spring Boot**:
  - Spring Web
  - Spring Security
  - Spring Data JPA
- **Banco de Dados**: H2
- **JWT**: Gerenciamento de autenticação.
- **Lombok**: Redução de boilerplate code.

---

## Melhorias Futuras

- Implementar roles para usuários (admin, user).
- Testes automatizados com JUnit e Mockito.
- Migração para banco de dados relacional como PostgreSQL ou MySQL.
- Documentação com Swagger/OpenAPI.

---

### Desenvolvido apartir de conhecimentos adquiridos em cursos, palestras e mentorias na Alura/Programa ONE - Oracle Next Education.

Atualmente estou ampliando estes pequenos projetos, que ocorrerão a medida que o aprendizado evoluir.

