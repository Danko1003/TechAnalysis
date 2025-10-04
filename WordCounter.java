import java.util.HashMap;
import java.util.HashSet;

/**
 * The WordCounter class keeps a record of how many times each word 
 * was entered by users. Words are stored in a map along with their 
 * usage frequency. 
 * <p>
 * This class is useful for tracking repeated words during an 
 * interactive support session.
 * </p>
 * 
 * @author  
 * @version 7.0
 */
public class WordCounter
{
    /**
     * A mapping between words (keys) and the number of times each 
     * word has been entered (values).
     */
    private final HashMap<String, Integer> counts;

    /**
     * Constructs a new WordCounter.
     * Initializes the internal map to store word counts.
     */
    public WordCounter()
    {
        counts = new HashMap<>();
    }
    
    /**
     * Updates the usage count of all words in the given input set.
     * <p>
     * If a word is already present, its count is increased. 
     * Otherwise, the word is added to the map with a count of 1.
     * </p>
     *
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input)
    {
        for(String word : input) {
            int counter = counts.getOrDefault(word, 0);
            counts.put(word, counter + 1);
        }
    }
    
    /**
     * Returns an array containing all the words currently stored
     * in the counter.
     *
     * @return an array of Strings, each representing a distinct word
     *         that has been entered at least once.
     */
    public String[] hashToArray()
    {
        String[] array = counts.keySet().toArray(new String[0]);
        return array;
    }
    
    /**
     * Returns the number of distinct words stored in this WordCounter.
     *
     * @return the total number of unique words entered by the user.
     */
    public int getWordCount() 
    {
        int wordCount = counts.size();
        return wordCount;
    }
}
