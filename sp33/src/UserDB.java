package sp33.src;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDB extends User {
    //take info from user signup
    //get username and password, save in a text file


    String filepath = "Data/userDB.txt";
    MainMenu goToMainMenu = new MainMenu();

    boolean loginSuccess = false;

   public  boolean verifyUserLogin(String username, String password, String filepath, String splitter){
    String currentLine;
    String userData[];
    try{
    FileReader DBReader = new FileReader(filepath);
    BufferedReader br = new BufferedReader(DBReader);
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
        } else
        return loginSuccess = false;
    }



    }
    //catch, a failsafe.
    catch (Exception e){
        System.out.println("it went wrong");
    }
        return false;
   }
// SIGNUP FUNCTION
/*

        Scanner scanner = new Scanner(System.in);


        public String Signup() throws IOException {
            System.out.println("Write your username:");

            BufferedWriter writer = new BufferedWriter(new FileWriter("data/userDB.txt",true));


            String username = scanner.nextLine(); //Saves user input in variable "username"


            writer.write(String.valueOf(username));
            writer.close();

            System.out.println("Your new username is: " + username);

            System.out.println("Create your password: ");
            String password = scanner.nextLine();

            BufferedWriter writer1 = new BufferedWriter(new FileWriter("usernameTest.txt"));
            writer1.write(String.valueOf(password));
            writer1.close();

            System.out.println("Your new password is:" + password);

            scanner.close();
        }
*/


    /*public ArrayList<String> getUsers() {

        File file = new File("Data/userDB.txt");
        ArrayList<String> userData = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            //pseudo kode
            if(input.equals(loginInfo)){
                System.out.println("it works XD");
            } else System.out.println("no");
        } catch (FileNotFoundException e) {
            userData = null;
        }

        return userData;
    }




     public ArrayList<String> movieListCategorize(ArrayList<String> data) {
        ArrayList<String> list = new ArrayList<>();

        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(",");

            //Gives a variable for each index
            String name = values[1];
            String year = values[2];
            String genre = values[3];

            //adds all the arrays to the arraylist list
            list.add("\n" + name);
            list.add(year);
            list.add(genre);


        }
        //System.out.println(list);

        return list;

    }
    */



}
