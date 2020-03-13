
package net.greet;

import java.util.HashMap;

public class Greeter implements Greeting{
    private HashMap<String, Integer> userName = new HashMap<String, Integer>();

    public String greeter(String name, String language){
        if(userName.containsKey(name)){
            userName.put(name, userName.get(name) + 1);
        } else {
            userName.put(name, 1);
        }
        try {
            return Language.valueOf(language).getMyLanguage() + name.charAt(0) + name.substring(1) + "!";
        }catch (Exception e){
            return Language.valueOf("IsiXhosa").getMyLanguage() + name.charAt(0) + name.substring(1) + "!";
        }
    }

    public int counter(){
        return userName.size();
    }

    public String greeted(){
        return userName.toString();
    }

    public String greetedUser(String uniqueUser){
      int counter = 0;

        if(userName.isEmpty()){
            System.out.println("This name is not available");
        }

        else if(userName.containsKey(uniqueUser)) {
           counter = userName.get(uniqueUser);
        }
        return uniqueUser + " has been greeted " + counter + " time(s)";
    }

    public String clearUser(String user){
        if(userName.containsKey(user)) {
            userName.remove(user);
        }
        return "User: " + user + " has been cleared!";
    }

    public String clearAll(){
        userName.clear();
        return null;
    }

    public String help(){
        return  "----------------------------------------------------------------------\n"+
                "Here is some information on how to use the greet-in-java on the console\n"+
                "----------------------------------------------------------------------\n\n"+
                       "COMMANDS:\n 'greet' - followed by a name and language => to greet user \n " +
                        "'greeted' => to check all greeted users \n "+
                        "'greeted' - followed by a name => to check specific greeted user \n "+
                        "'clear' => clears all the greeted users \n "+
                        "'clear' - followed by a name => clears specified user \n "+
                        "'exit' => exit the greeter command line\n " +
                        "'help' => overview of possible commands\n\n" +
                        "LANGUAGES AVAILABLE:\n" +
                        "'English', 'IsiXhosa', 'Afrikaans', 'Sesotho'\n\n"+
                        "DEFAULT LANGUAGE:\n " +
                        "'IsiXhosa'\n\n" +
                "Go ahead and try a command below :)\n" +
                "----------------------------------------------------------------------\n";
    }
}
