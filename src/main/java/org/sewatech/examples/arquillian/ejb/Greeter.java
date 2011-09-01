package org.sewatech.examples.arquillian.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/** 
 * Small example of EJB 3.1
 * 
 * @author Alexis Hassler
 */
@Stateless()
public class Greeter {
    
    @EJB
    Location location;
    
    public String greet(String name) {
        return "Hello " + name;
    }

    public String greetLocated(String name) {
        return "Hello " + name + " from " + location.from();
    }
}
