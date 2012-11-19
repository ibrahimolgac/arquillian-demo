package org.sewatech.examples.arquillian.cdi;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author alexis
 */
@RunWith(Arquillian.class)
public class GreeterArqIT {

    @Deployment
    public static Archive<?> deploy() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Greeter.class, Location.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
    Greeter greeter;

    @Test
    public void testGreet() throws Exception {
        String who = "World";
        String expected = "Hi " + who;
        String actual = greeter.greet(who);

        assertEquals(expected, actual);
    }

    @Test
    public void testGreetLocated() throws Exception {
        String who = "World";
        String expected = "Hi " + who + " from Lyon";
        String actual = greeter.greetLocated(who);

        assertEquals(expected, actual);
    }

}
