package sp33.src;

import java.util.ArrayList;

public class MainMenu {


    public String search(String movie){
        JflixDB movies = new JflixDB();
        movies.Movies();
        ArrayList<String>stuff = movies.Movies();
        for (int i = 0; i < stuff.size(); i++) {
           if(stuff.get(i).equals(movie)){

               return movie;
           }
        }
        System.out.println(movies);
        return "not fount";
    }

}
