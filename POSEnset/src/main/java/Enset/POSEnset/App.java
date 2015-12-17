package Enset.POSEnset;

import com.models.ConfigModel;
import com.models.FConnexion;
import com.models.LangueModel;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {
       // Generate facebook instance.
    Facebook facebook = FConnexion.getInstance().getFacebook();

        try {
            // We're done.
            // Write some stuff to your wall.
            ResponseList<User> list = facebook.searchUsers("abde");
            Iterator it = list.iterator();
            while(it.hasNext()){
                System.out.println(((User)it.next()).getName());
            }

           
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
}
