package sp33.src;

import java.sql.*;
import java.util.ArrayList;

public class JflixDB2 {

    Connection connection; //Laver et object at connection.
    private String username = "root";
    private String password = "63185276Ma";
    String url = "jdbc:mysql://localhost:3306/jflix?" + "autoReconnect=true&useSSL=false";
    String query = "SELECT * FROM movies";
    String query2 = "SELECT * FROM series";
    ArrayList<Movie> collection = new ArrayList<>(); // Arrayliste til at holde alle Movie og serie objecter.


    public void connect(){ //Laver forbindelse til databaseserveren.
        try {
            this.connection = DriverManager.getConnection(url,username,password); //Driver manager finder server objectet connection skal connectes til.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<Movie> MakeResultSetMovieList(){
        connect();//Laver forbindelse til server.
        Statement statementMovie;// Laver object af statement klassen som kan tage imod sql statements.
        Statement statementSeries;
        try {
            statementMovie = this.connection.createStatement(); //Siger hvilken forbindelse der skal laves et statement til.

            statementMovie.getResultSet();//Laver holder til mit statement.
            statementMovie.execute(query);//executer mit sql statement som får alle film fra databasen.
            ResultSet set = statementMovie.getResultSet();//Laver et resultset som holder alle filmene.

            statementSeries = this.connection.createStatement();

            statementSeries.getResultSet();
            statementSeries.execute(query2);
            ResultSet set2 = statementSeries.getResultSet();

            while(set.next()){
                String movieN = set.getString("movie_title");
                String year = set.getString("movie_year");
                String genre = set.getString("movie_category");
                String rating = set.getString("movie_rating");
                Movie movie = new Movie(movieN,genre,year,rating);
                collection.add(movie);
            }

            /*while(set2.next()){
              String seriesN = set2.getString("series_title");
              String year = set2.getString("series_year");
              String genre = set2.getString("series_category");
              String rating = set2.getString("series_rating");
              String episodes = set2.getString("series_seasons");
              Series series = new Series(seriesN,year,genre,rating,episodes);
              collection.add(series);

            }*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return collection;

    }
}
