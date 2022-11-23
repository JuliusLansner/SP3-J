package sp33.src;

import java.sql.*;
import java.util.Scanner;

public class SaveDeleteFunctions {
    UserDB userconnect = new UserDB();

    public void deleteContent(String input) {

        try {

            //Connection to database
            userconnect.connect();

            Statement statement = userconnect.connection.createStatement();

            //Executes the query
            statement.executeUpdate("delete from watchLater where content_title = ('" + input + "')");

            System.out.println("Delete complete");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void watchLater(String input){


        try {
            userconnect.connect();
            Statement statement = userconnect.connection.createStatement();


            String sql = "insert into watchLater" + "(content_title)" + " values ('"+input+"')";

            statement.executeUpdate(sql);

            System.out.println("Content added to your watch later list");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

