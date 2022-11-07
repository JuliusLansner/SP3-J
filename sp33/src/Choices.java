package sp33.src;

import javax.naming.directory.SearchResult;

public class Choices {
    String SearchResult = null;
    public void play() {

            //if 'SearchResult' is not already in the list, add to list

            //for later: to print "Watched Content", loop file: ContentWatched.
            //Check if username is equal to the username that is logged in with. Print those lines.


        System.out.println("You are now playing " + SearchResult);
        }








    public void watchLater() {

        //add to watchLater list

        System.out.println(SearchResult +" has been added to your personal list");
    }

    public void deleteContentFromList() {

        //remove from watchLater list

        System.out.println(SearchResult +" has successfully been removed from your personal list");
    }

}
