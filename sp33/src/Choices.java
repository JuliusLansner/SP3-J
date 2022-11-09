package sp33.src;

import javax.naming.directory.SearchResult;
import java.io.*;
import java.util.Scanner;

public class Choices extends UserDB {
    String filepath = "Data/ContentWatched.txt";
MainMenu test = new MainMenu();
    saveMenu save = new saveMenu();
    public void choiceFunction() throws IOException {
Scanner scan = new Scanner(System.in);
MainMenu mainmenu = new MainMenu();
   String play = test.choice();// kører choice funktionen

System.out.println("press 1 to play a movie");
String input = scan.nextLine();
BufferedWriter writer = new BufferedWriter(new FileWriter("Data/ContentWatched.txt", true));

if(input.equals("1") && checkWatchList(userName +" "+ play) == true) {
    writer.write("\n"+userName +" "+ play);
    writer.close();
}else{
    System.out.println("You already watched this");
}
    }

public boolean checkWatchList(String input){
 File file = new File("data/ContentWatched.txt");

 try {
     Scanner read = new Scanner(file);
 } catch (FileNotFoundException e) {
     throw new RuntimeException(e);
 }
    String text = scanner.nextLine();
 if(input.equalsIgnoreCase(input)){
     return false;
 }
 return true;
}



}
