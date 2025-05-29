# 💻 Resolução: Implementação da Classe `Shelf`

## 1. Classe `Item`

```java
public class Item {
    private String nome;
    private Double peso;

    public Item(String nome, Double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public Double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return nome + " (" + peso + " kg)";
    }
}
```

> **Por que criar essa classe?**
> Facilita agrupar as informações de cada item em um só objeto, nome e peso juntos.

---

## 2. Classe `Shelf`

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Shelf {
    // Aqui temos uma fila para guardar os itens da prateleira
    private Queue<Item> itens;

    // Construtor da prateleira - inicializa a fila vazia
    public Shelf() {
        itens = new LinkedList<>();
    }

    // Método para adicionar um item na prateleira
    public void addItem(String nome, Double peso) {
        // Cria um novo item com nome e peso e adiciona no fim da fila
        itens.add(new Item(nome, peso));
    }

    // Método para remover o item que está na frente da fila (o primeiro que entrou)
    public void removeItem() {
        // Remove o primeiro item da fila (se não tiver, não faz nada)
        itens.poll();
    }

    // Método para procurar um item pelo nome
    public Item searchItem(String nome) {
        // Para cada item da fila, verifica se o nome bate
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                // Se achar, retorna esse item
                return item;
            }
        }
        // Se não achar nenhum, retorna null (vazio)
        return null;
    }

    // Método para transformar a prateleira em uma string legível
    @Override
    public String toString() {
        return itens.stream()                  // Pega um "fluxo" de itens
                    .map(Item::toString)      // Transforma cada item em texto
                    .collect(Collectors.joining(", ")); // Junta tudo separado por vírgula
    }

    // Método para calcular o peso total de todos os itens
    public double totalWeight() {
        return itens.stream()                  // Pega o fluxo de itens
                    .mapToDouble(Item::getPeso) // Pega só o peso de cada item
                    .sum();                   // Soma todos os pesos
    }

    // Método para contar quantos itens têm peso maior que a média dos pesos
    public long largeItems() {
        double media = itens.stream()          // Cria fluxo dos itens
                            .mapToDouble(Item::getPeso) // Pega o peso de cada um
                            .average()        // Calcula a média dos pesos
                            .orElse(0.0);     // Se não tiver itens, média = 0

        return itens.stream()                  // Cria outro fluxo dos itens
                    .filter(item -> item.getPeso() > media) // Filtra só os que pesam mais que a média
                    .count();                   // Conta quantos passaram no filtro
    }
}

```

---

## 3. Como funciona?

* **addItem**: adiciona no final da fila (cauda da prateleira).
* **removeItem**: remove do começo da fila (cabeça da prateleira).
* **searchItem**: percorre a fila procurando um item com o nome dado.
* **toString**: gera uma String com todos os itens na ordem de inserção, separados por vírgula.
* **totalWeight**: soma todos os pesos usando Streams.
* **largeItems**: conta quantos itens tem peso maior que a média dos pesos.

---

## 4. Exemplo de Teste

```java
public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf();

        shelf.addItem("Livro", 1.5);
        shelf.addItem("Notebook", 2.0);
        shelf.addItem("Garrafa", 0.75);

        System.out.println(shelf);

        System.out.println("Peso total: " + shelf.totalWeight());
        System.out.println("Itens acima da média: " + shelf.largeItems());

        System.out.println("Procurando 'Notebook': " + shelf.searchItem("Notebook"));

        shelf.removeItem();
        System.out.println("Depois de remover: " + shelf);
    }
}
```

---

## 5. Resultado esperado da execução

```
Livro (1.5 kg), Notebook (2.0 kg), Garrafa (0.75 kg)
Peso total: 4.25
Itens acima da média: 1
Procurando 'Notebook': Notebook (2.0 kg)
Depois de remover: Notebook (2.0 kg), Garrafa (0.75 kg)
```
---
    

