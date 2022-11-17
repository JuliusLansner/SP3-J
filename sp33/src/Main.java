package sp33.src;


import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        JflixDB movieArray = new JflixDB();

      /* UserDB testU = new UserDB();
       Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String pass = scan.nextLine();
        String currentUser = username+", "+pass;
       testU.verifyUserLogin(username,pass,"userDB.txt",",");
        System.out.println(currentUser);
*/
        //UserDB signup = new UserDB();

        //signup.signup();

        //User user = new User();
        //user.getLogin();
        //user.loginListCat(user.login);


        //StartMenu start = new StartMenu();
        //start.loginScreen();

        //Choices test1 = new Choices();
        //test1.choiceFunction();

       //StartMenu test2 = new StartMenu();
       //test2.loginScreen();

        //Til at checke hvordan watchlist ser ud
        //JflixDB checklist = new JflixDB();
        //System.out.println(checklist.getWatchList());

        //JflixDB test = new JflixDB();
        //System.out.println(test.movieListCategorize(test.getMovies()));

        //Choices run = new Choices();
        //run.choiceFunction();

        JflixDB2 test1 = new JflixDB2();
        System.out.println(test1.MakeResultSetList());

    }



}