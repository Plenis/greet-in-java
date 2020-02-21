
package net.greet;

import java.util.HashMap;

public class Greeter implements Greeting{
    private HashMap<String, Integer> userName = new HashMap<>();

    public String greeter(String name){

        if(userName.containsKey(name)){
            userName.put(name, userName.get(name) + 1);

        } else {
            userName.put(name, 1);
        }
        return name;
    }

    public int counter(){
        return userName.size();
    }

    public String greeted(){
        return String.valueOf(userName);
    }


    public String greetedUser(String uniqueUser){
       int counter = 0;

        if(userName.containsKey(uniqueUser)) {
           counter = userName.get(uniqueUser);
        }

        System.out.println(userName.get("Sino"));
        return uniqueUser +" " + counter;
    }
}
