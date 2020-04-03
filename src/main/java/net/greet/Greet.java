package net.greet;

import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("========= WELCOME TO THE GREET CONSOLE ========");
        Greeter greet = new Greeter();
        CommandProcessor commandExtractor = new CommandProcessor(greet);

        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();
            CommandExtractor commandProcessor = new CommandExtractor(input);

            if (commandProcessor.getCommand().equals("exit")) {
                break;
            } else {
                System.out.println(commandExtractor.processCommands(commandProcessor));
            }
        }
    }
}


