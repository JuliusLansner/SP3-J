package sp33.src;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        StartMenu testSM = new StartMenu();

        testSM.loginScreen();
        UserDB test = new UserDB();

        test.signup();

    }


}