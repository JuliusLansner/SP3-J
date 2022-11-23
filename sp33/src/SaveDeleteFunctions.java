package sp33.src;

import java.sql.*;
import java.util.Scanner;

public class SaveDeleteFunctions {
    UserDB userconnect = new UserDB();

    public void deleteContent() {

        Scanner scanner = new Scanner(System.in);

        try {

            //Connection to database
            userconnect.connect();

            Statement statement = userconnect.connection.createStatement();

            System.out.println("What content would like to remove? ");
            String input = scanner.nextLine();

            //Executes the query
            statement.executeUpdate("delete from watchLater where content_title = ('" + input + "')");

            System.out.println("Delete complete");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void watchLater(){

        Scanner scanner = new Scanner(System.in);

        try {
            userconnect.connect();
            Statement statement = userconnect.connection.createStatement();

            System.out.println("Please enter the name of the content you would like to add to your watch later list: ");

            String input = scanner.nextLine();

            String sql = "insert into watchLater" + "(content_title)" + " values ('"+input+"')";

            statement.executeUpdate(sql);

            System.out.println("Content added to your watch later list");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

