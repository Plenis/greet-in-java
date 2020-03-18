package net.greet;

import java.util.Scanner;

public class Greet{
    static String command;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("========= WELCOME TO THE GREET CONSOLE ========");
        Greeter greet = new Greeter();

        boolean exit = true;

        while (exit) {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();

            String[] input = command.split(" ");

            command = input[0].toLowerCase();

            if (command.equals("exit")) {
                exit = false;
                System.out.println("Goodbye");
                return;
            }

            if(command.equals("greet")) {
                String nameOutput = input[1].substring(0, 1).toUpperCase() + input[1].substring(1);
                try {
                    System.out.println(
                            greet.greeter(nameOutput, input[2])
                    );
                } catch (Exception e) {
                    System.out.println(greet.greeter(nameOutput, "IsiXhosa"));
                }
            }


                if (command.equals("greeted")) {
                    if (input.length > 1) {
                        System.out.println(greet.greetedUser(input[1]));
                    } else {
                        System.out.println(greet.greeted());
                    }
                    if(greet.greeted().equals("{}")){
                        System.out.println("--------------------------\nNo users greeted!\nPlease greet a user :)\n-------------------------");
                    }
                }

                if (command.equals("clear")) {
                    if (input.length > 1) {
                        System.out.println(greet.clearUser(input[1]));
                    } else {
                        System.out.println(greet.clearAll());
                    }
                }

                if(command.equals("help")){
                    System.out.println(greet.help());
                }
        }
    }
}


