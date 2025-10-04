import java.util.HashSet;

/**
 * This class implements a technical support system. It is the top-level class 
 * in this project. The support system communicates via text input/output 
 * in the text terminal.
 * 
 * This class uses an object of class InputReader to read input from the user,
 * an object of class Responder to generate responses, and a WordCounter to 
 * track usage of words. It contains a loop that repeatedly reads input and 
 * generates output until the user wants to leave.
 * 
 * @author  
 *   Michael Kölling and David J. Barnes (original)
 *   Updated by Megh (Lab 5, Part III)
 * @version 7.5
 */
public class SupportSystem {
    private InputReader reader;
    private Responder responder;
    private WordCounter counter;
    
    /**
     * Creates a technical support system.
     */
    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
        counter = new WordCounter();
    }

    /**
     * Start the technical support system. 
     * Prints a welcome message and enters into a dialog with the user,
     * until the user types "bye".
     */
    public void start() {
        boolean finished = false;
        printWelcome();

        while (!finished) {
            HashSet<String> input = reader.getInput();

            if (input.contains("bye")) {
                finished = true;
            } else {
                // Track word usage
                counter.addWords(input);
                // Generate a response
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome() {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a goodbye message and also show the word usage statistics.
     */
    private void printGoodbye() {
        System.out.println("Nice talking to you. Bye...");
        System.out.println();

        // Q44: print all word counts
        counter.printWordCounts();

        // Q45: optionally, print only non-response words
        System.out.println();
        counter.printNonResponseWordCounts(responder.getResponseMap());
    }
}
