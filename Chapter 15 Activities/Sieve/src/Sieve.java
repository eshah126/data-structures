import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import java.util.Iterator;

import java.util.*;

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
            Iterator<Integer> iterator = numSet.iterator();
            while (iterator.hasNext())
            {
                int num = iterator.next().intValue();
                if (num % i == 0 && num / i != 1)
                {
                    iterator.remove();
                }
            }
        }

        System.out.println("The prime numbers up to " + n + "are: ");
        Iterator<Integer> iterator = numSet.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next());
            }




        // Your work goes here
        







    }
}
