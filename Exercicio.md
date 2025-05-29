## Exercício Avaliativo: Implementação da Classe `Shelf` com Java Collections e Streams

### Objetivo

Implementar uma classe `Shelf` que representa uma prateleira genérica capaz de armazenar uma coleção de itens, utilizando o Java Collections Framework e a API de Streams.

### Especificações

* A prateleira deve armazenar itens com:

  * **Nome**: `String`
  * **Peso**: `Double`

* A classe `Shelf` deve conter os seguintes métodos:

  * `addItem`: Adiciona um novo item ao final (cauda) da prateleira.
  * `removeItem`: Remove o item do início (cabeça) da prateleira.
  * `searchItem`: Pesquisa um item pelo seu nome.
  * `toString`: Retorna uma representação em `String` dos itens na ordem em que foram inseridos.

* Utilizando Java Streams, implementar:

  * `totalWeight`: Retorna o peso total dos itens na prateleira.
  * `largeItems`: Retorna o número de itens com peso superior ao peso médio dos itens armazenados.

### Requisitos

* Utilizar o Java Collections Framework para armazenar os itens.
* Garantir que os itens sejam inseridos ao final e removidos do início da prateleira.
* Utilizar a API de Streams para as operações de agregação (`totalWeight` e `largeItems`).

### Dicas

* Considere criar uma classe `Item` com os atributos `nome` e `peso`.
* Utilize uma estrutura de dados que mantenha a ordem de inserção, como `LinkedList`.
* Para as operações com Streams:

  * `mapToDouble` pode ser útil para extrair os pesos dos itens.
  * `filter` pode ser utilizado para selecionar itens com peso acima da média.
  * `count` retorna o número de elementos em um Stream.
