import java.util.HashMap;
import java.util.HashSet;

/**
 * The WordCounter class keeps a record of how many times each word 
 * was entered by users during the support session.
 * 
 * It uses a HashMap to map each unique word to the number of times
 * it has been used. This is useful for analyzing word usage after
 * the user ends the session.
 * 
 * @author  
 *   Michael Kölling and David J. Barnes (original)
 *   Updated by Megh (Lab 5, Part III)
 * @version 7.5
 */
public class WordCounter {
    // Associate each word with a count.
    private final HashMap<String, Integer> counts;

    /**
     * Create a WordCounter.
     */
    public WordCounter() {
        counts = new HashMap<>();
    }
    
    /**
     * Update the usage count of all words in input.
     * 
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input) {
        for (String word : input) {
            int counter = counts.getOrDefault(word, 0);
            counts.put(word, counter + 1);
        }
    }

    /**
     * Print the usage count of each word (Q44).
     */
    public void printWordCounts() {
        System.out.println("Word usage counts:");
        for (String word : counts.keySet()) {
            System.out.println(word + ": " + counts.get(word));
        }
    }

    /**
     * Print counts of only those words that are not keys 
     * in the response map (Q45).
     * 
     * @param responseMap A map of known response words from Responder.
     */
    public void printNonResponseWordCounts(HashMap<String, String> responseMap) {
        System.out.println("Other word usage counts:");
        for (String word : counts.keySet()) {
            if (!responseMap.containsKey(word)) {
                System.out.println(word + ": " + counts.get(word));
            }
        }
    }
}
