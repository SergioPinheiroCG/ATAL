# 📊 Aplicar Algoritmos de Apoio à Pesquisa Operacional

Bem-vindo(a)! Este repositório contém as atividades desenvolvidas durante a disciplina **Aplicar Algoritmos de Apoio à Pesquisa Operacional**, ministrada pelo professor **Wesley Gonzaga** e **Jonhnanthan Oliveira** no curso de **Sistemas da Informação - Unifacisa**. Aqui, exploraremos a implementação de algoritmos utilizados em pesquisa operacional para resolver problemas complexos de otimização. 🚀

---

## 📂 Estrutura do Repositório

As atividades estarão organizadas em pastas, de acordo com os temas abordados ao longo da disciplina. Cada atividade inclui uma breve explicação e a solução implementada em **Java**.

### Diretórios:

- **atividade-1/**: *Botando em prática a construção de uma estrutura de dados*  
  **Descrição**  
  Você foi desafiado a implementar uma estrutura de dados do zero.

  **O que deve ser feito?**  
  - **Questão 1:** Escolha uma das estruturas abaixo e desenvolva sua implementação:
    - Listas
    - Filas
    - Pilhas
    - Deques

---

- **atividade-2/**: *Pensando em qual a melhor estrutura de dados a ser utilizada*  
  **Descrição**  
  Você está desenvolvendo um sistema de gerenciamento de pedidos de uma cafeteria, e sua missão é criar a regra de negócio do coração da aplicação.  

  **Regra de negócio:**  
  - Os pedidos chegam em uma sequência contínua e devem ser processados em ordem de chegada, com três considerações especiais:
    1. **Clientes VIP** têm prioridade máxima.
    2. **Pedidos cancelados** devem ser removidos da lista.
    3. O gerente pode **visualizar os pedidos** pendentes sem removê-los.

  **O que deve ser feito?**  
  - **Questão 1 (Obrigatória):** Escreva um documento em formato markdown justificando sua escolha da estrutura de dados ideal para o problema.
  - **Questão 2 (Opcional):** Implemente uma classe de negócio que atenda às seguintes funcionalidades:
    - Adicionar um novo pedido.
    - Processar o próximo pedido.
    - Visualizar os pedidos na fila sem removê-los.
    - Remover um pedido cancelado.
    - Atualizar a prioridade de um pedido na fila.

---

- **atividade-3/**: *Explorando Árvores Binárias em Matrizes*  
  **Descrição**  
  Você foi desafiado a implementar uma árvore binária utilizando uma matriz 2D para simular os nós da árvore, sem o uso de estruturas de dados complexas como listas encadeadas.  

  **Regras e funcionalidades:**  
  - A matriz representa os nós da árvore, onde cada linha é um nó e as colunas armazenam:
    1. O valor do nó.
    2. O índice do filho esquerdo.
    3. O índice do filho direito.
  - A matriz inicial tem capacidade para 5 nós, mas se expande automaticamente em blocos de 5 quando necessário.  
  - A árvore deve respeitar a propriedade de ordenação de árvores binárias:
    - Valores menores vão para o filho esquerdo.
    - Valores maiores vão para o filho direito.

  **O que deve ser feito?**  
  - **Questão 1:** Desenvolver as funcionalidades básicas da árvore:
    - Inserir um novo valor na árvore.
    - Expandir a matriz quando não houver espaço disponível.
    - Exibir a árvore no console, indicando o índice, valor, e os filhos esquerdo e direito.  


## 🛠 Tecnologias Utilizadas

- **Java**
- **Eclipse IDE 2024-06**
- **VSCODE IDE 1.95.3**

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SergioPinheiroCG/ATAL.git

