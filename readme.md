# Sistema de Cadastro de Usuários

Este é um sistema web desenvolvido em **Java Spring Boot** com **Thymeleaf**, utilizando arquitetura MVC e princípios de orientação a objetos. Ele permite o **cadastro, listagem e gerenciamento de usuários** de diferentes tipos (Comum, Administrador), além de aplicar diversos padrões de projeto para uma estrutura escalável e de fácil manutenção.

---

## Funcionalidades

- Cadastro de usuários comuns e administradores
- Separação de responsabilidades via herança (`@Inheritance`)
- Interface web com Thymeleaf e Bootstrap/Tailwind
- Validação de campos e tratamento de erros
- Persistência com JPA + MySQL

---
## Padrões de Projeto Aplicados
Este projeto adota boas práticas da engenharia de software com os padrões GoF:

**Factory Method**

Encapsula a lógica de criação de objetos Usuario com base no tipo (COMUM ou ADMINISTRADOR), facilitando futuras extensões.

**Builder**

Permite construir objetos complexos de maneira controlada e fluente, eliminando múltiplos construtores ou campos opcionais desordenados.

**Singleton**

Garante uma única instância da conexão com o banco, promovendo economia de recursos e controle centralizado.

---

## Requisitos

- Java 17+
- Maven 3.8+
- MySQL 8+
- IDE (IntelliJ, Eclipse, VS Code)

---

## Como Executar

1. **Clone o repositório:**

```bash
git clone https://github.com/lucastadaieski/sistema-cadastro.git
cd sistema-cadastro
```

---
## Diagrama de Classes
