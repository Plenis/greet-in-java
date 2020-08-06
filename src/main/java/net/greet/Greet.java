package net.greet;

import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("========= WELCOME TO THE GREET CONSOLE ========");
//        Greeter greet = new Greeter();
        Greeting greet = new JDBC();
        CommandProcessor commandProcessor = new CommandProcessor(greet);

        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();
            CommandExtractor commandExtractor = new CommandExtractor(input);

            if (commandExtractor.getCommand().equals("exit")) {
                System.out.println("======= THANK YOU FOR USING THE GREET CONSOLE =======");
                break;
            } else {
                System.out.println(commandProcessor.processCommands(commandExtractor));
            }
        }
    }
}


