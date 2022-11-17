package sp33.src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User{
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord;

ArrayList<String> login = new ArrayList<>();
ArrayList<Profiles> loginSplit = new ArrayList<>();


    //---- getter, user login information ----

    public String getUsername() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type your username:");
        userName = input.nextLine();
        return userName;
    }

    public String getPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type your password");
        passWord = input.nextLine();
        return passWord;
    }





    public ArrayList<String> getLogin(){
        // ArrayList<String>movies = new ArrayList<>();
        //not used anywhere
        //String movie;
        try {

            Scanner scan = new Scanner(new File("data/userDB.txt"));
            String str = scan.nextLine();

            while(scan.hasNextLine()){
                login.add(scan.nextLine());
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }



        return login;
    }

    public ArrayList<Profiles> loginListCat(ArrayList<String> data) {

        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(",");

            //Gives a variable for each index
            String name = values[0];
            String pass = values[1];


            Profiles test1 = new Profiles(name, pass);
            //adds all the data on those values to the arraylist
            loginSplit.add(test1);


        }
        return loginSplit;
    }

    public ArrayList<Profiles> profilesArray(){
        return this.loginSplit;
    }

}