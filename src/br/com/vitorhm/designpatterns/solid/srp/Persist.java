package br.com.vitorhm.designpatterns.solid.srp;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *
 * Realiza a exportação de uma lista de tarefas.
 *
 */
public class Persist {

    public void saveToFile(TodoList todoList, String fileName) throws FileNotFoundException {

        try (PrintStream out = new PrintStream(fileName)) {
            out.println(todoList.toString());
        }

    }

}
