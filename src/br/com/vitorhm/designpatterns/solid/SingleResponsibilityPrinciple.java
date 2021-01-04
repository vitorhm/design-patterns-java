package br.com.vitorhm.designpatterns.solid;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Single Responsibility Principle é um padrão de design que estabelece que uma classe deve ter apenas
 * uma responsabilidade primária. <br><br>
 *
 */
public class SingleResponsibilityPrinciple {

    public static void main(String[] args) throws FileNotFoundException {

        TodoList toDo = new TodoList();
        toDo.addTask("Tirar o lixo");
        toDo.addTask("Fazer as compras");

        // Incorreto, quebra o príncipio de SRP
        toDo.saveTodoList("Teste.txt");

        // Correto, separa as funções de cada clase
        Persist persist = new Persist();
        persist.saveToFile(toDo, "Teste.txt");
    }

}

/**
 *
 * Representa uma lista de tarefas. Limita-se as funções de adicionar ou remover uma tarefa e providenciar as tarefas que
 * estão contidas na lista.
 *
 * No nosso caso, a responsabilidade primária da classe é gerenciar a sua lista de tarefas.
 *
 */
class TodoList {

    private final List<String> tarefas = new ArrayList<>();

    public void addTask(String task) {
        tarefas.add(task);
    }

    public void removeTask(int index) {
        tarefas.remove(index);
    }

    /**
     *
     * Este método específico quebra o príncipio do SRP, pois nesse caso teríamos uma classe que além de gerenciar as
     * tarefas, também teria a função de persisti-las. <br><br>
     *
     * Neste caso, o ideal seria separar essa função em uma nova classe que realizaria a exportação dos arquivos, para isso
     * criamos a classe {@link Persist}
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    @Deprecated
    public void saveTodoList(String fileName) throws FileNotFoundException {

        try (PrintStream out = new PrintStream(fileName)) {
            out.println(toString());
        }

    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), tarefas);
    }
}

/**
 *
 * Realiza a exportação de uma lista de tarefas.
 *
 */
class Persist {

    public void saveToFile(TodoList todoList, String fileName) throws FileNotFoundException {

        try (PrintStream out = new PrintStream(fileName)) {
            out.println(todoList.toString());
        }

    }

}
