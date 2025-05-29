import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ExemploColecao {
    public static void main(String[] args) {
        // Criando uma nova ArrayList
        ArrayList<String> lista = new ArrayList<>();

        // 1. Adicionando elementos
        lista.add("Maçã");
        lista.add("Banana");
        lista.add("Laranja");
        System.out.println("Lista após adições: " + lista);

        // 2. Removendo um elemento
        lista.remove("Banana");
        System.out.println("Lista após remoção: " + lista);

        // 3. Consultando o tamanho
        System.out.println("Tamanho da lista: " + lista.size());

        // 4. Verificando se a lista está vazia
        System.out.println("A lista está vazia? " + lista.isEmpty());

        // 5. Verificando se um elemento está na lista
        System.out.println("A lista contém 'Maçã'? " + lista.contains("Maçã"));

        // 6. Usando um iterador
        System.out.print("Elementos da lista: ");
        Iterator<String> iterator = lista.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 7. Convertendo para array
        Object[] array = lista.toArray();
        System.out.println("Lista como array: " + java.util.Arrays.toString(array));

        // 8. Usando operações com grupos
        ArrayList<String> outraLista = new ArrayList<>();
        outraLista.add("Laranja");
        outraLista.add("Uva");

        // 9. Verificando se contém todos os elementos de outra lista
        System.out.println("A lista contém todos os elementos de outra lista? " + lista.containsAll(outraLista));

        // 10. Adicionando todos os elementos de outra lista
        lista.addAll(outraLista);
        System.out.println("Lista após adicionar outra lista: " + lista);

        // 11. Limpando a lista
        lista.clear();
        System.out.println("Lista após limpar: " + lista);

        // 12. Adicionando elementos novamente para demonstrar removeAll e retainAll
        lista.add("Maçã");
        lista.add("Laranja");
        lista.add("Banana");

        ArrayList<String> listaParaRemover = new ArrayList<>();
        listaParaRemover.add("Laranja");
        listaParaRemover.add("Uva");

        // 13. Removendo todos os elementos que estão na outra lista
        lista.removeAll(listaParaRemover);
        System.out.println("Lista após remover elementos: " + lista);

        // 14. Retendo apenas os elementos que estão na outra lista
        lista.add("Laranja");
        lista.retainAll(listaParaRemover);
        System.out.println("Lista após reter elementos: " + lista);
    }
}
