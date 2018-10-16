package lab04;

/**
 * Classe de inicialização e execução do Singleton MenuControleAlunos.
 *
 * @author João Pedro Santino Espíndula - 118110035
 */
public class Main {

    /**
     * Metodo Main de execução do sistema.
     *
     * @param args Argumentos passados por command line.
     */
    public static void main(String[] args) {
        MenuControleAlunos menuControleAlunos = MenuControleAlunos.getInstancia();

        menuControleAlunos.init();
    }
}
