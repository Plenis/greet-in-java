package net.greet;


public interface Greeting {

    String greeter(String name, String language);
    int counter();
    String greeted();
    String greetedUser(String uniqueUser);
    String clearAll();
}
