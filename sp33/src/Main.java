package sp33.src;

import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {



        UserDB test = new UserDB();
        test.verifyUserLogin(test.getUsername(), test.getPassword(),"Data/userDB.txt",",");


    }
}