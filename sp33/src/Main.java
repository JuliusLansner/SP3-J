package sp33.src;


import java.io.IOException;
import java.io.Writer;

public class Main {


    public static void main(String[] args) throws IOException {
        JflixDB movieArray = new JflixDB();

        movieArray.loadFiles();
        System.out.println(movieArray.movieList);
        System.out.println("\n");
        System.out.println(movieArray.seriesList);



        //StartMenu start = new StartMenu();
        //start.loginScreen();

        //Choices test1 = new Choices();
        //test1.choiceFunction();

       // StartMenu test2 = new StartMenu();
       // test2.loginScreen();

        //Til at checke hvordan watchlist ser ud
        //JflixDB checklist = new JflixDB();
        //System.out.println(checklist.getWatchList());

        //JflixDB test = new JflixDB();
        //System.out.println(test.movieListCategorize(test.getMovies()));


    }



}