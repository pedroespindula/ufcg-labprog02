package lab02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Modo de execução do Coisa por linha de comando.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class CoisaCL {

    /**
     * Coleção de alunos do Coisa que são identificados a partir do nome.
     */
    private static Map<String, Aluno> alunos = new HashMap<>();

    /**
     * A quantidade de alunos presentes no Coisa.
     */
    private static int quantidadeAlunos = 0;

    /**
     * Método main que decide qual operação será realizada.
     *
     * @param args os argumentos passados na execução do programa.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("= = = = Bem vindo ao COISA = = = =");
        System.out.println("Digite um comando para começar ou \"SAIR\" para sair.");

        while (true) {

            System.out.print(">>> ");
            String[] entrada = input.nextLine().toUpperCase().trim().split(" ");
            
            String metodoEscolhido = entrada[0];

            String[] cmdArgs = new String[entrada.length-1];
            System.arraycopy(entrada, 1, cmdArgs, 0, cmdArgs.length);


            if (metodoEscolhido.equals("CRIARALUNO")) {
                if (qntValidaArgs(cmdArgs, 1)) {
                    String nomeAluno = cmdArgs[0];
                    alunos.put(nomeAluno, new Aluno(++quantidadeAlunos, nomeAluno));
                }
            } else {

                try {

                    switch (metodoEscolhido) {
                        case "IMPRIMIRALUNOS":
                            imprimirTodosAlunos();
                            break;
                        case "SAIR":
                            System.exit(0);
                            break;
                    }

                    if (cmdArgs.length >= 1) {
                        Aluno aluno = alunos.get(cmdArgs[0]);
                        cmdArgs = copiaArray(cmdArgs, 1);

                        switch (metodoEscolhido) {
                            case "DEFINIRSAUDEMENTAL":
                                definirSaudeMental(cmdArgs, aluno);
                                break;
                            case "DEFINIRSAUDEFISICA":
                                definirSaudeFisica(cmdArgs, aluno);
                                break;
                            case "DEFINIREMOJI":
                                definirEmoji(cmdArgs, aluno);
                                break;
                            case "IMPRIMIRESTADOGERAL":
                                imprimirEstadoGeral(aluno);
                                break;
                            case "IMPRIMIRALUNO":
                                imprimirAluno(aluno);
                                break;
                        }
                        if (cmdArgs.length >= 1) {
                            String keyObjeto = cmdArgs[1];
                            cmdArgs = copiaArray(cmdArgs, 1);

                            switch (metodoEscolhido) {
                                case "CADASTRARCANTINA":
                                    cadastrarCantina(aluno, keyObjeto);
                                    break;
                                case "CADASTRARLANCHE":
                                    cadastrarLanche(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "PAGARCONTA":
                                    pagarConta(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "FALTAPAGAR":
                                    getFaltaPagar(aluno, keyObjeto);
                                    break;
                                case "IMPRIMIRDETALHES":
                                    imprimirDetalhes(aluno, keyObjeto);
                                    break;
                                case "IMPRIMIRCANTINA":
                                    imprimirCantina(aluno, keyObjeto);
                                    break;
                                case "REMOVERCANTINA":
                                    removerCantina(aluno, keyObjeto);
                                    break;

                                case "CADASTRARDISCIPLINA":
                                    cadastrarDisciplina(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "CADASTRARHORAS":
                                    cadastrarHoras(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "CADASTRARNOTA":
                                    cadastrarNota(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "CHECARAPROVACAO":
                                    checarAprovacao(aluno, keyObjeto);
                                    break;
                                case "IMPRIMIRDISCIPLINA":
                                    imprimirDisciplina(aluno, keyObjeto);
                                    break;
                                case "REMOVERDISCIPLINA":
                                    removerDisciplina(aluno, keyObjeto);
                                    break;

                                case "CADASTRARLABORATORIO":
                                    cadastrarLaboratorio(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "CONSUMIRESPACO":
                                    consumirEspaco(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "LIBERARESPACO":
                                    liberarEspaco(cmdArgs, aluno, keyObjeto);
                                    break;
                                case "ATINGIUCOTA":
                                    atingiuCota(aluno, keyObjeto);
                                    break;
                                case "IMPRIMIRLABORATORIO":
                                    imprimirLaboratorio(aluno, keyObjeto);
                                    break;
                                case "REMOVERLABORATORIO":
                                    removerLaboratorio(aluno, keyObjeto);
                                    break;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Aluno ou conta não encontrada.");
                } catch (Exception e) {
                    System.out.println("Alguma coisa deu errado: " + e);
                }
            }
        }
    }


    /**
     * Verifica se a quantidade de argumentos passada é valida para a operação em questão.
     *
     * @param args    os argumentos passados por linha de comando.
     * @param numArgs o número de argumentos necessário para a operação.
     * @return se a quantidade de argumentos é válida.
     */
    private static boolean qntValidaArgs(String[] args, int numArgs) {
        if (args.length >= numArgs) {
            return true;
        } else {
            System.out.println("Quantidade inválida de argumentos. Quantidade minima: " + numArgs);
            return false;
        }
    }


    // ===========================================================================================================


    private static void cadastrarCantina(Aluno aluno, String nomeCantina) {

        aluno.cadastraCantina(nomeCantina);

    }

    private static void cadastrarLanche(String[] args, Aluno aluno, String nomeCantina) {
        if (qntValidaArgs(args, 2)) {

            int qtdItens = Integer.parseInt(args[0]);
            int valorCentavos = Integer.parseInt(args[1]);

            if (args.length >= 3) {
                String detalhes = args[2];
                aluno.cadastraLanche(nomeCantina, qtdItens, valorCentavos, detalhes);
            } else {
                aluno.cadastraLanche(nomeCantina, qtdItens, valorCentavos);
            }

        }
    }

    private static void pagarConta(String[] args, Aluno aluno, String nomeCantina) {
        if (qntValidaArgs(args, 1)) {

            int valorCentavos = Integer.parseInt(args[0]);
            aluno.pagarConta(nomeCantina, valorCentavos);

        }
    }

    private static void getFaltaPagar(Aluno aluno, String nomeCantina) {

        System.out.println(nomeCantina + " - " + aluno.getFaltaPagar(nomeCantina) + " (Em centavos)");

    }

    private static void imprimirDetalhes(Aluno aluno, String nomeCantina) {

        aluno.listarDetalhes(nomeCantina);

    }

    private static void imprimirCantina(Aluno aluno, String nomeCantina) {

        System.out.println(aluno.cantinaToString(nomeCantina));

    }

    private static void removerCantina(Aluno aluno, String nomeCantina) {

        aluno.removeCantina(nomeCantina);

    }


    // ==========================================================================================================


    private static void cadastrarDisciplina(String[] args, Aluno aluno, String nomeDisciplina) {

            if (args.length == 1) {

                int qtdNotas = Integer.parseInt(args[0]);
                aluno.cadastraDisciplina(nomeDisciplina, qtdNotas);

            } else if (args.length >= 2) {

                int qtdNotas = Integer.parseInt(args[1]);

                if (args.length == 2 + qtdNotas) {

                    int[] pesos = recolhePesos(args, qtdNotas);
                    aluno.cadastraDisciplina(nomeDisciplina, qtdNotas, pesos);

                } else {

                    System.out.println("Quantidade pesos inválida");
                }
            } else {

                aluno.cadastraDisciplina(nomeDisciplina);
            }
    }

    private static void cadastrarHoras(String[] args, Aluno aluno, String nomeDisciplina) {
        if (qntValidaArgs(args, 1)) {

            int horas = Integer.parseInt(args[0]);
            aluno.cadastraHoras(nomeDisciplina, horas);

        }

    }

    private static void cadastrarNota(String[] args, Aluno aluno, String nomeDisciplina) {
        if (qntValidaArgs(args, 2)) {

            int nota = Integer.parseInt(args[0]);
            double valorNota = Double.parseDouble(args[1]);
            aluno.cadastraNota(nomeDisciplina, nota, valorNota);

        }

    }

    private static void checarAprovacao(Aluno aluno, String nomeDisciplina) {

        System.out.println("Está aprovado: " + aluno.aprovado(nomeDisciplina));

    }

    private static void imprimirDisciplina(Aluno aluno, String nomeDisciplina) {

        System.out.println(aluno.disciplinaToString(nomeDisciplina));

    }

    private static void removerDisciplina(Aluno aluno, String nomeDisciplina) {

        aluno.removeDisciplina(nomeDisciplina);

    }


    // ============================================================================================================


    private static void cadastrarLaboratorio(String[] args, Aluno aluno, String nomeLaboratorio) {

        if (args.length >= 1) {
            int cota = Integer.parseInt(args[0]);
            aluno.cadastraLaboratorio(nomeLaboratorio, cota);
        } else {
            aluno.cadastraLaboratorio(nomeLaboratorio);
        }

    }

    private static void consumirEspaco(String[] args, Aluno aluno, String nomeLaboratorio) {
        if (qntValidaArgs(args, 1)) {

            int mbytes = Integer.parseInt(args[0]);
            aluno.consomeEspaco(nomeLaboratorio, mbytes);

        }

    }

    private static void liberarEspaco(String[] args, Aluno aluno, String nomeLaboratorio) {
        if (qntValidaArgs(args, 1)) {

            int mbytes = Integer.parseInt(args[0]);
            aluno.liberaEspaco(nomeLaboratorio, mbytes);

        }

    }

    private static void atingiuCota(Aluno aluno, String nomeLaboratorio) {

        System.out.println("Atingiu cota: " + aluno.atingiuCota(nomeLaboratorio));

    }

    private static void imprimirLaboratorio(Aluno aluno, String nomeLaboratorio) {

        System.out.println(aluno.laboratorioToString(nomeLaboratorio));

    }

    private static void removerLaboratorio(Aluno aluno, String nomeLaboratorio) {

        aluno.removeLaboratorio(nomeLaboratorio);

    }


    // ============================================================================================================

    private static void definirSaudeMental(String[] args, Aluno aluno) {
        if (qntValidaArgs(args, 1)) {

            String valor = args[0];
            aluno.defineSaudeMental(valor);

        }

    }

    private static void definirSaudeFisica(String[] args, Aluno aluno) {
        if (qntValidaArgs(args, 1)) {

            String valor = args[0];
            aluno.defineSaudeFisica(valor);
        }
    }

    private static void definirEmoji(String[] args, Aluno aluno) {
        if (qntValidaArgs(args, 1)) {

            String valor = args[0];
            aluno.definirEmoji(valor);
        }
    }

    private static void imprimirEstadoGeral(Aluno aluno) {

        System.out.println(aluno.getStatusGeral());

    }


    // ===========================================================================================================


    private static void imprimirAluno(Aluno aluno) {

        System.out.println(aluno.toString());

    }

    private static void imprimirTodosAlunos() {

        Iterator iterador = alunos.entrySet().iterator();

        while (iterador.hasNext()) {
            Map.Entry par = (Map.Entry) iterador.next();
            System.out.println(par.getValue().toString());
            iterador.remove(); // avoids a ConcurrentModificationException
        }

    }


    // ===========================================================================================================


    private static int[] recolhePesos(String[] args, int qtdNotas) {
        int[] pesos = new int[qtdNotas];
        for (int i = 2; i < qtdNotas + 2; i++) {
            pesos[i - 2] = Integer.parseInt(args[i]);
        }
        return pesos;
    }

    private static String[] copiaArray(String[] array, int posicaoInicial) {

        String[] novoArray = new String[array.length -1];
        System.arraycopy(array, posicaoInicial, novoArray, 0, novoArray.length);
        return novoArray;

    }

}
