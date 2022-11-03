package sp33.src;

import java.io.*;
import java.util.Scanner;

public class UserDB extends User{
    //take info from user signup
    //get username and password, save in a textfile



    public void writeToFile(String username, String password) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));

        out.write(username + "#" + password);

        out.newLine();

        out.close();
    }



getLoginInfo(){

}
}
