package sp33.src;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDB extends User{


    //take info from user signup
    //get username and password, save in a text file
    public  ArrayList<String> getUsers() {
        File file = new File("Data/userDB.txt");
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            String str = input.nextLine();

            while (input.hasNextLine()) {
                data.add("\n,"+input.nextLine());
            }
        } catch (FileNotFoundException e) {
            data = null;
        }

        return data;
    }
