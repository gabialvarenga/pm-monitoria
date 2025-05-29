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
    private Queue<Item> itens;

    public Shelf() {
        itens = new LinkedList<>();
    }

    public void addItem(String nome, Double peso) {
        itens.add(new Item(nome, peso));
    }

    public void removeItem() {
        itens.poll(); // remove o primeiro item (cabeça da fila)
    }

    public Item searchItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                return item;
            }
        }
        return null; // item não encontrado
    }

    @Override
    public String toString() {
        return itens.stream()
                    .map(Item::toString)
                    .collect(Collectors.joining(", "));
    }

    public double totalWeight() {
        return itens.stream()
                    .mapToDouble(Item::getPeso)
                    .sum();
    }

    public long largeItems() {
        double media = itens.stream()
                            .mapToDouble(Item::getPeso)
                            .average()
                            .orElse(0.0);

        return itens.stream()
                    .filter(item -> item.getPeso() > media)
                    .count();
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

