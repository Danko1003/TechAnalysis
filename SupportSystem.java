import java.util.HashSet;

/**
 * This class implements a technical support system. It is the top-level class 
 * in this project. The support system communicates via text input/output 
 * in the text terminal.
 * 
 * The SupportSystem uses:
 * <ul>
 *   <li>{@link InputReader} to read user input</li>
 *   <li>{@link Responder} to generate automated responses</li>
 *   <li>{@link WordCounter} to count the words provided by the user</li>
 * </ul>
 * 
 * The system runs an interaction loop where it repeatedly reads user input,
 * produces a response, and terminates only when the user types "bye".
 * 
 * @author  
 * @version 7.4
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;
    private WordCounter counter;
    
    /**
     * Constructs a new SupportSystem.
     * Creates the helper objects needed to read user input, 
     * generate responses, and count words.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
        counter = new WordCounter();
    }

    /**
     * Starts the technical support system.
     * <p>
     * Prints a welcome message and begins a loop that:
     * <ul>
     *   <li>Reads user input as a set of words</li>
     *   <li>Checks whether the user typed "bye" (to end the session)</li>
     *   <li>If not, updates the word counter, generates a response, and displays it</li>
     * </ul>
     * When the user ends the session, a good-bye message is displayed along 
     * with the number of distinct words prompted.
     */
    public void start()
    {
        boolean finished = false;
        
        printWelcome();

        while(!finished) {
            HashSet<String> input = reader.getInput();

            if(input.contains("bye")) {
                finished = true;
            }
            else {
                counter.addWords(input);
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        
        printGoodbye();
        System.out.println(wordCount(counter.hashToArray()) + " word(s) were prompted.");
    }
    
    /**
     * Counts the total number of words entered by the user,
     * excluding words that are already present in the Responder's map.
     *
     * @param wordSet  an array of words entered by the user
     * @return the adjusted word count (total minus known words)
     */
    private int wordCount(String[] wordSet)
    {
        int count = counter.getWordCount();
        for (int i = 0; i < wordSet.length; i++)
        {
            if (responder.mapContains(wordSet[i])) {
                count = count - 1;
            }
        }
        return count;
    }

    /**
     * Prints a welcome message to the screen. 
     * Explains the purpose of the system and 
     * how the user can exit the program.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Prints a farewell message to the screen,
     * signaling the end of the support session.
     */
    private void printGoodbye()
    {
        System.out.println("Nice talking to you. Bye...");
    }
}
