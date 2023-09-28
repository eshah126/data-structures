import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        in.nextLine();

        Map<String, String> gradebook = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;

            } else if (input.equals("A"))
            {
                System.out.println("What is the student's name");
                String name = in.nextLine();
                System.out.println();
                System.out.println("What is the student's grade");
                String grade = in.nextLine();
                gradebook.put(name, grade);
                

            } else if (input.equals("R"))

            {
                System.out.println("What is the student's name");
                String name = in.nextLine();
                
                //String grade = in.nextLine();
                gradebook.remove(name);
                
            } else if (input.equals("M"))
            {
                System.out.println("What students grade do you want to modify?");
                String name = in.nextLine();
                System.out.println("What is the student's  new grade?");
                String Newgrade = in.nextLine();
                gradebook.put(name, Newgrade);





                
            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = gradebook.keySet();
                for(String key : keys){
                    System.out.println(key + gradebook.get(key));
                }
            } else
            {
                done = true;
            }
        }
    }
}
