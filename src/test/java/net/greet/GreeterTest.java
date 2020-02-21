package net.greet;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GreeterTest {

    @Test
   public void shouldGreetName(){
        Greeter greet = new Greeter();
        greet.greeter("Sino");

        assertEquals("Sino", greet.greeter("Sino"));
    }

    @Test
    public void shouldGreetUniqueUser(){
        Greeter greet = new Greeter();
        greet.greeter("Lala");
        greet.greeter("Lala");
        greet.greeter("Shasha");
        greet.greeter("Shasha");
        greet.greeter("Yala");

        assertEquals(3, greet.counter());
    }

    @Test
    public void shouldDisplayUsersGreeted(){

        Greeter greet = new Greeter();
        greet.greeter("Sino");
        greet.greeter("Lolo");
        greet.greeter("Lucy");

        assertEquals("{Sino=1, Lolo=1, Lucy=1}", greet.greeted());
    }

    @Test
    public void shouldDisplayUniqueUserGreeterCount(){
        Greeter greet = new Greeter();
        greet.greeter("Sino");
        greet.greeter("Sino");
        greet.greeter("Sino");
        greet.greeter("Lulu");
        greet.greeter("Lolo");
        greet.greeter("Lolo");

//        System.out.println("User: " + greet.greetedUser("Sino"));
        assertEquals("Lolo 2", greet.greetedUser("Lolo"));
    }

}
