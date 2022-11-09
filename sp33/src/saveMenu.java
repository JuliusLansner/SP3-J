package sp33.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class saveMenu extends UserDB {
    public void saveContent() throws IOException {

        //File file = new File("Data/SavedContent.txt.txt");
        //FileWriter fw = new FileWriter(file, true);
        //fw.write(userName+choice());

        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/SavedContent.txt.txt", true));

        writer.write(userName+"x"+"\n");

        writer.close();


    }
}
