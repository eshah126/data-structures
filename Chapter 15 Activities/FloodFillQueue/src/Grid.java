import java.util.Stack;


public class Grid
{
  private static final int SIZE = 10;
  int[][] pixels = new int[SIZE][SIZE];
  Stack<Pair> floodPairs = new Stack<>();
  
  

    
    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
      //
      int fill = 1;
      Pair prompt= new Pair(row,column);
      floodPairs.push(prompt);
      while(floodPairs.size() > 0){
        Pair removed = floodPairs.pop();
        if(pixels[removed.getRow()][removed.getColumn()] ==0){
          pixels[removed.getRow()][removed.getColumn()] = fill;
          //if 0, will fill in with fill num
         

          
        }
      }
      
      
        
      }
      
      

        
        

        
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
