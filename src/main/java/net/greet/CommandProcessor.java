package net.greet;

public class CommandProcessor {
    Greeting greeting;

    public CommandProcessor(Greeting greeting) {
        this.greeting = greeting;
    }

    public String processCommands(CommandExtractor commandProcessor) {

        if (commandProcessor.getCommand().equals("greet")) {
            if (commandProcessor.getName() == "") {
                return "Oops, you didn't enter a name!";
            }
            return greeting.greeter(commandProcessor.getName(), commandProcessor.getLanguage());
            }

        else if (commandProcessor.getCommand().equals("greeted")) {
            if(commandProcessor.getName() != ""){
                return greeting.greetedUser(commandProcessor.getName());
            }
            return greeting.greeted();
        }
        else if (commandProcessor.getCommand().equals("clear")) {
                if (commandProcessor.getName() != "") {
                    return greeting.clearUser(commandProcessor.getName());
                } else {
                    return greeting.clearAll();
                }
            }
        else {
                return "Invalid command!\n" + greeting.help();
            }
    }
}

