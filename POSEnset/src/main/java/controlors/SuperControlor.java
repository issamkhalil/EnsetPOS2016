package controlors;

import java.rmi.Naming;

import com.metier.IAccesRMI;
import com.views.Main;

public class SuperControlor {
	protected static Main mainForm;
	
	protected static IAccesRMI accesRMI;

	static {
		try {
			accesRMI =(IAccesRMI) Naming.lookup("rmi://localhost:1099/accRMI");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}

	public static void setMainForm(Main mainForm) {
		SuperControlor.mainForm = mainForm;
	}
	public static Main getMainForm() {
		return mainForm;
	}
}
