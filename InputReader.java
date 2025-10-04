import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is then chopped into words, and a set of words 
 * is provided.
 * 
 * This class is intended for simple text input in console-based applications.
 * Each line of text entered by the user will be split into separate words,
 * stored in a set to avoid duplicates, and returned for processing.
 * 
 * @author  
 * @version 7.3
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Constructs a new InputReader that reads text from the standard 
     * input stream (the text terminal).
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Reads one line of text entered by the user, splits the text into 
     * individual words, and returns the words as a set. 
     * <p>
     * Words are defined as sequences of non-whitespace characters 
     * separated by spaces. The text is automatically converted to 
     * lowercase and trimmed of leading and trailing spaces.
     * <p>
     * Duplicate words are not included in the set.
     *
     * @return  A HashSet containing all unique words typed by the user 
     *          in the current input line.
     */
    public HashSet<String> getInput() 
    {
        // print prompt
        System.out.print("> ");                
        String inputLine = reader.nextLine().trim().toLowerCase();
        
        // Use a Scanner to split at spaces
        Scanner splitter = new Scanner(inputLine);

        // Add each word into the HashSet
        HashSet<String> words = new HashSet<>();
        while(splitter.hasNext()) {
            words.add(splitter.next());
        }
        return words;
    }
}
