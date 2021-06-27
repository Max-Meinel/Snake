import java.io.*;

public class SaveData {

    public int getHighscore() throws IOException {
        FileReader fr = new FileReader("src/Images/data.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile1 = br.readLine();
        int highscore = Integer.parseInt(zeile1);
        return highscore;
    }

    public void setHighscore(int highscore) throws IOException {
        File file = new File("src/Images/data.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(String.valueOf(highscore));
        writer.close();
    }
}