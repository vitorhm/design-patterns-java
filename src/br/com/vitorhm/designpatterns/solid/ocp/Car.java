package br.com.vitorhm.designpatterns.solid.ocp;

/**
 *
 * Define uma classe carro com as propriedades de {@link Cor} e {@link Condicao}
 *
 */
public class Car {

    private final Cor cor;
    private final Condicao condicao;

    public Car(Cor cor, Condicao condicao) {
        this.cor = cor;
        this.condicao = condicao;
    }

    public Cor getColor() {
        return cor;
    }

    public Condicao getCondition() {
        return condicao;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color=" + cor +
                ", condition=" + condicao +
                '}';
    }
}