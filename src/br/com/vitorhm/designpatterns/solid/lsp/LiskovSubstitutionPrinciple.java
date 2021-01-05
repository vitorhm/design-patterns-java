package br.com.vitorhm.designpatterns.solid.lsp;

/**
 * O princípio de substituição de Liskov determina que objetos que derivam de uma classe devem poder ser substituídos
 * por objetos dessa classe sem violar o contrato (ou prejudicar a aplicação).
 */
public class LiskovSubstitutionPrinciple {

    public static void calcula(Retangulo retangulo) {

        retangulo.setBase(10);

        System.out.println("Area calculada: " + retangulo.getArea());
    }

    public static void main(String[] args) {

        /*
            Aqui o retângulo é impresso corretamente!
         */
        Retangulo r = new Retangulo();
        r.setAltura(10);
        r.setBase(10);
        calcula(r);

        /*
            Aqui a área do quadrado fica inválida pelos seguintes motivos:
            1. Criamos uma instância do objeto Quadrado, e armazenamos em uma variável do tipo Retangulo (possível, pois o
            quadrado é um retângulo).
            2. Setamos a base do quadrado para 20. Nesse momento, tanto a base como a altura ficam 20, pois sobescrevemos
            o comportamento do quadrado para alterar a base e a altura ao mesmo tempo.
            3. Chamamos o método calcula informando nosso objeto quadrado.
            4. Dentro do método calcula, temos a chamada ao método setBase(10); Nesse caso, o método é chamado dentro
            da classe Retangulo, e não da classe Quadrado.
            5. Ao imprimir a base, ela ficará incorreta, pois ao setar a base 10 do retângulo, por ele ser um quadrado,
            o valor da altura deveria ser setado para 10 também.

            Logo violamos o princípio de Liskov, invalidamos a área do retângulo.
         */
        Retangulo q = new Quadrado();
        q.setBase(20);
        calcula(q);
    }

}
