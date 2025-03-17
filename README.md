# 🚗 Concessionária Online em Java
Este repositório contém um sistema de **Concessionária Online** desenvolvido em **Java**, focado em praticar conceitos de programação orientada a objetos, estruturas de dados e boas práticas de desenvolvimento. O projeto permite gerenciar **veículos**, **clientes**, **pedidos** e **estoque** de forma simples e organizada.

## 📌 Requisitos

Para executar o projeto corretamente, você precisará ter instalado:

* Java JDK 8 ou superior
* Maven (opcional, caso utilize para gerenciamento de dependências)

## 🚀 Como Executar o Projeto

1. **Clone** este repositório em sua máquina:
   ```sh
   git clone https://github.com/SEU-USUARIO/dealership.git
   ```

2. **Acesse** o diretório do projeto:
   ```sh
   cd dealership
   ```

3. **Compile e execute** (exemplo sem Maven):
   ```sh
   javac -cp src src/main/java/com/dealership/Dealership.java
   java -cp src main.java.com.dealership.Dealership
   ```
   *Caso utilize Maven, você pode rodar:*  
   ```sh
   mvn clean install
   mvn exec:java -Dexec.mainClass="main.java.com.dealership.Dealership"
   ```

## 🔄 Funcionamento

O sistema permite:

* **Gerenciar Veículos**: cadastro, listagem e remoção de veículos.
* **Controle de Estoque**: adicionar veículos ao estoque, remover e atualizar quantidades.
* **Gerenciar Clientes**: cadastrar, listar e remover clientes.
* **Gerenciar Pedidos**: criar novos pedidos associando cliente e veículos, removê-los e ajustar o estoque de forma automática.

### 📌 Tecnologias Utilizadas
- Java (versão 8+)
- Coleções (List, Set) para armazenamento em memória
- Scanner para entrada de dados via console
- Boas práticas de POO (camadas de model, repository, service e controller)

## ✨ Funcionalidades
✔️ **CRUD** de veículos, clientes, pedidos e estoque  
✔️ **Atualização automática** do estoque ao adicionar/remover pedidos  
✔️ **Menu** interativo para navegação por submenus (Veículos, Estoque, Clientes e Pedidos)  
✔️ **Tratamento de exceções** para entradas inválidas e busca de dados inexistentes

## 📜 Licença

Este projeto está sob a licença MIT. Sinta-se à vontade para usá-lo, modificá-lo e contribuir!

---
*Criado como parte do meu aprendizado em Java.* 🚀`;