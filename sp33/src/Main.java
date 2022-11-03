package sp33.src;

import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {
        JflixDB db = new JflixDB();

        MainMenu mainmenu = new MainMenu();
        //System.out.println(db.getMovies());
        System.out.println(mainmenu.search("Titanic"));
        //System.out.println(db.movieListCategorize(db.getMovies()));

    }
}