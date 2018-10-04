package lab02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Representação de um aluno, mais especialmente da UFCG, com coleções de contas de laboratório,
 * contas de cantina, disciplinas e uma representação de saúde.
 *
 */
public class Aluno {

    /**
     * Coleção de contas de laboratório onde os objetos ContaLaboratorio são identificados a partir
     * de uma String.
     */
    private Map<String, ContaLaboratorio> contasLaboratorio = new HashMap<>();

    /**
     * Coleção de contas de cantina onde os objetos ContaCantina são identificados a partir
     * de uma String.
     */
    private Map<String, ContaCantina> contasCantina = new HashMap<>();

    /**
     * Coleção de disciplinas onde os objetos Disciplina são identificados a partir
     * de uma String.
     */
    private Map<String, Disciplina> disciplinas = new HashMap<>();

    /**
     * Saúde do aluno.
     */
    private Saude saude = new Saude();

    /**
     * Número de identificação do aluno.
     */
    private int id;

    /**
     * Nome do aluno.
     */
    private String nomeAluno;

    /**
     * Constroi um aluno a partir de um número de identificação e de um nomeAluno.
     *
     * @param id o número de identificação.
     * @param nomeAluno o nomeAluno do aluno.
     */
    public Aluno(int id, String nomeAluno) {
        this.id = id;
        this.nomeAluno = nomeAluno;
    }

    /**
     * Retorna o número de identificação.
     *
     * @return o número de identificação.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nomeAluno do aluno.
     *
     * @return o nomeAluno do aluno.
     */
    public String getNomeAluno() {
        return nomeAluno;
    }

    // CANTINAS

    /**
     * Cadastra uma nova conta de cantina para o aluno.
     *
     * @param nomeCantina o nomeAluno da cantina.
     */
    public void cadastraCantina(String nomeCantina) {
        ContaCantina novaConta = new ContaCantina(nomeCantina);
        this.contasCantina.put(nomeCantina, novaConta);
    }

    /**
     * Cadastra um lanche na conta de cantina correspondente.
     *
     * @param nomeCantina o nomeAluno da cantina.
     * @param qtdItens a quantidade de itens.
     * @param valorCentavos o valor do lanche em centavos.
     */
    public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
        ContaCantina contaCantina = this.contasCantina.get(nomeCantina);
        contaCantina.cadastraLanche(qtdItens, valorCentavos);
    }

    /**
     * Cadastra um lanche na conta de cantina correspondente com detalhes sobre este lanche.
     *
     * @param nomeCantina o nomeAluno da cantina.
     * @param qtdItens a quantidade de itens.
     * @param valorCentavos o valor do lanche em centavos.
     * @param detalhes os detalhes do lanche.
     */
    public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos, String detalhes) {
        ContaCantina contaCantina = this.contasCantina.get(nomeCantina);
        contaCantina.cadastraLanche(qtdItens, valorCentavos, detalhes);
    }

    /**
     * Paga um valor em centavos do que se deve a cantina.
     *
     * @param nomeCantina o nomeAluno da cantina.
     * @param valorCentavos o valor pago em centavos.
     */
    public void pagarConta(String nomeCantina, int valorCentavos) {
        ContaCantina contaCantina = this.contasCantina.get(nomeCantina);
        contaCantina.pagaConta(valorCentavos);
    }

    /**
     * Retorna quanto o aluno tem de debito naquela cantina a partir do nomeAluno dela.
     *
     * @param nomeCantina o nomeAluno da cantina.
     * @return o valor que está se devendo.
     */
    public int getFaltaPagar(String nomeCantina) {
        ContaCantina contaCantina = this.contasCantina.get(nomeCantina);
        return contaCantina.getFaltaPagar();
    }

    /**
     * Lista os ultimos cinco detalhes dos lanches de uma conta de cantina.
     *
     * @param nomeCantina o nomeAluno da cantina.
     */
    public void listarDetalhes(String nomeCantina) {
        ContaCantina contaCantina = this.contasCantina.get(nomeCantina);
        contaCantina.listarDetalhes();
    }

    /**
     * Retorna a representação de uma conta de cantina a partir do seu nomeAluno.
     *
     * @param nomeCantina o nomeAluno da cantina.
     * @return a representação da conta de cantina.
     */
    public String cantinaToString(String nomeCantina) {
        ContaCantina contaCantina = this.contasCantina.get(nomeCantina);
        return contaCantina.toString();
    }

    /**
     * Remove uma conta de cantina do aluno.
     *
     * @param nomeCantina o nomeAluno da cantina.
     */
    public void removeCantina(String nomeCantina) {
        this.contasLaboratorio.remove(nomeCantina);
    }


    // DISCIPLINAS

    /**
     * Cadastra uma nova disciplina para o aluno a partir do nomeAluno da disciplina.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     */
    public void cadastraDisciplina(String nomeDisciplina) {
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina);
        this.disciplinas.put(nomeDisciplina, novaDisciplina);
    }

    /**
     * Cadastra uma nova disciplina para o aluno a partir do nomeAluno da disciplina e
     * da quantidade de notas.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     * @param qtdNotas a quantidade de notas.
     */
    public void cadastraDisciplina(String nomeDisciplina, int qtdNotas) {
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, qtdNotas);
        this.disciplinas.put(nomeDisciplina, novaDisciplina);
    }

    /**
     * Cadastra uma nova disciplina para o aluno a partir do nomeAluno da disciplina, da quantidade
     * de notas e dos pesos das notas.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     * @param qtdNotas a quantidade de notas.
     * @param pesosNotas os pesos das notas.
     */
    public void cadastraDisciplina(String nomeDisciplina, int qtdNotas, int[] pesosNotas) {
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, qtdNotas, pesosNotas);
        this.disciplinas.put(nomeDisciplina, novaDisciplina);
    }

    /**
     * Cadastra horas para uma disciplina.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     * @param horas a quantidade de horas.
     */
    public void cadastraHoras(String nomeDisciplina, int horas) {
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, horas);
        this.disciplinas.put(nomeDisciplina, novaDisciplina);
    }

    /**
     * Cadastra uma nota em uma disciplina.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     * @param nota a nota a ser cadastrada.
     * @param valorNota o valor da nota.
     */
    public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
        Disciplina disciplina = this.disciplinas.get(nomeDisciplina);
        disciplina.cadastraNota(nota, valorNota);
    }

    /**
     * Retorna se o aluno está aprovado ou não na disciplina a partir do nomeAluno da disciplina.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     * @return o estado de aprovação da disciplina.
     */
    public boolean aprovado(String nomeDisciplina) {
        Disciplina disciplina = this.disciplinas.get(nomeDisciplina);
        return disciplina.aprovado();
    }

    /**
     * Retorna a representação de uma disciplina a partir do seu nomeAluno.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     * @return a representação da disciplina.
     */
    public String disciplinaToString(String nomeDisciplina) {
        Disciplina disciplina = this.disciplinas.get(nomeDisciplina);
        return disciplina.toString();
    }

    /**
     * Remove uma disciplina de um aluno a partir do nomeAluno da disciplina.
     *
     * @param nomeDisciplina o nomeAluno da disciplina.
     */
    public void removeDisciplina(String nomeDisciplina) {
        this.contasLaboratorio.remove(nomeDisciplina);
    }


    // LABORATÓRIOS

    /**
     * Cadastra um laboratório a partir do nomeAluno do laboratório.
     *
     * @param nomeLaboratorio o nomeAluno do laboratório.
     */
    public void cadastraLaboratorio(String nomeLaboratorio) {
        ContaLaboratorio novaConta = new ContaLaboratorio(nomeLaboratorio);
        this.contasLaboratorio.put(nomeLaboratorio, novaConta);
    }

    /**
     * Cadastra um laboratório a partir do nomeAluno do laboratório e da cota dele.
     *
     * @param nomeLaboratorio o nomeAluno do laboratório.
     * @param cota a cota do laboratório.
     */
    public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
        ContaLaboratorio novaConta = new ContaLaboratorio(nomeLaboratorio, cota);
        this.contasLaboratorio.put(nomeLaboratorio, novaConta);
    }

    /**
     * Consome o espaço de um laboratório a partir do seu nomeAluno.
     *
     * @param nomeLaboratorio o nomeAluno do laboratório.
     * @param mbytes a quantidade consumida em mbytes.
     */
    public void consomeEspaco(String nomeLaboratorio, int mbytes) {
        ContaLaboratorio laboratorio = this.contasLaboratorio.get(nomeLaboratorio);
        laboratorio.consomeEspaco(mbytes);
    }

    /**
     * Libera o espaço de um laboratório a partir do seu nomeAluno.
     *
     * @param nomeLaboratorio o nomeAluno do laboratório.
     * @param mbytes a quantidade liberada em mbytes.
     */
    public void liberaEspaco(String nomeLaboratorio, int mbytes) {
        ContaLaboratorio laboratorio = this.contasLaboratorio.get(nomeLaboratorio);
        laboratorio.liberaEspaco(mbytes);
    }

    /**
     * Retorna se o aluno atingiu a cota de um laboratório a partir do seu nomeAluno.
     *
     * @param nomeLaboratorio o nomeAluno do laboratório.
     * @return se o aluno atingiu a cota.
     */
    public boolean atingiuCota(String nomeLaboratorio) {
        ContaLaboratorio laboratorio = this.contasLaboratorio.get(nomeLaboratorio);
        return laboratorio.atingiuCota();
    }

    /**
     * Retorna a representação de um laboratório a partir do nomeAluno do laboratório.
     *
     * @param nomeLaboratorio o nomeAluno do laboratório.
     * @return a representação do laboratório.
     */
    public String laboratorioToString(String nomeLaboratorio) {
        ContaLaboratorio laboratorio = this.contasLaboratorio.get(nomeLaboratorio);
        return laboratorio.toString();
    }

    /**
     * Remove uma conta de laboratório de um aluno a partir do nomeAluno do laboratório.
     *
     * @param nomeLaboratorio o nomeAluno do laboratório.
     */
    public void removeLaboratorio(String nomeLaboratorio) {
        this.contasLaboratorio.remove(nomeLaboratorio);
    }


    // SAUDE

    /**
     * Define a saúde mental do aluno.
     *
     * @param valor o valor da saúde mental.
     */
    public void defineSaudeMental(String valor) {
        this.saude.defineSaudeMental(valor);
    }

    /**
     * Define a saúde física do aluno.
     *
     * @param valor o valor da saúde física.
     */
    public void defineSaudeFisica(String valor) {
        this.saude.defineSaudeFisica(valor);
    }

    /**
     * Define o emoji que representa o humor do aluno.
     *
     * @param valor o emoji.
     */
    public void definirEmoji(String valor) {
        this.saude.definirEmoji(valor);
    }

    /**
     * Retorna o status geral do aluno. O status geral segue os seguintes aspectos:
     *
     * 1. BOA: Se ambas as saúdes (Mental e física) forem boas.
     * 2. OK: Se as saúdes (Mental e física) forem diferentes.
     * 3. RUIM: Se ambas as saúdes (Mental e física) forem ruins.
     *
     * E se houver emoji registrado, ele adiciona esse emoji ao status.
     *
     * @return o status geral do aluno.
     */
    public String getStatusGeral() {
        return this.saude.getStatusGeral();
    }


    // ALUNO

    /**
     * Retorna a representação de um mapa.
     *
     * @param mapa o mapa.
     * @return a representação do mapa.
     */
    private String getMapString(Map mapa) {
        StringBuilder criadorString = new StringBuilder(100);
        Iterator iterador = mapa.entrySet().iterator();

        while (iterador.hasNext()) {
            Map.Entry par = (Map.Entry) iterador.next();
            criadorString.append(par.getKey().toString());
            criadorString.append(": ");
            criadorString.append(par.getValue().toString());
            criadorString.append(System.lineSeparator());
            iterador.remove(); // avoids a ConcurrentModificationException
        }

        return criadorString.toString();
    }

    /**
     * Retorna a representação do aluno com as contas de laboratório, as contas de cantina,
     * as disciplinas, a saúde, id do aluno e o nomeAluno do aluno.
     *
     * @return a representação do aluno.
     */
    @Override
    public String toString() {
        String stringRetorno = "";

        stringRetorno += this.getId() + " - " + this.getNomeAluno();
        stringRetorno += System.lineSeparator();

        stringRetorno += "- DISCIPLINAS: ";
        stringRetorno += System.lineSeparator();
        stringRetorno += getMapString(disciplinas);
        stringRetorno += System.lineSeparator();

        stringRetorno += "- LABORATORIOS: ";
        stringRetorno += System.lineSeparator();
        stringRetorno += getMapString(contasLaboratorio);
        stringRetorno += System.lineSeparator();

        stringRetorno += "- CANTINAS: ";
        stringRetorno += System.lineSeparator();
        stringRetorno += getMapString(contasCantina);
        stringRetorno += System.lineSeparator();

        stringRetorno += "- SAÚDE: ";
        stringRetorno += getStatusGeral();

        return stringRetorno;

    }


}
