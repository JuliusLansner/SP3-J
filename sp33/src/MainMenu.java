package sp33.src;

import java.util.ArrayList;

public class MainMenu {


    public String search(String movie){

        ArrayList<JflixDB>movies = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
           if(movies.get(i).equals(movie)){

               return movie;
           }
        }
        return "not fount";
    }
}
