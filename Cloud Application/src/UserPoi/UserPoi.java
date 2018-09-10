/*
 * @Copyrights 2014
 * Authors : Melina Rousia
 * 		     Savvas Rostantis
 * 		     Marios Gavriil
 */

package UserPoi;


import Settings.Settings;
import WebServices.Server;
import javax.xml.ws.Endpoint;
import gui.Gui;


public class UserPoi {

    public static void main(String[] args) {
         Endpoint.publish(Settings.getInstance().getAddress(), new Server());
         Gui goo = new Gui();
         goo.jframe.setVisible(true);
    }
    
}