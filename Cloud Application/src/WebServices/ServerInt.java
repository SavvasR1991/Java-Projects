/*
 * @Copyrights 2014
 * Authors : Melina Rousia
 * 			 Savvas Rostantis
 * 		     Marios Gavriil
 */

package WebServices;

import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;
import javax.jws.*;


@WebService 
@SOAPBinding (style = SOAPBinding.Style.DOCUMENT)


public interface ServerInt {
    
    @WebMethod
    public String registerUser(@WebParam(name = "register") String reg);
    @WebMethod
    public String setMonitorData(@WebParam(name = "register") String reg,@WebParam (name = "entry") String newEntry);
    @WebMethod
    public String getMapData(@WebParam(name = "register") String reg,@WebParam (name = "position") String position);
    
}