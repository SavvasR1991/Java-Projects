/*
 * @Copyrights 2014
 * Authors : Melina Rousia
 * 		     Savvas Rostantis
 * 		     Marios Gavriil
 */

package WebServices;

import javax.jws.WebService;
import Database.Database;


@WebService(endpointInterface = "WebServices.Server")
public class Server implements ServerInt{
    @Override
    
    public String registerUser(String reg){
            int flag=0;
        String[] r = reg.split("#");
        String username = r[0];
        String password1 = r[1];
        String password2 = r[2];
        if(password1.equals(password2)){
        String posum = Database.getInstance().checkUser(username);
        if("no".equals(posum)){
        	Database.getInstance().addUser(username, password2);
        	Database.getInstance().apu(username);
            flag=0;
        }
        else{
            flag=1;
        }
        }
        else{
        	  flag=2;
                }
        if(flag==0)
            return "Your Registration was successful !";
        else if(flag==1)
            return "Your username already exists ! Please find another one and try again !";  
        else
        	return "Password mismatch ! Please verify your password !";
        
    }
     
    @Override
    
    public String getMapData (String reg, String position){
        int flag=0;
        int flag2=0;
        String[] r =reg.split("#");
        String username = r[0];
        String password = r[1];
        String[] p =position.split("#");
        String x = p[0];
        String y = p[1];
        float xaxis = Float.parseFloat(x);
        float yaxis = Float.parseFloat(y);
        String many = Database.getInstance().accessUser(username, password);
        Database.getInstance().getAdd(username,xaxis,yaxis);
        if(many.equals("no")){
            flag=0;
        }
        else if(many.equals("yes")){
            flag=1;
            many = Database.getInstance().getPoi(x,y);
            if(many.equals("no")){
                flag2=0;
            }
            else{
                flag2=1;
            }
            
        }
        if(flag==0){
            return "Error ! Please check your username and your password !";
        }
        else{
            if(flag2==1){
                return many;
            }
            else{
                return "There are no POIs near you !";
            }
        }
        
        
    }
    
    
    
    
@Override
    
    public String setMonitorData(String reg, String newEntry){
        int flag=0;
        int flag1=0;
        String[] r = reg.split("#");
        String username = r[0];
        String password = r[1];
        String[] p = newEntry.split("#");
        String name = p[0];
        String type = p[1];
        String x = p[2];
        String y = p[3];
        float xaxis = Float.parseFloat(x);
        float yaxis = Float.parseFloat(y);
        String sid = Database.getInstance().accessUser(username, password);
        Database.getInstance().setAdd(username,xaxis,yaxis);
        if(sid.equals("no")){
            flag=0;
        }
        else{
            flag=1;
            sid = Database.getInstance().checkPoi(name, type, x, y);
            if(sid.equals("no")){
                flag1=0;
            }
            else{
                flag1=1;
                Database.getInstance().addPoi(name, type, x, y);
                Database.getInstance().update(username);
            }
        }
        if(flag==1){
            if(flag1==1){
                return "Your POI has been added successfully !";
            }
            else{
                return "There was an error in adding your POI ! POI already exists !";
            }
        }
        else{
            return "Your password is wrong please try again !";
        }
    }
        
    }
    
    
