package br.com.vitorhm.designpatterns.solid.srp;

import java.io.FileNotFoundException;

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


