package quotes;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class App {
    public static void main(String[] args) throws IOException {
        getData();
    }

    public static void getData() throws IOException {
        String path = "C:\\cmder\\Code401\\quotes\\app\\src\\main\\resources\\recentquotes.json";
        System.out.println(quoteRandom(path, true));
    }

    public static String quoteRandom(String path, Boolean test) throws IOException {
        File file = new File(path);
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        quotes.RetrieveQuotes[] json=gson.fromJson(reader, quotes.RetrieveQuotes[].class);
        int index;
        if (test.equals(true)) {
            index = 0;
        } else {
            index = (int) (Math.random() * json.length);
        }
        String author = json[index].author + ": ";
        String text = "\"" + json[index].text + "\"";

        return author + text;
    }
}


