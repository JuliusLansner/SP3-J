package sp33.src;


import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        JflixDB movieArray = new JflixDB();

        

        Choices run = new Choices();
        //run.choiceFunction();

        JflixDB2 test1 = new JflixDB2();
        System.out.println(test1.MakeResultSetMovieList());

    }



}