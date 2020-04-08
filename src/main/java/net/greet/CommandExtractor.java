package net.greet;

public class CommandExtractor {
    String command;
    String name;
    String language;

    public CommandExtractor(String commands){
        String [] input = commands.split(" ");
//        String nameOutput = input[1].substring(0, 1).toUpperCase() + input[1].substring(1);

        this.command = input[0].toLowerCase();

        if(input.length >= 2){
            this.name = input[1].substring(0, 1).toUpperCase() + input[1].substring(1);
        }else{
            this.name = "";
        }

        if(input.length >= 3){
            this.language = input[2];
        }
    }

    public String getName(){
        return name;
    }

    public String getLanguage(){
        return language;
    }

    public String getCommand(){
        return command;
    }
}
