package net.greet;

import java.util.Scanner;

public class Greet{
    static String command;
    static String name;
    static String language;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("========= WELCOME TO THE GREET CONSOLE ========");
        System.out.print("Enter a command: ");
        command = scanner.nextLine();

        String [] input = command.split(" ");

        command = input[0];

    if (input.length >= 2) {
        name = input[1];
    } else {
        name = "";
    }

    if (input.length >= 3) {
        language = input[2];
    } else {
        language = "English";
    }

    Greeter greet = new Greeter();
    String greetUser = greet.greeter(name, language);

    if (command.equals("greet")) {
        System.out.println(greetUser);

    }
//    else {
//        String greeted = greet.greeted();
//        if (command.equals("greeted")) {
//            System.out.println(greeted);
//        }
//    }


    }
}

