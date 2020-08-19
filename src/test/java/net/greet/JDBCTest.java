package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JDBCTest{

    @BeforeEach
    void clearDB(){
        JDBC jdbc = new JDBC();
        CommandExtractor command = new CommandExtractor("clear");
        CommandProcessor commandProcessor = new CommandProcessor(jdbc);

        commandProcessor.processCommands(command);
    }

    @Test
    void shouldGreetUser(){
        JDBC greet = new JDBC();
        assertEquals("Hello, Sino", greet.greeter("Sino", "English"));
    }

    @Test
    void shouldShowGreetedUsers(){
        JDBC greet = new JDBC();
        greet.greeter("Sino", "IsiXhosa");
        greet.greeter("Lala", "English");

        assertEquals("{Sino=1, Lala=1}", greet.greeted());
    }

    @Test
    void shouldShowGreetedUser(){
        JDBC greet = new JDBC();
        greet.greeter("Sino", "English");
        greet.greeter("Sino", "English");
        greet.greeter("Aya", "Afrikaans");
        greet.greeter("Aya", "IsiXhosa");
        greet.greeter("Lala", "IsiXhosa");
        greet.greeter("Aya", "English");

        assertEquals("Aya has been greeted 3 time(s)", greet.greetedUser("Aya"));
    }

}