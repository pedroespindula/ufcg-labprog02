package lab03;

import java.util.Scanner;

/**
 * Interface de menu para a classe Agenda.
 */
public class MenuAgenda {

    /**
     * A agenda a ser manipulada.
     */
    private Agenda agenda = new Agenda();

    /**
     * A string do menu principal.
     */
    final private  String menuPrincipal = "(C)adastrar Contato" + System.lineSeparator() +
                                                "(L)istar Contatos" + System.lineSeparator() +
                                                "(E)xibir Contato" + System.lineSeparator() +
                                                "(S)air";

    /**
     * A string do texto que vem antes da escolha da opção de modo.
     */
    final private  String textoPreOpcao = "Opção> ";

    /**
     * Scanner para recolher entradas do usuario.
     */
    private  Scanner input = new Scanner(System.in);

    /**
     * Recolhe a opção escolhida pelo usuario. O método também mostra as opções disponiveis e
     * abre uma especie de prompt.
     *
     * @return A opção escolhida pelo usuario.
     */
    private char escolheOpcao() {
        System.out.print(menuPrincipal + System.lineSeparator() +
                System.lineSeparator() +
                textoPreOpcao);


        String opcao = input.nextLine().trim().toUpperCase();

        if (opcao.equals("")) {
            return 'X';
        } else {
            return opcao.charAt(0);
        }

    }

    /**
     * Recolhe entrada do usuario para a execução do metodo da "cadastrarContatos" dp objeto "agenda".
     */
    private void opcaoCadastrarContatos() {
        System.out.println();

        try {

            System.out.print("Posição: ");
            int posicao = recolhePosicao();

            System.out.print("Nome: ");
            String nome = recolheNome();

            System.out.print("Sobrenome: ");
            String sobrenome = recolheSobrenome();

            System.out.print("Telefone: ");
            String telefone = recolheTelefone();

            agenda.cadastrarContato(nome, sobrenome, telefone, posicao);

            System.out.println("CADASTRO REALIZADO!");

        } catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido: " + e.getMessage());
        }
    }


    /**
     * Recolhe a posição atraves da entrada do usuário e garante a integridade do dado dessa entrada.
     * Se os dados não estiverem integros, o metodo lançará uma exceção dependendo do erro.
     *
     * @return A posição digitada pelo usuário.
     */
    private int recolhePosicao() {

        String stringPosicao = input.nextLine().trim();

        if (stringPosicao.equals("")) {
            throw new IllegalArgumentException("Posição Vazia");
        }

        int numPosicao;

        try {
            numPosicao = Integer.parseInt(stringPosicao);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Posição com letras ou maior que o suportado num inteiro.");
        }

        if (!(numPosicao >= 1 && numPosicao <= agenda.getLenght())) {
            throw new IllegalArgumentException("Posição fora dos limites da agenda.");
        }

        return numPosicao;

    }

    /**
     * Recolhe o nome atraves da entrada do usuário e garante a integridade do dado dessa entrada.
     * Se os dados não estiverem integros, o metodo lançará uma exceção dependendo do erro.
     *
     * @return O nome digitado pelo usuário.
     */
    private String recolheNome() {
        String nome = input.nextLine().trim();

        if (nome.equals("")) {
            throw new IllegalArgumentException("Nome vazio.");
        }

        return nome;
    }

    /**
     * Recolhe o sobrenome atraves da entrada do usuário e garante a integridade do dado dessa entrada.
     * Se os dados não estiverem integros, o metodo lançará uma exceção dependendo do erro.
     *
     * @return O sobrenome digitado pelo usuário.
     */
    private String recolheSobrenome() {
        String nome = input.nextLine().trim();

        if (nome.equals("")) {
            throw new IllegalArgumentException("Sobrenome vazio.");
        }

        return nome;
    }


    /**
     * Recolhe o telefone atraves da entrada do usuário e garante a integridade do dado dessa entrada.
     * Se os dados não estiverem integros, o metodo lançará uma exceção dependendo do erro.
     *
     * @return O telefone digitado pelo usuário.
     */
    private String recolheTelefone() {
        String telefone = input.nextLine().trim();

        if (telefone.equals("")) {
            throw new IllegalArgumentException("Telefone vazio.");
        }

        return telefone;
    }

    /**
     * Lista para o usuário todos os contatos da "agenda".
     */
    private void opcaoListarContatos() {
        System.out.println(System.lineSeparator() + this.agenda);
    }

    /**
     * Exibe um contato específico para o usuário.
     */
    private void opcaoExibirContato() {
        System.out.print("Contato> ");
        try {
            int posicaoContato = recolhePosicao();

            Contato contato = this.agenda.acharContato(posicaoContato);

            if (contato == null) {
                System.out.println("Contato inexistente.");
            } else {
                System.out.println(contato);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido: " + e.getMessage());
        }
    }

    /**
     * Fecha o input.
     */
    private void opcaoSair() {
        input.close();
        System.out.println("Até mais!");
    }

    /**
     * Permite a interação do usuário com o objeto menu atráves da escolha de uma opção de modo.
     * O metodo finalizará quando a opção selecionada for "S" (Sair).
     */
    public void init() {

        char opcao;

        loop: while (true) {

            opcao = this.escolheOpcao();

            switch (opcao) {

                case 'C':
                    this.opcaoCadastrarContatos();
                    break;

                case 'L':
                    this.opcaoListarContatos();
                    break;

                case 'E':
                    this.opcaoExibirContato();
                    break;

                case 'S':
                    this.opcaoSair();
                    break loop;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;

            }

            System.out.println();

        }

    }

}
