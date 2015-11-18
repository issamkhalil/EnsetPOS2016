package Enset.POSEnset;

import com.models.ConfigModel;
import com.models.LangueModel;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ResourceBundle bundle = ResourceBundle.getBundle("langue",new Locale("fr"));  
        System.out.println(bundle.getString("greeting"));
         
    }
}
