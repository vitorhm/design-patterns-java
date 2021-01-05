package br.com.vitorhm.designpatterns.solid.ocp;

/**
 *
 * Define uma classe de especificação de cor que implementa a {@link Especificacao}
 *
 */
public class EspecificacaoCor implements Especificacao<Car> {

    final Cor cor;

    EspecificacaoCor(Cor cor) {
        this.cor = cor;
    }

    @Override
    public boolean isSatisfied(Car object) {
        return object.getColor() == cor;
    }
}