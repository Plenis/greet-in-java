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

            command = input[0];

            if(command.equals("exit")) {
                exit = false;
                System.out.println("Goodbye");
                return;
            }

            if(command.equals("greet")) {
                try {
                    System.out.println(greet.greeter(input[1], input[2]));
                }catch (Exception e) {
                    System.out.println("missing required commands");
                }
            }

            if(command.equals("greeted")) {
                if(input.length > 1) {
                    System.out.println(greet.greetedUser(input[1]));
                } else {
                    System.out.println(greet.greeted());
                }
            }

            if(command.equals("clear")){
                if(input.length > 1){
                    System.out.println(greet.clearUser(input[1]));
                }else {
                    System.out.println(greet.clearAll());
                }
            }
          }

        }
    }


