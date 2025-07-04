# Guia Prático: Java Collections, Streams, Comparable e Comparator
## 1. Java Collections Framework (JCF)
O **Java Collections Framework** é um conjunto de interfaces e classes que facilitam o armazenamento, acesso e manipulação de dados de forma eficiente.

### Principais Interfaces:

* **List**: Coleção ordenada que permite elementos duplicados.
* **Set**: Coleção que não permite elementos duplicados.
* **Queue**: Coleção usada para processar elementos em uma ordem específica (geralmente FIFO).
* **Map**: Estrutura que mapeia chaves para valores, sem duplicação de chaves.

### Quando Usar Cada Uma:

| Situação                          | Interface Ideal |
| --------------------------------- | --------------- |
| Manter ordem de inserção          | List            |
| Evitar elementos duplicados       | Set             |
| Processar elementos em ordem FIFO | Queue           |
| Associar chaves a valores         | Map             |

### Exemplo de Uso:

```java
import java.util.*;

public class ExemploCollections {
    public static void main(String[] args) {
        // List
        List<String> lista = new ArrayList<>();
        lista.add("Maçã");
        lista.add("Banana");
        System.out.println("Lista: " + lista);

        // Set
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Maçã");
        conjunto.add("Banana");
        conjunto.add("Maçã"); // Duplicado, não será adicionado
        System.out.println("Conjunto: " + conjunto);

        // Queue
        Queue<String> fila = new LinkedList<>();
        fila.add("Primeiro");
        fila.add("Segundo");
        System.out.println("Fila: " + fila);

        // Map
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 2);
        mapa.put("Banana", 3);
        System.out.println("Mapa: " + mapa);
    }
}
```

---

## 2. Iteração com for-each e Iterator

### for-each:

Forma simplificada de percorrer coleções.

```java
List<String> nomes = Arrays.asList("Ana", "Bia", "Carlos");
for (String nome : nomes) {
    System.out.println(nome);
}
```

### Iterator:

Permite percorrer a coleção e remover elementos durante a iteração.

```java
List<String> nomes = new ArrayList<>(Arrays.asList("Ana", "Bia", "Carlos"));
Iterator<String> iterator = nomes.iterator();
while (iterator.hasNext()) {
    String nome = iterator.next();
    if (nome.equals("Bia")) {
        iterator.remove();
    }
}
System.out.println(nomes);
```

---

## 3. API de Streams em Java

Introduzida no Java 8, a API de Streams permite processar coleções de forma funcional e declarativa.

### Exemplo: Método totalWeight

Objetivo: Calcular o peso total dos itens armazenados na prateleira.

```java
public double totalWeight() {
    return items.stream()
                .map(Item::getPeso)
                .reduce(0.0, Double::sum);
}
```

**Explicação:**

* `stream()` inicia o processamento da coleção.
* `map(Item::getPeso)` transforma cada `Item` em seu respectivo peso (`Double`).
* `reduce(0.0, Double::sum)` soma todos os pesos, começando de 0.0.

### Exemplo: Método largeItems

Objetivo: Determinar a quantidade de itens cujo peso é superior ao peso médio dos itens na prateleira.

```java
public long largeItems() {
    double total = items.stream()
                        .mapToDouble(Item::getPeso)
                        .sum();
    double average = total / items.size();
    return items.stream()
                .filter(item -> item.getPeso() > average)
                .count();
}
```

**Explicação:**

* `mapToDouble(Item::getPeso)` cria um `DoubleStream`, permitindo operações numéricas.
* `sum()` calcula o total dos pesos.
* `filter(item -> item.getPeso() > average)` seleciona apenas os itens com peso acima da média.
* `count()` retorna a quantidade de itens que atendem ao critério.

---

## 4. Ordenação com Comparable e Comparator

### Comparable:

Define a ordem natural dos objetos dentro da própria classe.

```java
public class Item implements Comparable<Item> {
    private String nome;
    private Double peso;

    @Override
    public int compareTo(Item outro) {
        return this.nome.compareTo(outro.nome);
    }
}
```

### Comparator:

Define uma ordem personalizada fora da classe.

```java
Comparator<Item> compararPorPeso = new Comparator<Item>() {
    @Override
    public int compare(Item i1, Item i2) {
        return i1.getPeso().compareTo(i2.getPeso());
    }
};
```

---

## 5. Implementação de Métodos na Classe Shelf

### addItem:

Adiciona um item ao final da prateleira.

```java
public void addItem(Item item) {
    items.add(item);
}
```

### removeItem:

Remove o primeiro item da prateleira.

```java
public Item removeItem() {
    if (!items.isEmpty()) {
        return items.remove(0);
    }
    return null;
}
```

### searchItem:

Pesquisa um item pelo nome.

```java
public Item searchItem(String nome) {
    for (Item item : items) {
        if (item.getNome().equals(nome)) {
            return item;
        }
    }
    return null;
}
```

### toString:

Imprime os elementos na ordem em que foram inseridos.

```java
@Override
public String toString() {
    return items.toString();
}
```

---

## Recursos Adicionais

* [Java Collections Tutorial - GeeksforGeeks](https://www.geeksforgeeks.org/java-collection-tutorial/)
* [Java e Stream](https://youtu.be/HH0jHqvuQLg?si=Le2XEut6xwg98eDp)
* [Comparable vs Comparator in Java - GeeksforGeeks](https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/)

