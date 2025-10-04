import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

/**
 * The Responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * <p>
 * Input is presented to the responder as a set of words. If one of those
 * words matches a key in the response map, the associated response is 
 * returned. If no words are recognized, a default response is chosen at 
 * random from a list of fallback responses.
 * </p>
 *
 * Internally, the responder uses:
 * <ul>
 *   <li>A {@code HashMap<String, String>} to associate key words with responses</li>
 *   <li>An {@code ArrayList<String>} of default responses</li>
 *   <li>A {@code Random} generator to pick a default response when needed</li>
 * </ul>
 * 
 * @author  
 * @version 7.3
 */
public class Responder
{
    /** Used to map key words to their responses. */
    private HashMap<String, String> responseMap;
    /** Default responses to use if no keywords are recognized. */
    private ArrayList<String> defaultResponses;
    /** Random generator to pick a default response. */
    private Random randomGenerator;

    /**
     * Constructs a Responder.
     * <p>
     * Initializes the response map with known keywords and their responses,
     * and builds the list of default responses. Also sets up the random 
     * generator for choosing defaults.
     * </p>
     */
    public Responder()
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        randomGenerator = new Random();
    }

    /**
     * Generates a response based on a given set of input words.
     * <p>
     * If any of the words are found in the response map, the corresponding 
     * response is returned. Otherwise, a random default response is chosen.
     * </p>
     *
     * @param words  A set of words entered by the user
     * @return       A response string to be displayed
     */
    public String generateResponse(HashSet<String> words)
    {
        for (String word : words) {
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
        // No recognized words → fall back to default
        return pickDefaultResponse();
    }

    /**
     * Fills the response map with known keywords and their associated responses.
     * <p>
     * Each keyword maps to a prepared response string that is returned if the 
     * keyword is detected in user input.
     * </p>
     */
    private void fillResponseMap()
    {
        responseMap.put("crash", 
                        """
                        Well, it never crashes on our system. It must have something
                        to do with your system. Tell me more about your configuration.
                        """);
        responseMap.put("crashes", 
                        """
                        Well, it never crashes on our system. It must have something
                        to do with your system. Tell me more about your configuration.
                        """);
        responseMap.put("slow", 
                        """
                        I think this has to do with your hardware. Upgrading your processor
                        should solve all performance problems. Have you got a problem with
                        our software?
                        """);
        responseMap.put("performance", 
                        """
                        Performance was quite adequate in all our tests. Are you running
                        any other processes in the background?
                        """);
        responseMap.put("bug", 
                        """
                        Well, you know, all software has some bugs. But our software engineers
                        are working very hard to fix them. Can you describe the problem a bit
                        further?
                        """);
        responseMap.put("buggy", 
                        """
                        Well, you know, all software has some bugs. But our software engineers
                        are working very hard to fix them. Can you describe the problem a bit
                        further?
                        """);
        responseMap.put("windows", 
                        """
                        This is a known bug to do with the Windows operating system. Please
                        report it to Microsoft. There is nothing we can do about this.
                        """);
        responseMap.put("mac", 
                        """
                        This is a known bug to do with the Mac operating system. Please
                        report it to Apple. There is nothing we can do about this.
                        """);
        responseMap.put("expensive", 
                        """
                        The cost of our product is quite competitive. Have you looked around
                        and really compared our features?
                        """);
        responseMap.put("installation", 
                        """
                        The installation is really quite straight forward. We have tons of
                        wizards that do all the work for you. Have you read the installation
                        instructions?
                        """);
        responseMap.put("memory", 
                        """
                        If you read the system requirements carefully, you will see that the
                        specified memory requirements are 1.5 giga byte. You really should
                        upgrade your memory. Anything else you want to know?
                        """);
        responseMap.put("linux", 
                        """
                        We take Linux support very seriously. But there are some problems.
                        Most have to do with incompatible glibc versions. Can you be a bit
                        more precise?
                        """);
        responseMap.put("bluej", 
                        """
                        Ahhh, BlueJ, yes. We tried to buy out those guys long ago, but
                        they simply won't sell... Stubborn people they are. Nothing we can
                        do about it, I'm afraid.
                        """);
    }

    /**
     * Checks whether the response map contains a given keyword.
     *
     * @param input the word to check
     * @return      {@code true} if the map contains the keyword,
     *              {@code false} otherwise
     */
    public boolean mapContains(String input) 
    {
        return responseMap.containsKey(input);
    }

    /**
     * Builds a list of default responses that can be returned if no keyword 
     * matches the input. These responses are used as fallback options.
     */
    private void fillDefaultResponses()
    {
        defaultResponses.add("That sounds odd. Could you describe that problem in more detail?");
        defaultResponses.add("""
                             No other customer has ever complained about this before.
                             What is your system configuration?
                             """);
        defaultResponses.add("That sounds interesting. Tell me more...");
        defaultResponses.add("I need a bit more information on that.");
        defaultResponses.add("Have you checked that you do not have a dll conflict?");
        defaultResponses.add("That is explained in the manual. Have you read the manual?");
        defaultResponses.add("""
                             Your description is a bit wishy-washy. Have you got an expert
                             there with you who could describe this more precisely?
                             """);
        defaultResponses.add("That's not a bug, it's a feature!");
        defaultResponses.add("Could you elaborate on that?");
    }

    /**
     * Randomly selects and returns one of the default responses.
     *
     * @return A random default response string
     */
    private String pickDefaultResponse()
    {
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
