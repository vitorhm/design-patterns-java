package br.com.vitorhm.designpatterns.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

/**
 * Define uma interface de filtro genérica.
 *
 * @param <T>
 */
public interface Filtro<T> {

    /**
     *
     * Realiza o filtro de uma lista genérica respeitando a especificação informada.
     *
     * @param objects
     * @param especificacao
     * @return
     */
    Stream<T> filterBy(List<T> objects, Especificacao<T> especificacao);
}
