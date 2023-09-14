import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /*The addLast method can populate a list */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natahsa");
        staff.addLast("Peter");
        staff.addLast("Gamora");
        //the list is TNPG
        /**
         * The list iterator method creates a new list iterator that is positioned at the head of the list (front)
         * The "|" to rep the iterator position 
         */

         ListIterator<String> iterator = staff.listIterator(); // |TNPG

         /*The next method advances the iterator over the next element in the list */

         iterator.next(); //T|NPG

         /* the next method returns the elemnt that it is passing */


         String avenger = iterator.next(); //TN|PG
         System.out.println(avenger);
         System.out.println("Expected:Natasha");


         /* the add method inserts an elemnt at the iterator position 
          * The iterator is then positioned AFTER the elemnt that was added
         */
        iterator.add("Bruce"); //TNB|PG
        iterator.add("Rocket"); //TNBR|PG
        /*the remove method returned the elemnt by the last call to next or previous 
         * the remove method ONLY can be called after calling next or previous
         * The remove method CANNOT be called after calling add
         */
        iterator.next(); //TNBRP|G
        iterator.remove();//TNBR|G
        System.out.println(staff);

        //System.out.println("Expe");

        /*
         * tHE SET METHOD UPDATES THE ELEMENT RETURNED BY THE LAST CALL TO THE NEXT OF PREVIOS 
         * 
         * 
         */


         iterator.previous();//TNB|RG
         iterator.set("Scott");//TNB|SG
         //sets names after iterator
         /* the hasNExt method is used to determine is there is a next node after the iterator,often used in the condition of a while loop */
         
         








    }
}
