package sp33.src;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class JflixDB {
    Movie[] movies = new Movie[101];
    public JflixDB(){

    }


    public String[] getMovies(){
        String[] values = new String[100];
        String header;
        try {
            Scanner scan = new Scanner(new File("data/Movies.txt"));
            header = scan.nextLine();
            for (int i = 0; i < values.length; i++){
                String s = scan.nextLine();
                values[i] = s;
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        return values;
    }






    public Movie[] createMovieList(String[] data) {

        for (int i = 0; i < data.length; i++) {
            String s = data[i];// puts strings from data into s
            String[]values = s.split(";");



            //Gives a variable for each index
            String name = values[0];
            String year = values[1];
            String genre = values[2];
            String rating = values[3];

            Movie movies1 = new Movie(name,year,genre,rating);



            movies[i] = movies1;


        }
        return movies;

    }


}
