/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author João Pedro Santino Espíndula - 118110035
 */

package lab01;

import java.util.Scanner;

public class Wally {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String linha = input.nextLine();
        String[] nomes;

        String nomePossivel = "?";

        while (!linha.equals("wally")) {

            nomes = linha.split(" ");

            nomePossivel = "?";

            for (String nome: nomes) {

                if (nome.length() == 5) {
                    nomePossivel = nome;
                }
            }

            System.out.println(nomePossivel);

            linha = input.nextLine();

        }
    }
}
