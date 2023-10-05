import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stack representing the cars in the driveway.
    */
    Stack<Integer> carsDriveway; 
    private Stack<Integer> driveway;
    /**
      * Stack representing the cars in the street.
    */
    Stack<Integer> carsStreet; 
    private Stack<Integer> street;

    /**
      * Constructor.
    */
    public Driveway( )
    {
        // Complete the constructor
        carsStreet = new Stack<>();
        carsDriveway = new Stack<>();


    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        // Complete this method

        if(licensePlate>0){
        carsDriveway.push(licensePlate);
        }
        if(licensePlate<0){
          remove(licensePlate);
        }
      
        


    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
        // Complete this method
        if(driveway.contains(licensePlate)){}
        driveway.pop();
    }

    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
        for(int i = 0; i < carsDriveway.size();i++){
          System.out.println("Undo" + carsDriveway.peep());
      }

        System.out.println("In Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
        ...

    }
}
