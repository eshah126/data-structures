import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Business utility methods.
*/
public class Business
{
    /**
      * Removes every nth element from the linked list
      *
      * @param employeeNames the linked list to remove from
      * @param n                 the parameter to determine "nth"
     */
    public static void downsize(LinkedList<String> employeeNames, int n)
    {
        ListIterator <String> iterator = employeeNames.listIterator();
        int counter = 0;

        while(iterator.hasNext()){
            if( counter == n-1){
                iterator.n

                iterator.remove();
                counter = 0;
            }
            counter++;
            }

        System.out.print(employeeNames);






    }
}
