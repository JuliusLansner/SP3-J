package sp33.src;

import java.sql.*;
import java.util.ArrayList;

public class JflixDB2 {
    String query = "SELECT * FROM movies";
    String query2 = "SELECT * FROM series";
    String query3 = "INSERT INTO user (userName, userPass)" + "VALUES(?,?)";
    mySqlConnect mySql = new mySqlConnect();
    public ArrayList<String> MakeResultSetMovieList(){
        ArrayList<String> collection = new ArrayList<>(); // Arrayliste til at holde alle Movie og serie objecter.

        mySql.connect();//Laver forbindelse til server.
        Statement statementMovie;// Laver object af statement klassen som kan tage imod sql statements.
        Statement statementSeries;
        try {
            statementMovie = this.mySql.connection.createStatement(); //Siger hvilken forbindelse der skal laves et statement til.

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

        mySql.connect();//Laver forbindelse til server.
        Statement statementSeries;
        try {


            statementSeries = this.mySql.connection.createStatement();

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

    public ArrayList<String> MakeResultSetUsersList(){
        ArrayList<String> collection = new ArrayList<>();

        mySql.connect();//Laver forbindelse til server.
        Statement statementUsers;
        try {


            statementUsers = this.mySql.connection.createStatement();

            statementUsers.getResultSet();
            statementUsers.execute(query3);
            ResultSet set2 = statementUsers.getResultSet();


            while(set2.next()){
                String userName = set2.getString("userName")+";";
                String userPass = set2.getString("userPass")+";";


                collection.add(userName+userPass);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return collection;

    }
}
