package controlors;

import com.entities.CompteUtilisateur;
import com.metier.AccesRMI;

import java.util.ArrayList;
import java.util.List;

public class ComptesControlor extends SuperControlor{
	
	

    public static List<CompteUtilisateur> fetchComptes() {
    		try {
				return accesRMI.listerComptesUtilisateurs();
			} catch (Exception e) {
				return new ArrayList<CompteUtilisateur>();
			}
    }

    public static void saveCompte(String txtLogin, String txtPass, String txtNom, String txtPrenom, String txtMail, String txtTele, String type) throws Exception {
    	CompteUtilisateur cu = new CompteUtilisateur(txtNom, txtPrenom, txtTele, txtMail, txtLogin, txtPass, type);
			accesRMI.AddCompteUtilisateur(cu);
    }

    public static void updateCompte(CompteUtilisateur compteSelec, String text, String text0, String text1, String text2, String text3, String text4, String type) throws Exception {
    	compteSelec.setLogin(text);
    	compteSelec.setPassword(text0);
    	compteSelec.setNom(text1);
    	compteSelec.setPrenom(text2);
    	compteSelec.setEmail(text3);
    	compteSelec.setTelephone(text4);
    	compteSelec.setType(type);
    	accesRMI.modifierCompteUtilisateur(compteSelec);
    	}

    public static void deleteCompte(CompteUtilisateur compteSelec) {
    		try {
				accesRMI.removeClient(compteSelec.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

    public static boolean checkUser(String text, String text0) {
    		try {
				return accesRMI.authentification(text, text0);
			} catch (Exception e) {
				e.printStackTrace();
				return  false;
			}
    	}

}
