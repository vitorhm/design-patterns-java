package br.com.vitorhm.designpatterns.solid.lsp;

public class Retangulo {

    private double base;
    private double altura;

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }

    public double getArea() {
        return base * altura;
    }
}
