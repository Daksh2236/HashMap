import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.Set;

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
    private HashMap<String, String> questionMap;
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
        fillQuestionMap(); 
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
    
    public String generateResponse(HashSet<String> words)
        {
        Set<String> matchedWords = new HashSet<>(); 
            
        String firstMatchResponse = null;
    
        for (String word : words) {
            if (responseMap.containsKey(word)) {
                if (firstMatchResponse == null) {
                    firstMatchResponse = responseMap.get(word);
                    }
                matchedWords.add(word); 
                }
            }
    
        int matchCount = matchedWords.size();
            
        if (matchCount > 1) {
                return "several issues mentioned: " + matchedWords.toString() + ". Which is a priority";
            }
            else if (matchCount == 1) {
                   return firstMatchResponse; 
            }
                 for (String word : words) {
                      if (questionMap.containsKey(word)) {
                          return questionMap.get(word); 
            }
        }
        return pickDefaultResponse();
    }
    
    private void fillDefaultResponses()
    {
        defaultResponses = new ArrayList<>();
           
        defaultResponses.add("That is an interesting topic. Tell me more.");
        defaultResponses.add("I'm not sure I understand. Can you explain furter?");
    }
    
    private void fillQuestionMap()
    {
        questionMap.put("why", "Why do you ask that? Can you provide more details?");
        questionMap.put("how", "That's a good question. How did you try to solve it previously?");
        questionMap.put("who", "I don't have access to user names. Can you describe who you mean?");
        questionMap.put("what", "What specifically are you trying to achieve?");
    }   
}
