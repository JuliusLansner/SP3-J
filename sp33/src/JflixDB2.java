package sp33.src;

import java.sql.*;
import java.util.ArrayList;

public class JflixDB2 {

    Connection connection; //Laver et object at connection.

    private String username = "root";
    //change password
    private String password = "";

    //change table name, (jflix). "?" is still needed.
    String url = "jdbc:mysql://localhost:3306/jflix?" + "autoReconnect=true&useSSL=false";
    String query = "SELECT * FROM movies";
    String query2 = "SELECT * FROM series";
    ArrayList<NonInteractiveFiction> collection = new ArrayList<>(); // Arrayliste til at holde alle Movie og serie objecter.
    String movies = "";
    String series = "";

    public void connect(){ //Laver forbindelse til databaseserveren.
        try {
            this.connection = DriverManager.getConnection(url,username,password); //Driver manager finder server objectet connection skal connectes til.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<String> MakeResultSetMovieList(){
        ArrayList<String> collection = new ArrayList<>(); // Arrayliste til at holde alle Movie og serie objecter.

        connect();//Laver forbindelse til server.
        Statement statementMovie;// Laver object af statement klassen som kan tage imod sql statements.
        Statement statementSeries;
        try {
            statementMovie = this.connection.createStatement(); //Siger hvilken forbindelse der skal laves et statement til.

            statementMovie.getResultSet();//Laver holder til mit statement.
            statementMovie.execute(query);//executer mit sql statement som får alle film fra databasen.
            ResultSet set = statementMovie.getResultSet();//Laver et resultset som holder alle filmene.

            while(set.next()){
                String movieN = set.getString("movie_title")+";";
                String year = set.getString("movie_year")+";";
                String genre = set.getString("movie_category")+";";
                String rating = set.getString("movie_raing")+";";
               collection.add(movieN+year+genre+rating);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return collection;

    }


    public ArrayList<String> MakeResultSetSeriesList(){
        ArrayList<String> collection = new ArrayList<>();

        connect();//Laver forbindelse til server.
        Statement statementSeries;
        try {


            statementSeries = this.connection.createStatement();

            statementSeries.getResultSet();
            statementSeries.execute(query2);
            ResultSet set2 = statementSeries.getResultSet();


            while(set2.next()){
                String seriesN = set2.getString("series_title")+";";
                String year = set2.getString("series_year")+";"+" ";
                String genre = set2.getString("series_category")+";";
                String rating = set2.getString("series_rating")+";";
                String episodes = set2.getString("series_seasons")+";";

                collection.add(seriesN+year+genre+rating+episodes);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return collection;

    }
}
