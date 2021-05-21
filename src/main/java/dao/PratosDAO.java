package dao;

import Utils.Utils;
import model.Pratos;

import java.util.LinkedHashSet;

public class PratosDAO {

    private static LinkedHashSet<Pratos> pratos = new LinkedHashSet<Pratos>();

    static {
        pratos.add(new Pratos(Utils.PRIMEIRO_PRATO, Utils.TIPO_PRATO));
    }

    public static LinkedHashSet<Pratos> getPratos(){
        return pratos;
    }

    public static void savePratos(Pratos prato){
        pratos.add(prato);
    }
}
