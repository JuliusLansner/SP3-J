package sp33.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JflixDB2 {
    Connection connection;
    private String username = "root";
    private String password = "63185276Ma";
    String url = "jdbc:mysql://localhost:3306/testdrivem?" + "autoReconnect=true&useSSL=false";
    String query = "SELECT * FROM movies";
    ArrayList<Movie> movies = new ArrayList<>();


    public void connect(){
        try {
            this.connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<Movie> MakeResultSetMovieList(){
        connect();
        Statement statement;

        try {
            statement = this.connection.createStatement();
            statement.getResultSet();
            statement.execute(query);
            ResultSet set = statement.getResultSet();

            while(set.next()){
                String movieN = set.getString("Movie_Name");
                String year = set.getString("Movie_Year");
                String genre = set.getString("Movie_Genre");
                String rating = set.getString("Movie_Rating");
                Movie movie = new Movie(movieN,year,genre,rating);
                movies.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return movies;

    }
}
