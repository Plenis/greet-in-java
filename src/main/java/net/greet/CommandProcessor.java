package net.greet;

public class CommandProcessor {
  Greeting greeting;
  public CommandProcessor(Greeting greeting){
      this.greeting = greeting;
  }
  public String processCommands(CommandExtractor commandProcessor){

      if(commandProcessor.getCommand().equals("greet")){
          if(commandProcessor.getName() != null){
              return greeting.greeter(commandProcessor.getName(), commandProcessor.getLanguage());
          }else {
              return "Oops, you didn't enter a name!";
          }
      }

      else if(commandProcessor.getCommand().equals("greeted")){
          if(commandProcessor.getName().equals("")){
              return greeting.greeted();
          }
//          else{
//              return greeting.greetedUser(commandProcessor.getName());
//          }
      }

      else if(commandProcessor.getCommand().equals("clear")){
          if(commandProcessor.getName() != null){
              return greeting.clearUser(commandProcessor.getName());
          }else{
              return greeting.clearAll();
          }
      }
      else {
          return "Invalid command!\n" + greeting.help();
      }
      return "" ;
  }
}
