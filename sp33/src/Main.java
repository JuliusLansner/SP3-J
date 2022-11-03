package sp33.src;

import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {

        JflixDB movies = new JflixDB();
        System.out.println(movies.Movies());
        MainMenu mainmenu = new MainMenu();

        System.out.println(mainmenu.search("Titanic 1980 Romance"));


    }
}