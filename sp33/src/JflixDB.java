package sp33.src;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JflixDB {

    public JflixDB(){

    }

    public  ArrayList<String> Movies() {
        File file = new File("Data/Movies.txt");
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            input.nextLine();//ignorer header

            while (input.hasNextLine()) {
                data.add(input.nextLine());//Adds input on the next line.
            }
        } catch (FileNotFoundException e) {
            data = null;
        }

        return data;
    }


}
