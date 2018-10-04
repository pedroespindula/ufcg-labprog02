/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author João Pedro Santino Espíndula - 118110035
 */

package lab01;

import java.util.Scanner;

public class AnalisaFuncao {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean decrescente = false;
        boolean crescente = false;
        boolean numIgual = false;

        int numAtual = input.nextInt();
        int numAnterior = numAtual;

        for (int i = 0; i < 3; i++) {

            numAtual = input.nextInt();

            if (numAtual > numAnterior) {
                crescente = true;
            }
            if (numAtual < numAnterior) {
                decrescente = true;
            }
            if (numAtual == numAnterior) {
                numIgual = true;
            }

            numAnterior = numAtual;

        }

        if (crescente == decrescente || numIgual) {
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        } else {
            if (crescente) {
                System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
            }
            if (decrescente) {
                System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
            }

        }
    }
}
