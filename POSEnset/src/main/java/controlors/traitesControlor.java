package controlors;

import com.entities.Tranche;
import com.entities.Vente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class traitesControlor extends SuperControlor {

    public static List<Tranche> fetchTranches(Vente vente) throws Exception {
        List<Tranche> tranches = accesRMI.getVentebyId(vente.getId()).getTranches();
        return tranches;
    }
    /**
     * fonction qui valider une tranche
     * @param tranche
     * @throws Exception il faut ecrire les message d'erreur en francais clear
     */
    public static void validerTranche(Tranche tranche) throws Exception{
        tranche.setPaye(true);
        accesRMI.modifierTranche(tranche);
    }

}
