package net.greet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.HashMap;

public class JDBC implements Greeting{

    final String INSERT_USER_ = "insert into Greeting (name, user_count) values(?, ?)";
    final String FIND_USER_ = "select user_count from Greeting where name = ?";
    final String UPDATE_USER_ = "update Greeting set user_count = user_count + 1 where name = ?";
    final String COUNT_ALL_ = "select count(*) as name from Greeting ";
    final String FIND_GREETED_ = "select * from Greeting ";
    final String DELETE_USER_ = "delete from Greeting where name = ?";
    final String DELETE_ALL_ = "delete from Greeting";

    Connection connection;
    PreparedStatement psGreetUser;
    PreparedStatement psFindUser;
    PreparedStatement psUpdateUserCounter;
    PreparedStatement psFindAllUsersCounter;
    PreparedStatement psGreetedUsers;
    PreparedStatement psDeleteUser;
    PreparedStatement psDeleteAllUsers;

    public JDBC(){
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        final String JDBC_URL_ = "jdbc:h2:file:./target/greet-in-java";

        try {
             connection = DriverManager.getConnection(JDBC_URL_, "sa", "");

             psGreetUser = connection.prepareStatement(INSERT_USER_);
             psFindUser = connection.prepareStatement(FIND_USER_);
             psUpdateUserCounter = connection.prepareStatement(UPDATE_USER_);
             psFindAllUsersCounter = connection.prepareStatement(COUNT_ALL_);
             psGreetedUsers = connection.prepareStatement(FIND_GREETED_);
             psDeleteUser = connection.prepareStatement(DELETE_USER_);
             psDeleteAllUsers = connection.prepareStatement(DELETE_ALL_);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    HashMap<String, Integer> userName = new HashMap<>();

    public void addName(String name){
        try {
            psFindUser.setString(1, name);
            ResultSet resultSetName = psFindUser.executeQuery();

            if(!resultSetName.next()){
                psGreetUser.setString(1, name);
                psGreetUser.setInt(2, 1);
                psGreetUser.execute();
            }
            else {
                resultSetName.getInt("user_count");
                psUpdateUserCounter.setString(1, name);
                psUpdateUserCounter.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String greeter(String name, String language) {
        try {
            addName(name);
            return Language.valueOf(language).getMyLanguage() + name;
        } catch (Exception ex){
            return Language.valueOf("IsiXhosa").getMyLanguage() + name.charAt(0) + name.substring(1) + "!\nGreeted in default language!";
        }
    }

    @Override
    public int counter() {

        try{
            ResultSet resultSetName = psGreetedUsers.executeQuery();
            while (resultSetName.next()){
                userName.put(resultSetName.getString("name"), resultSetName.getInt("user_count"));
            }
            return userName.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String greeted() {

        try{
            ResultSet resultSetName = psGreetedUsers.executeQuery();
            while (resultSetName.next()){
                userName.put(resultSetName.getString("name"), resultSetName.getInt("user_count"));
            }
        } catch (SQLException e) {
            return "Name not available!";
        }
        return userName.toString();
    }

    @Override
    public String greetedUser(String uniqueUser) {

        try{
            ResultSet resultSet = psGreetedUsers.executeQuery();
            while (resultSet.next()){
                userName.put(resultSet.getString("name"), resultSet.getInt("user_count"));
            }

            psFindUser.setString(1, uniqueUser);
            ResultSet rs = psFindUser.executeQuery();

            if(rs.next()){
                return uniqueUser + " has been greeted " + userName.get(uniqueUser).toString() + " time(s)";
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return userName.toString();
    }

    @Override
    public String clearUser(String uniqueUser) {
        try {
            psDeleteUser.setString(1, uniqueUser);
            psDeleteUser.execute();
            psDeleteUser.executeUpdate();
        }
        catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return uniqueUser + " has been cleared!";
    }

    @Override
    public String clearAll() {
        try{
            psDeleteAllUsers.execute();
            psDeleteAllUsers.executeUpdate();
        }
        catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return "-----------------------------\nAll users have been cleared!\n-----------------------------";
    }

    @Override
    public String help() {
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
