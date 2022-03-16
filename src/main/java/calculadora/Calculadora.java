package calculadora;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Calculadora {

    public static void main(String[] args) {

        //Suma
        IntBinaryOperator sumar = (a, b)-> a + b;

        //resta
        IntBinaryOperator restar = (a, b)-> a - b;

        //multiplicacion
        IntBinaryOperator mult = (a,b)-> IntStream.range(0,b+1)
                .reduce((contador, numero)-> sumar.applyAsInt(contador, a)).getAsInt();

        //division
        IntBinaryOperator div = (numerador,denominador) -> IntStream.range(0,numerador)
                .reduce((contador, numero)-> {
                    if(mult.applyAsInt(numero,denominador) <= numerador){
                        return contador = contador +1;
                    }
                    return contador ;
                }).getAsInt();

        System.out.println(sumar.applyAsInt(12,4));
        System.out.println(restar.applyAsInt(20,5));
        System.out.println(mult.applyAsInt(7,8));
        System.out.println(div.applyAsInt(50,9));
    }
}
