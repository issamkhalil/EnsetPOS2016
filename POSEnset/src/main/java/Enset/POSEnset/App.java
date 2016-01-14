package Enset.POSEnset;

import com.entities.PaymentType;
import com.entities.Vente;
import com.metier.AccesRMI;
import com.models.ConfigModel;
import com.models.FConnexion;
import com.models.LangueModel;
import com.models.PdfFactory;
import com.views.ListVenteFrame;
import controlors.VentesControlor;
import facebook4j.Activity;
import facebook4j.CommentUpdate;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException, IOException
    {
        try {
            // Generate facebook instance.
            ListVenteFrame frame = new ListVenteFrame(null, true);
            frame.setVisible(true);
            if(frame.getList().size()!=0){
            PdfFactory.createRecu(frame.getList().get(0), new File("file.pdf"));
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IHtmlToPdfTransformer.CConvertException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
