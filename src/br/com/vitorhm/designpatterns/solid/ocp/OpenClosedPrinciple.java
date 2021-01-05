package br.com.vitorhm.designpatterns.solid.ocp;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * O princípio Open-Closed leva em conta que uma determinada classe deve ser aberta para implementações, mas fechada para
 * modificações.
 *
 */
public class OpenClosedPrinciple {

    public static void main(String[] args) {

        Car brancoNovo = new Car(Cor.BRANCO, Condicao.NOVO);
        Car vermelhoNovo = new Car(Cor.VERMELHO, Condicao.NOVO);
        Car pretoUsado = new Car(Cor.PRETO, Condicao.USADO);

        List<Car> carList = List.of(brancoNovo, pretoUsado, vermelhoNovo);

        /*
            Aqui fugimos do conceito Open-Closed, pois a classe FiltroCarroErrado sempre estará aberta para modificações.
            Pense na seguinte situação, hoje a classe possui 1 método para filtrar os carros: filtraPorCor.
            Amanhã será necessário filtrar esse carro por condição também. Nesse caso teremos que modificar a classe FiltroCarroErrado
            e adicionar um novo método para filtrar por condição.

            Seria muito melhor definir algumas interfaces para realizar esse filtro de forma genérica e que possa ainda
            ser reutilizado para outras classes no futuro.
         */
        FiltroCarroErrado filtroErrado = new FiltroCarroErrado();
        filtroErrado.filtraPorCor(carList, Cor.VERMELHO)
                .forEach(p -> System.out.println(" - " + p.getColor() + " " + p.getCondition()));

        /*
          É aqui que entra o princípio Open-Closed. Criamos a instância da nossa classe FiltroCarro,
          na qual implementa a interface genérica Filtro;

          O filtro então é realizado utilizado a especificação de cor através da classe EspecificacaoCor,
          na qual implementa a interface genérica Especificacao;

          Veja bem, sempre que houver a necessidade de incluir um novo filtro na nossa aplicação, basta criarmos uma nova
          classe que implementa a interface Especificacao e implementarmos nossa própria verificação dentro
          dela.

          Esse é o conceito Open-Closed, não precisamos de nenhuma forma modificar a classe que já está feita e funcionando
          em produção, apenas realizamos uma nova implementação de acordo com a nossa necessidade.

          Neste caso, se quisermos implementar um filtro para Condicao, basta criarmos uma nova classe de especificação
          de condição que implementa a Especificacao e realiza o teste baseado na Condicao informada.
         */
        FiltroCarroCorreto filtroCorreto = new FiltroCarroCorreto();
        Stream<Car> filteredCars = filtroCorreto.filterBy(carList, new EspecificacaoCor(Cor.BRANCO));
        filteredCars.forEach(p -> System.out.println(" - " + p.getColor() + " " + p.getCondition()));
    }

}

/**
 * Define um enum de cores
 */
enum Cor {
    BRANCO,
    PRETO,
    VERMELHO;
}

/**
 * Define um enum de condições
 */
enum Condicao {
    NOVO,
    USADO;
}