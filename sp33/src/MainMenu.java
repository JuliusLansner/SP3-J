package sp33.src;

import java.util.ArrayList;

public class MainMenu {


    public String search(String movie){

        JflixDB movies = new JflixDB();

        movies.movieListCategorize(movies.getMovies());//funktion movieListCategorize takes an array movies.getMovies and splits the strings.

        ArrayList<String>stuff = movies.movieListCategorize(movies.getMovies());

        for (int i = 0; i < stuff.size(); i++) {
            if(stuff.get(i).contains(movie)){
                return movie;
            }
        }



        return "not found";
    }



}
