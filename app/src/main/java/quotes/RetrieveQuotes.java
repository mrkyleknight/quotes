package quotes;

public class RetrieveQuotes extends App {

    // ***PROPERTIES*** //
    String author;
    String text;

//    public static RetrieveQuotes fromJsonFile(String filepath) {
//        // Code to read from the JSON file and return a RetrieveQuotes object


    public RetrieveQuotes() {

    }


    // ***CONSTRUCTOR*** //
    public RetrieveQuotes(String author, String text) {
        this.author = author;
        this.text = text;
    }

    // ***GETTERS AND SETTERS*** //

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "RetrieveQuotes{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

