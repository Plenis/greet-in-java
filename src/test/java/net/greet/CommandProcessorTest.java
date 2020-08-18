package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

    @Test
    void shouldGreetUser(){
        Greeting greet = new JDBC();
        CommandExtractor command = new CommandExtractor("greet sino IsiXhosa");
        CommandProcessor commandProcessor = new CommandProcessor(greet);

        assertEquals("Molo, Sino", commandProcessor.processCommands(command));
    }


    @Test
    void shouldClearUser(){
        Greeting greet = new JDBC();
        new CommandExtractor("greet sino");
        new CommandExtractor("greet sino");

        CommandExtractor command = new CommandExtractor("clear Sino");
        CommandProcessor commandProcessor = new CommandProcessor(greet);

        assertEquals("Sino has been cleared!", commandProcessor.processCommands(command));


    }
}