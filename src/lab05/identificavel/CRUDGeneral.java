package lab05.identificavel;

import lab05.util.StringFactory;

import java.util.Map;
import java.util.TreeMap;

public class CRUDGeneral implements CRUD {

    protected Map<String, Identificavel> mapaIdentificavel;
    protected StringFactory stringFactory;

    public CRUDGeneral() {
        this.mapaIdentificavel = new TreeMap<>();
        this.stringFactory = new StringFactory();
    }

    public String adiciona(Identificavel identificavel) {
        this.mapaIdentificavel.put(identificavel.getId(), identificavel);
        return identificavel.getId();
    }

    public String exibe(String id) {
        return this.mapaIdentificavel.get(id).toString();
    }

    public String exibeTodos() {
        return this.stringFactory.mapToString(this.mapaIdentificavel);
    }

    public void edita(String id, String atributo, String novoValor) {
        Identificavel identificavel = this.mapaIdentificavel.get(id);
        identificavel.setAtributo(atributo, novoValor);
    }

    public void remove(String id) {
        this.mapaIdentificavel.remove(id);
    }

    public boolean contains(String id) {
        return this.mapaIdentificavel.containsKey(id);
    }


}
