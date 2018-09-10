/*
 * @Copyrights 2014
 * Authors : Melina Rousia
 * 		     Savvas Rostantis
 * 		     Marios Gavriil
 */

package Settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private static Settings instance = null;
    private static long T;
    private static String username;
    private static String password;
    private static String database;
    private static String address;
    private static String ip;
    private static String port;
    private static int gui_refresh;
    private static long r;
    
    /*
    * Load Settings from file to memory .
    */
    
    private Settings(){
        Properties conf = new Properties();
        try(InputStream is = Settings.class.getResourceAsStream("settings.properties")){
            conf.load(is);
            T = Long.parseLong(conf.getProperty("T"));
            username = conf.getProperty("username");
            password = conf.getProperty("password");
            database = conf.getProperty("database");
            address = conf.getProperty("address");
            ip = conf.getProperty("ip");
            port = conf.getProperty("port");
            gui_refresh = Integer.parseInt(conf.getProperty("gui_refresh"));
            r =Long.parseLong(conf.getProperty("r"));
        }catch(IOException err){
            err.printStackTrace();
        }
    }
    
    /*
    *Return the instance to the settings properties
    */
    
    public static synchronized Settings getInstance() {
        if(instance == null){
            instance = new Settings();
        }
        return instance;
    }
    
    /*
    *throws CloneNotSupportedException in order to block us from creating a 
    *second instance of the Settings properties with clone
    */
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /*
    *return time that is used for statistics
    */
    
    public long  getT(){
        return T;
    }
    
    /*
    *return username for the database connection
    */
    
    public String getUsername(){
        return username;
    }
    
    /*
    *return password for the database connection
    */
    
    public String getPassword(){
        return password;
    }
    
    /*
    *return database name
    */
    
    public String getDatabase(){
        return database;
    }
    
    /*
    *return webservice address
    */
    
    public String getAddress(){
        return address;
    }
    
    /*
    *return database connection ip 
    */
    
    public String getIp(){
        return ip;
    }
    
    /*
    *return database connection port
    */
    
    public String getPort(){
        return port;
    }
    
    /*
    *return time for gui refreshment
    */
    
    public int getGui_Refresh(){
        return gui_refresh;
    }
    
    /*
     * return radius
     */
    public long getR(){
    	return r;
    }
    
    }
