package sp33.src;

import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {


        System.out.println("write your username and password");
        UserDB test = new UserDB();
        test.verifyUserLogin(test.getUsername(), test.getPassword(),"Data/userDB.txt",",");



    }
}