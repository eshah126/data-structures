import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*THE MAP INTERFACE IS GENERIC
         * THE FIRST TYPE IS THE KEY
         * THE SECOND TYPE OF THE VALUE
         */
            Map<String, Color> favColors = new HashMap<>();
            favColors.put("Peter", Color.BLACK);
            favColors.put("Seth",Color.BLUE);
            favColors.put("Celeste",Color.ORANGE);
            favColors.put("Dr.Millers",Color.ORANGE);//2 different keys can have the same value

            //The same key CANNOT HAVE 2 different values
            favColors.put("Peter", Color.YELLOW);//replace



            //create a set of the keys  in a map 
            Set<String> keys = favColors.keySet();

            for(String key : keys){
                System.out.println(key + "("+key.hashCode()+"): " + favColors.get(key));
            }

    }
}
