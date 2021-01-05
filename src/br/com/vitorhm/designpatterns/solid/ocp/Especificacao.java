package br.com.vitorhm.designpatterns.solid.ocp;

/**
 * Define uma especificação
 *
 * @param <T>
 */
public interface Especificacao<T> {

    /**
     *
     * Retorna se a especificação é verdadeira ou falsa para o objeto informado.
     *
     * @param object
     * @return
     */
    boolean isSatisfied(T object);
}