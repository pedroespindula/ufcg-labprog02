package lab05.util;

import lab05.identificavel.Identificavel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class StringFactory {

    public String mapToString(Map<String, Identificavel> mapaIdentificavel, String ... args) {

        ArrayList<Identificavel> arrayIdentificavel = new ArrayList<Identificavel>(mapaIdentificavel.values());
        arrayIdentificavel.sort(new Comparator<Identificavel>() {
            @Override
            public int compare(Identificavel o1, Identificavel o2) {
                return o1.compareTo(o2);
            }
        });

        String buildedString = "";

        for (Identificavel identificavel : arrayIdentificavel) {
            for (String arg : args) {
                buildedString += arg + " - ";
            }
            buildedString += identificavel.toString() + " | ";
        }
        if (buildedString.length() > 3) {
            return buildedString.substring(0, buildedString.length() - 3);
        }
        return "";
    }

}
