package controlors;

import com.entities.Tranche;
import com.entities.Vente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class traitesControlor {

    public static List<Tranche> fetchTranches(Vente vente) {
        List<Tranche> list = new ArrayList<Tranche>();
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), false, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), false, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), false, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        list.add(new Tranche(1000, new Date(), true, vente));
        return list;
    }
    /**
     * fonction qui valider une tranche
     * @param tranche
     * @throws Exception il faut ecrire les message d'erreur en francais clear
     */
    public static void validerTranche(Tranche tranche) throws Exception{
        tranche.setPaye(true);
    }

}
