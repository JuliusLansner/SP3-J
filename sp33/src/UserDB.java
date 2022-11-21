package sp33.src;


import java.io.*;
<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Scanner;

public class UserDB extends User {
=======
import java.sql.*;
import java.util.Scanner;



public class UserDB extends JflixDB2{
>>>>>>> Stashed changes
    //take info from user signup
    //get username and password, save in a text file


    String filepath = "Data/userDB.txt";
    MainMenu goToMainMenu = new MainMenu();
<<<<<<< Updated upstream

    boolean loginSuccess;

   public  boolean verifyUserLogin(String username, String password, String filepath, String splitter){
    String currentLine;
    String userData[];
    try{
    //FileReader DBReader = new FileReader(filepath);
   // BufferedReader br = new BufferedReader(DBReader);

        //just testing some code...
        BufferedReader br = new BufferedReader(new FileReader("Data/userDB.txt"));

        //while loop storing next line to currentLine, if it's not equal to null. (not empty)
        //if it's NOT equal to null, there's more data in the file we want to read
        //if its equal to null there's nothing more we need to read.
    while((currentLine = br.readLine()) !=null){
        // each element of this array is gonna be determined by where a comma is. userData being split at current line, when splitter is met, which is a comma.
        userData = currentLine.split(splitter);
        // here, we check if the username and the password match ( userData[0] being username and [1] being password)
        // and they need to be on the same line of the text file. So if BOTH strings are true, then this if statement run.
        if(userData[0].equals(username) && userData[1].equals(password)){
            return loginSuccess = true;
        }
    }
=======
    String userData[];

    boolean loginSuccess;
    Connection connection1; //Laver et object at connection.
    final private String username = "root";
    final private String password = "Mevgamor970";

    String url = "jdbc:mysql://localhost:3306/jflix?" + "autoReconnect=true&useSSL=false";

    String query3 = "INSERT INTO user (userName, userPass)" + "VALUES(?,?)";

    public void connect(){ //Laver forbindelse til databaseserveren.
        try {
            this.connection = DriverManager.getConnection(url,username,password); //Driver manager finder server objectet connection skal connectes til.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public User loginAttempt(){
        Scanner input = new Scanner(System.in);
        System.out.println("Type your username:");
        String userName = input.nextLine();
        System.out.println("Type your password");
        String passWord = input.nextLine();
       User user = verifyUserLogin(userName,passWord);
       verifyOld(userName, passWord);
       if(user != null){
            System.out.println("yeet <- newer, *cooler* mysql version");
           System.out.println(loginSuccess+"<-old text file based login check system");
        } else System.out.println("try again <- newer, *cooler* mysql version  \n"+loginSuccess+"<-old text file based login check system");
       return user;
    }

>>>>>>> Stashed changes

    public User verifyUserLogin(String userName, String passWord){
        User user = null;

<<<<<<< Updated upstream

    }
    //catch, a failsafe.
    catch (Exception e){
        System.out.println("it went wrong");
    }
        return loginSuccess = false;
   }
=======
        try {
            connect();
            String checkSql = "SELECT * FROM user WHERE userName=? AND userPass=?";
            PreparedStatement prep = connection.prepareStatement(checkSql);
            prep.setString(1,userName);
            prep.setString(2,passWord);
            ResultSet resultSet = prep.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.userName = resultSet.getString("userName");
                user.passWord = resultSet.getString("userPass");
            }
            prep.close();
            connection.close();

        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return user;
    }
public String verifyOld(String username, String password){
        User user = new User();
    user.getLogin();
    user.loginListCat(user.login);
    user.profilesArray();
    for (int i = 0; i <user.profilesArray().size() ; i++) {

        if (user.profilesArray().get(i).puserName.equalsIgnoreCase(username) && user.profilesArray().get(i).ppassWord.equalsIgnoreCase(password+";")) {
            loginSuccess = true;
            return user.profilesArray().get(i).puserName;
        }
    }
>>>>>>> Stashed changes

    loginSuccess = false;
    return "Wrong - text file method";
}

    // SIGNUP FUNCTION
    Scanner scanner = new Scanner(System.in);
    public void signup() throws IOException, SQLException {
        connect();
        JflixDB2 connectDB = new JflixDB2();
        System.out.println("Write your username:");

        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/userDB.txt",true));

        String username = scanner.nextLine();

        System.out.println("Your new username is: " + username);
        System.out.println("Create your password: ");

        String password = scanner.nextLine();

        BufferedWriter writer1 = new BufferedWriter(new FileWriter("Data/userDB.txt", true));
        writer1.write(String.valueOf(username + ","));
        writer1.write(String.valueOf(password));
        writer1.write("\n");
        writer1.close();
        System.out.println("Your new password is:" + password);

        try {
            PreparedStatement prep = connection.prepareStatement(query3);
            prep.setString(1, username);
            prep.setString(2, password);
            prep.execute();
            connection.close();
        }
        catch (Exception e)
        {
            System.err.println("Exception:");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
        //Siger hvilken forbindelse der skal laves et statement til.

        //Laver holder til mit statement.
        //statementUser.execute(query3);//executer mit sql statement som får alle film fra databasen.






    }


}
