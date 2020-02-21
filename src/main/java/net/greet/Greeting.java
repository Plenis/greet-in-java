package net.greet;

import java.util.HashMap;

public interface Greeting {

    String greeter(String name);
    int counter();
    String greeted();

    default HashMap greetedUser() {
        return null;
    }
}
