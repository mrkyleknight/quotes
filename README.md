# quotes

# Instructions for Running App.
- Either run `./gradlew run` from terminal or navigate to main app and hit run in Intellij
- To test `./gradlew test` or navigate to test files and hit run.

Name of feature: 

Use the file recentquotes.json to show random popular book quotes. Your program should use GSON to parse the .json file. The app needs no functionality other than showing the quote and the author when it is run. The app should choose one quote each time it is run.

so what’s interesting here?
The interesting parts of this lab are:

How do I use GSON?
What class(es) should I write to encapsulate this functionality?
How does the App class use the class(es) I write?
How do I test this functionality?


Estimate of time needed to complete: 120min Start time: 1330 Finish time: 1530

Actual time needed to complete: 180 minn

Resources:

Chat GPT & TA Tony 


App.Java:
The program reads a JSON file containing quotes, uses Gson library to parse the JSON data into Java objects representing the quotes, and selects one quote randomly when run.
For testing, the program contains a method to always return the first quote from the JSON file, which allows for predictable testing.


RetrieveQuotes.java:
The code defines a test class, AppTest, with a single test method, appHasAGreeting, using JUnit 5.

The appHasAGreeting test checks if the getGreeting method of an instance of the App class returns a non-null value, asserting that the App class should indeed have a method called getGreeting that returns a non-null greeting message.








