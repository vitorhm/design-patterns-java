package br.com.vitorhm.designpatterns.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

/**
 * Define uma classe para filtrar uma lista de carros.
 *
 * Nesse caso, toda vez que for preciso filtrar por uma diferente condição, teríamos que modificar essa classe e
 * criar um novo método.
 */
public class FiltroCarroErrado {

    public Stream<Car> filtraPorCor(List<Car> listaCarros, Cor cor) {
        return listaCarros.stream().filter(p -> p.getColor() == cor);
    }

}
