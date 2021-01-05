package br.com.vitorhm.designpatterns.solid.lsp;

/**
 * De acordo com a matemática, um quadrado É um retângulo.
 *
 * Para os métodos que setam a altura e a base, alteramos seu comportamento e setamos a base e a altura juntos em cada
 * set, afinal, um quadrado tem a mesma base e altura.
 *
 */
public class Quadrado extends Retangulo {

    /**
     * Neste caso violamos o contrato de Liskov, pois violamos o comportamento esperado da classe base. No nosso exemplo,
     * violamos uma condição chamada: Invariants must be preserved.
     *
     * Ou seja, nosso retângulo apenas setava a variável altura. Já o nosso quadrado mudou o comportamento e está setando
     * também a variável base, fazendo com que o nosso código possa quebrar.
     *
     * @param altura
     */
    @Override
    public void setAltura(double altura) {
        super.setBase(altura);
        super.setAltura(altura);
    }

    @Override
    public void setBase(double base) {
        super.setBase(base);
        super.setAltura(base);
    }
}
