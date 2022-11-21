package sp33.src;


import java.io.IOException;
import java.io.Writer;
<<<<<<< Updated upstream
=======
import java.sql.SQLException;
import java.util.Scanner;
>>>>>>> Stashed changes

public class Main {


<<<<<<< Updated upstream
    public static void main(String[] args) throws IOException {

        //StartMenu start = new StartMenu();
        //start.loginScreen();
=======
    public static void main(String[] args) throws IOException, SQLException {
        JflixDB movieArray = new JflixDB();
        User user = new User();
        UserDB test1 = new UserDB();

        test1.loginAttempt();
>>>>>>> Stashed changes

        //Choices test1 = new Choices();
        //test1.choiceFunction();

<<<<<<< Updated upstream
        StartMenu test2 = new StartMenu();
        test2.loginScreen();

        //Til at checke hvordan watchlist ser ud
        //JflixDB checklist = new JflixDB();
        //System.out.println(checklist.getWatchList());
=======
        //JflixDB2 test1 = new JflixDB2();
        //System.out.println(test1.MakeResultSetMovieList());
>>>>>>> Stashed changes


    }



}