package br.com.vitorhm.designpatterns.solid.ocp;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * Define uma classe de filtro para carros que implementa o {@link Filtro}.
 *
 * Sempre que houver uma nova condição no filtro, basta criarmos uma nova implementação da especificação.
 */
class FiltroCarroCorreto implements Filtro<Car> {

    @Override
    public Stream<Car> filterBy(@NotNull List<Car> objects, @NotNull Especificacao<Car> especificacao) {
        return objects.stream().filter(especificacao::isSatisfied);
    }

}
