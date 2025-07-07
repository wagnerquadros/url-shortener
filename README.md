# 🔗 URL Shortener

---

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.0-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)](https://www.postgresql.org/)
[![Status](https://img.shields.io/badge/status-working-success)]()

> Um encurtador de URLs simples e eficiente com expiração automática das URLs após 24h, desenvolvido com Spring Boot e PostgreSQL.



## 🚀 Funcionalidades

---


- Criação de URLs encurtadas com código aleatório
- Redirecionamento automático para a URL original
- Expiração automática das URLs após 24 horas
- Agendamento de limpeza via `@Scheduled`
- API RESTful estruturada com boas práticas (DTO, Service, Repository)



## 🔧 Tecnologias utilizadas

---
![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-6DB33F?style=for-the-badge&logo=spring-boot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-4169E1?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-Build-CC0033?style=for-the-badge&logo=apache-maven)
![Lombok](https://img.shields.io/badge/Lombok-Anotations-EF4429?style=for-the-badge&logo=apache)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate)

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Hibernate
- Lombok
- Maven
- Jakarta Bean Validation



## 📦 Como rodar localmente

---

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/url-shortener.git
cd url-shortener

# 2. Configure o banco de dados no application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/urlshortener
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


# 3. Rode o projeto
./mvnw spring-boot:run
```


# 📡 Endpoints da API - URL Shortener

---
A seguir estão os endpoints disponíveis para uso da API de encurtador de URLs.



## 🔗 Criar URL Encurtada

## `POST /shorten`

Cria uma nova URL encurtada válida por 24 horas.
🧾 Requisição
    
- URL: http://localhost:8080/shorten
- Método: POST
- Content-Type: application/json
- Corpo da Requisição:

```json
{
  "url": "https://www.exemplo.com"
}
```
### ✅ Resposta de Sucesso
```json
{
    "shortUrl": "http://seulink.com/abc123"
}
```
- ### Status: 200 OK

## 🔁 Redirecionar para a URL Original
## `GET /{shortCode}`

Redireciona automaticamente o usuário para a URL original associada ao código encurtado, caso ainda esteja válida

### 🧾 Requisição
- URL: http://localhost:8080/{shortCode}
- Método: GET
- Parâmetros:

| Parâmetro   | Tipo     | Obrigatório | Descrição                       |
|-------------|----------|-------------|---------------------------------|
| shortCode   | `string` | Sim         | Código gerado para a URL curta |

### 🔄 Exemplo de Requisição

```http
GET http://localhost:8080/abc123
```

### ✅ Resposta de Sucesso
- Status: 302 Found
- Cabeçalho: Location: https://www.exemplo.com

### ❌ Exemplo de Erro
- Status: 404 Not Found
- Corpo da resposta:
``
  Short URL not found or expired
``

## 📁 Estrutura do Projeto

---

```Pastas
urlshortener/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── wagnerquadros/
│       │           └── urlshortener/
│       │               ├── controller/
│       │               │   └── ShortUrlController.java
│       │               ├── dto/
│       │               │   └── ShortenRequestDto.java
│       │               ├── entity/
│       │               │   └── ShortUrl.java
│       │               ├── repository/
│       │               │   └── ShortUrlRepository.java
│       │               └── service/
│       │                   └── ShortUrlService.java
│       └── resources/
│           ├── application.properties
│           └── static/docs/index.html
├── pom.xml                   
└── README.md
```



# 📄 Licença

---

[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

Este projeto está licenciado sob a Licença MIT.  
Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Desenvolvido por

---

[![GitHub - wagnerquadros](https://img.shields.io/badge/GitHub-wagnerquadros-181717?logo=github)](https://github.com/wagnerquadros)

Sinta-se à vontade para contribuir, abrir issues ou enviar sugestões!