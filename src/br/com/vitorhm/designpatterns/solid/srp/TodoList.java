package br.com.vitorhm.designpatterns.solid.srp;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Representa uma lista de tarefas. Limita-se as funções de adicionar ou remover uma tarefa e providenciar as tarefas que
 * estão contidas na lista.
 *
 * No nosso caso, a responsabilidade primária da classe é gerenciar a sua lista de tarefas.
 *
 */
public class TodoList {

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
