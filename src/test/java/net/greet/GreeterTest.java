package net.greet;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTest {

    @Test
   public void shouldGreetName(){
        Greeter greet = new Greeter();

        assertEquals("Hello, Lucy!", greet.greeter("Lucy", "English"));
    }

    @Test
    public void shouldGreetUniqueUser(){
        Greeter greet = new Greeter();
        greet.greeter("Lala", "Afrikaans");
        greet.greeter("Lala", "English");
        greet.greeter("Shasha", "IsiXhosa");
        greet.greeter("Shasha", "Afrikaans");
        greet.greeter("Yala", "IsiXhosa");
        greet.greeter("Yamkela", "Setswana");

        assertEquals(4, greet.counter());
        assertEquals("Lala has been greeted 2 time(s)", greet.greetedUser("Lala"));
        assertEquals("Gooi dag, Lala!", greet.greeter("Lala", "Afrikaans"));
        assertEquals("Dumela, Yamkela!", greet.greeter("Yamkela",  "Setswana"));
    }

    @Test
    public void shouldDisplayUsersGreeted(){

        Greeter greet = new Greeter();
        greet.greeter("Sino", "English");
        greet.greeter("Lolo", "IsiXhosa");
        greet.greeter("Lucy", "IsiXhosa");

        assertEquals("{Sino=1, Lolo=1, Lucy=1}", greet.greeted());
    }

    @Test
    public void shouldDisplayUniqueUserGreeterCount(){
        Greeter greet = new Greeter();
        greet.greeter("Sino", "English");
        greet.greeter("Sino", "Afrikaans");
        greet.greeter("Sino", "IsiXhosa");
        greet.greeter("Lulu", "IsiXhosa");
        greet.greeter("Lolo", "English");
        greet.greeter("Lolo", "Afrikaans");
        greet.greeter("Lucy", "IsiXhosa");

        assertEquals("Sino has been greeted 3 time(s)", greet.greetedUser("Sino"));
        assertEquals("Lolo has been greeted 2 time(s)", greet.greetedUser("Lolo"));
    }



    @Test
    public void shouldClear() {
        Greeter greet = new Greeter();
        greet.greeter("Sino", "English");
        greet.greeter("Lala", "Afrikaans");
        greet.clearAll();

        assertEquals("{}", greet.greeted());
    }

    @Test
    public void shouldClearUser(){
        Greeter greet = new Greeter();
        greet.greeter("Sino", "English");
        greet.greeter("Sino", "Afrikaans");
        greet.greeter("Andy", "IsiXhosa");
        greet.greeter("Andiswa", "English");
        greet.greeter("Andiswa", "English");
        greet.clearUser("Sino");

        assertEquals("{Andiswa=2, Andy=1}", greet.greeted());
    }
}
