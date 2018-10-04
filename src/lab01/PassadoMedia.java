/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author João Pedro Santino Espíndula - 118110035
 */

package lab01;

import java.util.Scanner;

public class PassadoMedia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double num01 = input.nextDouble();
        double num02 = input.nextDouble();

        double media = (num01 + num02) / 2;

        if (media >= 7.0) {
            System.out.println("pass: True!");
        } else {
            System.out.println("pass: False!");
        }

    }
}
