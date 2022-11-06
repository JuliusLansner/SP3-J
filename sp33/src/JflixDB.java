package sp33.src;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JflixDB {

    public JflixDB(){

    }

    public ArrayList<String> getMovies(){
        ArrayList<String>movies = new ArrayList<>();
        String movie;
        try {

            Scanner scan = new Scanner(new File("data/Movies.txt"));
            String str = scan.nextLine();

            while(scan.hasNextLine()){
                movies.add(scan.nextLine());
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }



        return movies;
    }




    public ArrayList<Movie> movieListCategorize(ArrayList<String> data) {
        ArrayList<Movie> list = new ArrayList<>();

        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(";");

            //Gives a variable for each index
            String name = values[0];
            String year = values[1];
            String genre = values[2];
            String rating = values[3];


            Movie movies1 = new Movie(name,genre,year,rating);
            //adds all the data on those values to the arraylist
            list.add(movies1);



        }


        return list;

    }


}
