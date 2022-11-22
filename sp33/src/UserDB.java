package sp33.src;


import java.io.*;
import java.sql.*;
import java.util.Scanner;



public class UserDB extends JflixDB2{
    //take info from user signup
    //get username and password, save in a text file

    String filepath = "Data/userDB.txt";
    MainMenu goToMainMenu = new MainMenu();
    String userData[];

    boolean loginSuccess;
    Connection connection1; //Laver et object at connection.
    final private String username = "root";
    //change password
    final private String password = "";

    //change tablename (jflix). "?" is still needed.
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
        //sql database verifying
        User user = verifyUserLogin(userName,passWord);
        // txt file verifying
        verifyOld(userName, passWord);
        if(user != null){
            System.out.println("yeet");
            System.out.println(loginSuccess + "<-old text based version");
        } else
            System.out.println("try again\n"+loginSuccess+"<-old text based version");

        return user;
    }
    public User verifyUserLogin(String userName, String passWord){
        User user = null;


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
                //System.out.println(user.profilesArray().get(i).userName+ "old version works still");
                return user.profilesArray().get(i).puserName;
            }
        }
        //System.out.println(user.profilesArray());
        loginSuccess = false;
        return username;
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
        writer1.write(String.valueOf(password+";"));
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
