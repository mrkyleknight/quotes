package quotes;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

//Fixed booleon type and test (True to false), added sout to verify index. Fixed Random function (did not declare properly).


public class App {
    public static void main(String[] args) throws IOException {
        getData();
    }

    public static void getData() throws IOException {
        String path = "app/src/main/resources/recentquotes.json";
        System.out.println(quoteRandom(path));
    }

    public static String quoteRandom(String path) throws IOException {
        File file = new File(path);
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        quotes.RetrieveQuotes[] json = gson.fromJson(reader, quotes.RetrieveQuotes[].class);

        Random random = new Random();

        int quoteIndex;
        quoteIndex = random.nextInt(json.length);

        System.out.println("Index Used: " + quoteIndex);
        String author = json[quoteIndex].author + ": ";
        String text = "\"" + json[quoteIndex].text + "\"";

        return author + text;
    }
}


