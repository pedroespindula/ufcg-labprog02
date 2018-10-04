/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author João Pedro Santino Espíndula - 118110035
 */

package lab01;

import java.util.Scanner;

public class AcimaMedia {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] linha = input.nextLine().split(" ");

        int[] numeros = new int[linha.length];

        int c = 0;
        double soma = 0;
        for (String algarismo : linha) {
            numeros[c] = Integer.parseInt(algarismo);
            soma += numeros[c];
            c++;
        }

        double media;

        if (linha.length == 0) {
            media = 0;
        } else {
            media = soma / linha.length;
        }

        String resultado = "";
        for (int num : numeros) {
            if (num > media) {
                resultado += Integer.toString(num) + " ";
            }
        }

        System.out.println(resultado.substring(0, resultado.length()-1));




    }
}
