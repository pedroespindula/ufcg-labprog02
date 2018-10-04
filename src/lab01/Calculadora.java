/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author João Pedro Santino Espíndula - 118110035
 */

package lab01;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        String operacao = input.next();

        if (operacao.equals("+") || operacao.equals("-") || operacao.equals("*") || operacao.equals("/")) {

            double num01 = input.nextDouble();
            double num02 = input.nextDouble();

            double resultado = 0;

            boolean erroZero = false;

            switch (operacao) {

                case "+": {
                    resultado = num01 + num02;
                    break;
                }
                case "-": {
                    resultado = num01 - num02;
                    break;
                }
                case "*": {
                    resultado = num01 * num02;
                    break;
                }
                case "/": {
                    if (num02 == 0) {
                        erroZero = true;
                        break;
                    } else {
                        resultado = num01 / num02;
                    }
                    break;
                }

            }

            if (erroZero) {
                System.out.println("ERRO");
            } else {
                System.out.println("RESULTADO: " + resultado);
            }


        } else {
            System.out.println("ENTRADA INVALIDA");
        }
    }

}
