package sp33.src;

import java.sql.*;
import java.util.Scanner;

public class SaveDeleteFunctions {
    UserDB userconnect = new UserDB();


    public void deleteMovies() {

        Scanner scanner = new Scanner(System.in);

        try {

            //Connection to database
            userconnect.connect();

            Statement statement = userconnect.connection.createStatement();

            System.out.println("What content would like to remove? ");
            String input = scanner.next();

            //This code below works. Executes the query
            statement.executeUpdate("delete from movies where movie_title = ('" + input + "')");

            System.out.println("Delete complete");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteSeries() {

        Scanner scanner = new Scanner(System.in);

        try {

            //Connection to database
            userconnect.connect();

            Statement statement = userconnect.connection.createStatement();

            System.out.println("What content would like to remove? ");
            String input = scanner.next();

            //This code below works. Executes the query
            statement.executeUpdate("delete from movies where series_title = ('" + input + "')");

            System.out.println("Delete complete");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


    //Create a scanner object

