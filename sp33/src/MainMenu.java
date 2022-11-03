package sp33.src;

import java.util.ArrayList;

public class MainMenu {


    public String search(String movie){

        JflixDB movies = new JflixDB();

        movies.movieListCategorize(movies.getMovies());//funktion movieListCategorize takes an array movies.getMovies and categorize it
        ArrayList<String>stuff = movies.movieListCategorize(movies.getMovies());

        ArrayList<String> movieNames = new ArrayList<>();

        for (int i = 0; i < stuff.size() ; i++) {
            movieNames.add(stuff.get(i));
        }

        for (int i = 0; i < movieNames.size(); i++) {
          if ((movieNames.get(i)).equals(movie)){
              return movie;
          }
        }

        return "not fount";
    }



}
