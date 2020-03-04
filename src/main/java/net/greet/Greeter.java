
package net.greet;

import java.util.HashMap;

public class Greeter implements Greeting{
    private HashMap<String, Integer> userName = new HashMap<>();

    public String greeter(String name, String language){

    //.containsKey() checks if the name added is not on the Map
    //.put() puts the name added into the Map if it does not exist; adds one greet to the new name

        if(userName.containsKey(name)){
            userName.put(name, userName.get(name) + 1);

        } else {
            userName.put(name, 1);
        }
        return Language.valueOf(language).getMyLanguage() + name;
    }

    public int counter(){
        return userName.size();
    }

    public String greeted(){
        return String.valueOf(userName);
    }

    public String greetedUser(String uniqueUser){
       int counter = 0;

    // .containsKey() checks the userNames for duplicates.
    // .get() gets the value of each key/counter 'String'/userName greeted

        if(userName.containsKey(uniqueUser)) {
           counter = userName.get(uniqueUser);
        }

        return uniqueUser +" " + counter;
    }

//    public void clearUser(String user){
//
//    }

    public void clear(){
        userName.clear();
    }
}
