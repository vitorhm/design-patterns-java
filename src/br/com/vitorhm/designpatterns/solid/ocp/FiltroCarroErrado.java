package br.com.vitorhm.designpatterns.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

public class FiltroCarroErrado {

    public Stream<Car> filtraPorCor(List<Car> listaCarros, Cor cor) {
        return listaCarros.stream().filter(p -> p.getColor() == cor);
    }

}
