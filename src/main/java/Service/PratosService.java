package Service;

import dao.PratosDAO;
import model.Pratos;

import java.util.LinkedHashSet;

public class PratosService {
    public LinkedHashSet<Pratos> getPratos(){
        return PratosDAO.getPratos();
    }

    public void Salvar(Pratos pratos){
        PratosDAO.savePratos(pratos);
    }
}
