package sp33.src;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JflixDB {
//hey
    public JflixDB(){

    }

    public  ArrayList<String> getMovies() {
        File file = new File("Data/Movies.txt");
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            String str = input.nextLine();//ignorer header

            while (input.hasNextLine()) {
                data.add("\n,"+input.nextLine());//Adds input on the next line.
            }
        } catch (FileNotFoundException e) {
            data = null;
        }

        return data;
    }

    public ArrayList<String> movieListCategorize(ArrayList<String> data) {
        ArrayList<String> list = new ArrayList<>();

        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(";");

            //Gives a variable for each index
            String name = values[0];
            String year = values[1];
            String genre = values[2];

            //adds all the arrays to the arraylist list
            list.add("\n"+name);
            list.add(year);
            list.add(genre);


        }
        //System.out.println(list);

        return list;

    }


}
