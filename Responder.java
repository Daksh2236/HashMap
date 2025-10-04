import java.util.HashMap;
import java.util.HashSet;

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

     /**
         * Constructor for objects of class Responder
         */
    public Responder()
    {
        responseMap = new HashMap<>();
        fillResponseMap();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void fillResponseMap()
    {
       responseMap.put("problem", "We can help you with your problem.");
       responseMap.put("slow", "Why do you think it is slow?");
       responseMap.put("crash", "Have you tried rebooting your machine?");
       responseMap.put("printer", "Is your printer switched on and properly connected?");
    }
    
    public String pickDefaultResponse()
        {
    
            //System.out.println("pick a valid key");
            return "please explain further";
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
    
}
