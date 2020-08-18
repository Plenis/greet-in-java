package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @Test
    void shouldGetName(){
        CommandExtractor commandExtractor = new CommandExtractor("greet sino IsiXhosa");
        assertEquals("Sino", commandExtractor.getName());
    }

    @Test
    void shouldGetCommandGreet(){
        CommandExtractor commandExtractor = new CommandExtractor("greet sino Afrikaans");
        assertEquals("greet", commandExtractor.getCommand());
    }

    @Test
    void shouldGetCommandClear(){
        CommandExtractor commandExtractor = new CommandExtractor("clear sino");
        assertEquals("clear", commandExtractor.getCommand());
    }

    @Test
    void shouldGetCommandGreeted(){
        CommandExtractor commandExtractor = new CommandExtractor("greeted sino");
        assertEquals("greeted", commandExtractor.getCommand());
    }

    @Test
    void shouldGetLanguageEnglish(){
        CommandExtractor commandExtractor = new CommandExtractor("greet Sino English");
        assertEquals("English", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetLanguageAfrikaans(){
        CommandExtractor commandExtractor = new CommandExtractor("greet Sino Afrikaans");
        assertEquals("Afrikaans", commandExtractor.getLanguage());
    }

    @Test
    void shouldGetLanguageIsiXhosa(){
        CommandExtractor commandExtractor = new CommandExtractor("greet Sino IsiXhosa");
        assertEquals("IsiXhosa", commandExtractor.getLanguage());
    }

}