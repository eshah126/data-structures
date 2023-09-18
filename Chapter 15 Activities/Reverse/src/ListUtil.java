import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator <String> iterator = strings.listIterator();
        int count = 0; String emp;

        while( iterator.hasNext()){
            emp = iterator.next();//returns whatever you pass over
            iterator.remove();//removes the one it passes over
            iterator = strings.listIterator(0);//sets it back to 0
            iterator.add(emp);//adds the last one
            iterator = strings.listIterator(count);
            count++;
                
            

             
        }
       


        
    }
}