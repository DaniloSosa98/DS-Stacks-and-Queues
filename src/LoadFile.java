
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LoadFile {
    
    public static String[] Array() {
        String[] heroName = new String[63];

        try {
            FileInputStream fstream = new FileInputStream("./ActionHeroNames.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int counter = 0;
            while ((strLine = br.readLine()) != null) {
                heroName[counter++] = strLine;
            }
            br.close();
            System.out.println("Added successfully");
            return heroName;
        } catch (Exception e) {
            System.out.println("Some crap happened. Your fault, not mine");
            return heroName;
        }

    }
}
