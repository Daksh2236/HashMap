import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Responder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Responder 
{
    // instance variables - replace the example below with your own
    private HashMap<String, String> responseMap;
     private String lastDefaultResponse;
     private Random randomGenerator;
    private ArrayList<String> defaultResponses;
     /**
         * Constructor for objects of class Responder
         */
    public Responder()
    {
        responseMap = new HashMap<>();
        randomGenerator = new Random();
        fillResponseMap();
        fillDefaultResponses();
        lastDefaultResponse = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void fillResponseMap()
    {
       String connection = "Is your printer switched on and properly connected?" ; 
       String reboot = "Have you tried rebooting your machine?";
       String speed = "Why do you think it is slow?";
       
       
       responseMap.put("problem", "We can help you with your problem.");
       responseMap.put("slow", speed);
       responseMap.put("lagging", speed);
       
       responseMap.put("crash", reboot);
       responseMap.put("broken", reboot);
       
       responseMap.put("printer", connection);
       responseMap.put("unplunged", connection);
    }
    
    public String pickDefaultResponse()
        {
            String response = lastDefaultResponse;
            while (response.equals(lastDefaultResponse)) {
        int index = randomGenerator.nextInt(defaultResponses.size());
        response = defaultResponses.get(index);
        }
        lastDefaultResponse = response;
        return response;
    }
    
    public String generateResponse(HashSet<String> words) {
        for (String word : words) {
            if (responseMap.containsKey(word)) {
                return responseMap.get(word);
            }
        }
        // None of the words recognized: return a random default response
        return pickDefaultResponse();
    }
    
    private void fillDefaultResponses()
    {
        defaultResponses = new ArrayList<>();
           
        defaultResponses.add("That is an interesting topic. Tell me more.");
        defaultResponses.add("I'm not sure I understand. Can you explain furter?");
    }
    
}
