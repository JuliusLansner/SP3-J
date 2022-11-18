package sp33.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JflixDB2 {

    Connection connection; //Laver et object at connection.
    private String username = "root";
    private String password = "63185276Ma";
    String url = "jdbc:mysql://localhost:3306/jflix?" + "autoReconnect=true&useSSL=false";
    String query = "SELECT * FROM movies";
    ArrayList<Movie> movies = new ArrayList<>(); // Arrayliste til at holde alle Movie objecter.


    public void connect(){ //Laver forbindelse til databaseserveren.
        try {
            this.connection = DriverManager.getConnection(url,username,password); //Driver manager finder serveren objectet connection skal connectes til.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<Movie> MakeResultSetMovieList(){
        connect();//Laver forbindelse til server.
        Statement statement;// Laver object af statement klassen som kan tage imod sql statements.

        try {
            statement = this.connection.createStatement(); //Siger hvilken forbindelse der skal laves et statement til.

            statement.getResultSet();//Laver holder til mit statement.
            statement.execute(query);//executer mit sql statement som får alle film fra databasen.
            ResultSet set = statement.getResultSet();//Laver et resultset som holder alle filmene.

            while(set.next()){
                String movieN = set.getString("movie_title");
                String year = set.getString("movie_year");
                String genre = set.getString("movie_category");
                String rating = set.getString("movie_rating");
                Movie movie = new Movie(movieN,year,genre,rating);
                movies.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return movies;

    }
}
