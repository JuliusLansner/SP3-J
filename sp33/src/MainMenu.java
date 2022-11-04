package sp33.src;

import java.util.ArrayList;

public class MainMenu {


    public String searchMovie(String movie){

        JflixDB movies = new JflixDB();

        movies.movieListCategorize(movies.getMovies());//funktion movieListCategorize takes an array movies.getMovies and splits the strings.

        ArrayList<String>stuff = movies.movieListCategorize(movies.getMovies());


        for (int i = 0; i < stuff.size(); i++) {
            if(stuff.get(i).equals(movie)){

                return "Vi har filmen" + movie;
            }
        }

        //System.out.println(stuff);
        //System.out.println(stuff.get(1));
        return "not found";
    }

    public String searchYear(String year){

        JflixDB movies = new JflixDB();

        movies.movieListCategorize(movies.getMovies());//funktion movieListCategorize takes an array movies.getMovies and splits the strings.

        ArrayList<String>years = movies.yearListCategorize(movies.getMovies());


        for (int i = 0; i < years.size(); i++) {
            if(years.get(i).contains(year)){
                System.out.println(years);

               return years.get(i);
            }
            System.out.println(years);
        }


        //System.out.println(stuff.get(1));
        return "not found";
    }



}
