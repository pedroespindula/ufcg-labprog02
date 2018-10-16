package lab04;

import java.util.Scanner;

/**
 * Singleton que serve de interface de interação com o usuario para a classe ControleAlunos.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class MenuControleAlunos {

    /**
     * O menu principal do menu.
     */
    private final String menuPrincipal = "(C)adastrar Aluno" + System.lineSeparator() +
                                         "(E)xibir Aluno" + System.lineSeparator() +
                                         "(N)ovo Grupo" + System.lineSeparator() +
                                         "(A)locar Aluno no Grupo e Imprimir Grupos" + System.lineSeparator() +
                                         "(R)egistrar Aluno que Respondeu" + System.lineSeparator() +
                                         "(I)mprimir Alunos que Responderam" + System.lineSeparator() +
                                         "(O)ra, vamos fechar o programa!";

    /**
     * O Scanner principal do menu. É usado para receber entradas do usuário.
     */
    private final Scanner input = new Scanner(System.in);

    /**
     * O objeto ControleAlunos que será utilizado para realizar as operações do sistema.
     */
    private final ControleAlunos controleAlunos = new ControleAlunos();

    /**
     * A instancia do Singleton.
     */
    private static final MenuControleAlunos instancia = new MenuControleAlunos();

    /**
     * O construtor privado para inpedir a criação de outra instancia da classe MenuControleAlunos
     */
    private MenuControleAlunos() {}

    /**
     * Retorna a instancia do MenuControleAlunos.
     *
     * @return A instancia do MenuControleAlunos.
     */
    public static MenuControleAlunos getInstancia() {
        return instancia;
    }

    /**
     * Recolhe a opção escolhida pelo usuario. O método também mostra as opções disponiveis e
     * abre uma especie de prompt.
     *
     * @return A opção escolhida pelo usuario.
     */
    private char escolheOpcao() {
        System.out.print(this.menuPrincipal + System.lineSeparator() +
                System.lineSeparator());


        return recolheEntrada("Opção> ").toUpperCase().charAt(0);

    }


    /**
     * Recolhe a entrada do usuario imprimindo antes da entrada um identificador do que deve ser
     * digitado.
     *
     * @return A entrada do usuario.
     */
    private String recolheEntrada(String textoPreEntrada) {
        System.out.print(textoPreEntrada);

        String entrada = this.input.nextLine().trim();

        if (entrada.equals("")) {
            throw new IllegalArgumentException("Entrada inválida");
        }

        return entrada;
    }

    /**
     * O método de inicialização do MenuControleAlunos. É o metodo de execução
     * principal.
     */
    public void init() {

        char opcao;

        loop: while (true) {

            opcao = this.escolheOpcao();

            switch (opcao) {

                case 'C':
                    this.cadastrarAluno();
                    break;

                case 'E':
                    this.exibirAluno();
                    break;

                case 'N':
                    this.novoGrupo();
                    break;

                case 'A':
                    this.alocarAlunoImprimirGrupos();
                    break;

                case 'R':
                    this.registrarAlunoRespondeu();
                    break;

                case 'I':
                    this.imprimirAlunoResponderam();
                    break;

                case 'O':
                    this.input.close();
                    break loop;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;

            }

            System.out.println();

        }

    }

    /**
     * Cadastra um aluno no controleAlunos. Se o aluno já estiver registrado no sistema,
     * o metodo exibe uma mensagem informando que o aluno já está cadastrado.
     */
    private void cadastrarAluno() {
        String matricula = this.recolheEntrada("Matrícula: ");
        String nomeAluno = this.recolheEntrada("Nome: ");
        String curso = this.recolheEntrada("Curso: ");

        if (!this.controleAlunos.contemAluno(matricula)) {
            this.controleAlunos.cadastrarAluno(matricula, nomeAluno, curso);
            System.out.println("CADASTRO REALIZADO!");
        } else {
            System.out.println("MATRÍCULA JÁ CADASTRADA!");
        }

    }

    /**
     * Exibe um aluno que está registrado no controleAlunos.
     * Se o aluno não estiver registrado, o método exibe uma
     * mensagem informando que o aluno não foi encontrado.
     */
    private void exibirAluno() {
        String matricula = this.recolheEntrada("Matrícula: ");

        System.out.println();
        if (this.controleAlunos.contemAluno(matricula)) {
            Aluno aluno = this.controleAlunos.getAluno(matricula);
            System.out.println(aluno);
        } else {
            System.out.println("Aluno não cadastrado");
        }
    }

    /**
     * Cria um novo Grupo no controleAlunos. Se o grupo já existir, o metodo
     * exibe uma mensagem informando isso.
     */
    private void novoGrupo() {
        String nomeGrupo = this.recolheEntrada("Grupo: ");

        if (!this.controleAlunos.contemGrupo(nomeGrupo)) {
            this.controleAlunos.cadastrarGrupo(nomeGrupo);
            System.out.println("CADASTRO REALIZADO!");
        } else {
            System.out.println("GRUPO JÁ CADASTRADO!");
        }
    }

    /**
     * Método que é usado para dar a opção do usuário de escolher entre Alocar um aluno ou Imprimir um grupo.
     */
    private void alocarAlunoImprimirGrupos() {
        char opcao = this.recolheEntrada("(A)locar Aluno ou (I)mprimir Grupo? ").toUpperCase().charAt(0);

        switch (opcao) {
            case 'A':
                this.alocarAluno();
                break;
            case 'I':
                this.imprimirGrupo();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                break;
        }

    }

    /**
     * Aloca um aluno em um grupo do controleAlunos. Se o aluno ou grupo não estiver cadastrado, o metodo
     * exibe uma mensagem informando isso.
     */
    private void alocarAluno() {
        String matricula = this.recolheEntrada("Matrícula: ");
        String nomeGrupo = this.recolheEntrada("Grupo: ");

        if (this.controleAlunos.contemGrupo(nomeGrupo)) {
            if (this.controleAlunos.contemAluno(matricula)) {
                this.controleAlunos.alocarAluno(nomeGrupo, matricula);
                System.out.println("ALUNO ALOCADO");
            } else {
                System.out.println("Aluno não cadastrado");
            }
        } else {
            System.out.println("Grupo não cadastrado");
        }

    }

    /**
     * Imprime um grupo registrado no controleAlunos. Se o grupo não existir no controleAlunos,
     * o metodo exibe uma mensagem informando isso.
     */
    private void imprimirGrupo() {
        String nomeGrupo = this.recolheEntrada("Grupo: ");

        if (this.controleAlunos.contemGrupo(nomeGrupo)) {
            String representacaoGrupo = this.controleAlunos.getStringAlunosGrupo(nomeGrupo);
            System.out.println(representacaoGrupo);
        } else {
            System.out.println("Grupo não cadastrado.");
        }
    }

    /**
     * Registra uma resposta de um aluno no controleAlunos. Se o aluno não estiver cadastrado,
     * o método exibe uma mensagem informando isso.
     */
    private void registrarAlunoRespondeu() {
        String matricula = this.recolheEntrada("Matŕicula: ");
        
        if (this.controleAlunos.contemAluno(matricula)) {
            this.controleAlunos.cadastrarRespostaAluno(matricula);
            System.out.println("RESPOSTA REGISTRADA!");
        } else {
            System.out.println("Aluno não cadastrado.");
        }
        
    }

    /**
     * Imprime todos os alunos que responderam à uma pergunta do controleAlunos.
     */
    private void imprimirAlunoResponderam() {
        System.out.println(this.controleAlunos.getStringAlunosResponderam());
    }

}
