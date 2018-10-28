package lab05.identificavel;

public interface CRUD {

    String adiciona(Identificavel identificavel);

    String exibe(String id);

    String exibeTodos();

    void edita(String id, String nomeCampo, String valorCampo);

    void remove(String id);

}
