import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        //Create  a print quue of strings(using a linked list)
        Queue <String> jobs =  new LinkedList<>();

        //add some print jobs

        jobs.add("Esha: Report");
        jobs.add("Cathy: TSD");
        System.out.println("Printing: " + jobs.remove());
        jobs.add("Cathy: Really top sercret doc");
        jobs.add("joe: grocery list");
        jobs.add("Cathy: Can i get fired for this?");

        System.out.println("Printing: " + jobs.remove());


        jobs.add("Boss: Cathy Termination letter");


       
        
        while (jobs.size() >= 1){
            System.out.println(jobs.remove());
        



        }



    }
}
