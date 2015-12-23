package controlors;

import com.views.Main;

public class SuperControlor {
	protected static Main mainForm;

	public static void setMainForm(Main mainForm) {
		SuperControlor.mainForm = mainForm;
	}
	public static Main getMainForm() {
		return mainForm;
	}
}
