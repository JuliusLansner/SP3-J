package sp33.src;

import javax.naming.directory.SearchResult;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Choices extends MainMenu {
    String filepath = "Data/ContentWatched.txt";

    public void playFunction() throws IOException {

        MainMenu mainmenu = new MainMenu();
        //String movie = choice;

        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/ContentWatched.txt", true));

        writer.write(choice());

        writer.close();
       // System.out.println("You are now playing " + );
    }

            //TO DO:
            //if 'SearchResult' is not already in the list, add to list

            //for later: to print "Watched Content", loop file: ContentWatched.
            //Check if username is equal to the username that is logged in with. Print those lines.










/*
    public void watchLater() {

        //add to watchLater list

        System.out.println(searchResult +" has been added to your personal list");
    }

    public void deleteContentFromList() {

        //remove from watchLater list

        System.out.println(searchResult +" has successfully been removed from your personal list");
    }
*/
}
