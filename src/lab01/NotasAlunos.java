/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author João Pedro Santino Espíndula - 118110035
 */

package lab01;

import java.util.Scanner;

public class NotasAlunos {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String linha = input.nextLine();

        int maiorNota = 0;
        int menorNota = 0;
        int soma = 0;
        int media = 0;
        int notasAcima = 0;
        int notasAbaixo = 0;

        int nota = 0;
        int numNotas = 0;
        boolean menorSet = false;

        while (!linha.equals("-")) {

            nota = Integer.parseInt(linha.split(" ")[1]);



            if (maiorNota < nota) {
                maiorNota = nota;
            }
            if (!menorSet || menorNota > nota) {
                menorNota = nota;
                menorSet = true;
            }

            if (nota >= 700) {
                notasAcima++;
            } else {
                notasAbaixo++;
            }
            
            soma += nota;
            numNotas++;

            linha = input.nextLine();

        }
        
        if (numNotas > 0) {
            media = soma / numNotas;
        }

        System.out.println("maior: " + maiorNota);
        System.out.println("menor: " + menorNota);
        System.out.println("media: " + media);
        System.out.println("acima: " + notasAcima);
        System.out.println("abaixo: " + notasAbaixo);
    }
}
