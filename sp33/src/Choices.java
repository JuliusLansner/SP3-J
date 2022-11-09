package sp33.src;

import javax.naming.directory.SearchResult;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Choices extends MainMenu {
    String filepath = "Data/ContentWatched.txt";

    public void choiceFunction() throws IOException {
Scanner scan = new Scanner(System.in);
MainMenu mainmenu = new MainMenu();

String play = choice();// kører choice funktionen
System.out.println("press 1 to play a movie");
String input = scan.nextLine();
BufferedWriter writer = new BufferedWriter(new FileWriter("Data/ContentWatched.txt", true));

if(input.equals("1")) {
    writer.write("\n" + play);
    writer.close();
}

    }












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
