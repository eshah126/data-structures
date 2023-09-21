import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        HashSet <Integer> numSet = new HashSet<>();
        



        for(int i = 2; i <= n; i++){
            numSet.add(new Integer(i));
        }

        for(int i = 2; i <= n; i++){
            Iterator iterator = numSet.Iterator();
        }

        // Your work goes here
        







    }
}
