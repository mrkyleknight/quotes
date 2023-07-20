package quotes;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class App {
    public static void main(String[] args) throws IOException {
        getData();
    }

    public static void getData() throws IOException {
        String path = "C:\\cmder\\Code401\\quotes\\app\\src\\main\\resources\\recentquotes.json";
        System.out.println(quoteRandom(path, false));
    }

    public static String quoteRandom(String path, boolean test) throws IOException {
        File file = new File(path);
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        quotes.RetrieveQuotes[] json = gson.fromJson(reader, quotes.RetrieveQuotes[].class);

        Random random = new Random();
        int index;
        if (test) {
            index = 0;
        } else {
            index = random.nextInt(json.length);
        }
        System.out.println("Index Used: " + index);
        String author = json[index].author + ": ";
        String text = "\"" + json[index].text + "\"";

        return author + text;
    }
}


