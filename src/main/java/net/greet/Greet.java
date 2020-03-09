package net.greet;

import java.util.Scanner;

public class Greet{
    static String command;
    static String name;
    static String language;
    static int counter = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("========= WELCOME TO THE GREET CONSOLE ========");


        boolean exit = true;

        while (exit) {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();

            String[] input = command.split(" ");

            command = input[0];

            if(command.equals("exit")) {
                exit = false;
                System.out.println("Goodbye");
                return;
            }

            if (input.length >= 2) {
                name = input[1];
            } else {
                name = "";
                counter ++;
            }

            if (input.length >= 3) {
                language = input[2];
            } else {
                language = "English";
            }

            Greeter greet = new Greeter();
            String greetUser = greet.greeter(name, language);
            String greetedUser = greet.greetedUser(name);
            String greeted = greet.greeted();

            if (command.equals("greet")) {
                System.out.println(greetUser);
            }
                if (command.equals("greeted")) {

                       System.out.println(greeted);
                   }
                else if(command.equals("greeted" + name)){
                    System.out.println(greetedUser);
                }
               }

        }
    }


