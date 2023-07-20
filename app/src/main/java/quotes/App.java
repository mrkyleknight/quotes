package quotes;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

//Fixed booleon type and test (True to false), added sout to verify index. Fixed Random function (did not declare properly).


public class App {
    public static void main(String[] args) throws IOException {
        URL quoteURL = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection quoteConnection = (HttpURLConnection) quoteURL.openConnection();

        try {
            quoteConnection.setRequestMethod("GET");
            int quoteStatus = quoteConnection.getResponseCode();
            System.out.println(quoteStatus);

            if (quoteStatus == 200){
                InputStreamReader quoteStreamReader = new InputStreamReader(quoteConnection.getInputStream());
                try(BufferedReader quoteBufferedReader = new BufferedReader(quoteStreamReader)) {
                    String line = quoteBufferedReader.readLine();


                    //add Gson info
                    Gson gson = new Gson();
                    QuoteGenerator quote = gson.fromJson(line, QuoteGenerator.class);
                    RetrieveQuotes transformedQuote = new RetrieveQuotes(quote.quoteAuthor, quote.quoteText);
                    writeQuote(transformedQuote);
                    System.out.println(transformedQuote);
                }
            } else {
                getData();
            }
        } catch(MalformedURLException mue) {
            getData();
            System.out.println("Bad URL");
        } catch(IOException ioe) {
            getData();
            System.out.println("Problem with API");
            ioe.printStackTrace();
        } finally {
            quoteConnection.disconnect();
        }
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

    public static void writeQuote(RetrieveQuotes quote) throws IOException {
        File file = new File("app/src/main/resources/recentquotes.json");
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        quotes.RetrieveQuotes[] quoteArr = gson.fromJson(reader, quotes.RetrieveQuotes[].class);
        RetrieveQuotes[] newArr = new RetrieveQuotes[quoteArr.length +1];
        for (int i=0; i < quoteArr.length; i++){
            newArr[i] = quoteArr[i];
        }
        newArr[quoteArr.length] = quote;

        File recentQuotesOut = new File("app/src/main/resources/recentquotes.json");
        try (FileWriter quoteFileWriter = new FileWriter(recentQuotesOut)){
            gson.toJson(newArr, quoteFileWriter);
            System.out.println("quote writing succeeded");
        }

    }
}


