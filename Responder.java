import java.util.HashMap;
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
       responseMap.put("jess", "2");
       responseMap.put("bob", "3");
       responseMap.put("rick", "4");
    }
    
    public String pickDefaultResponse()
    {

        //System.out.println("pick a valid key");
        return "pick a valid key";
    }
    
        public String generateResponse(String word)
    {
     String response = responseMap.get(word);
     if(response != null) 
     {
         return response;
     }
     else 
     {
         return pickDefaultResponse();
     }
    }
    
}
