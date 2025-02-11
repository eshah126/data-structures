import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)
        this.rows = new ArrayList<Set<Integer>>();

        for (int r = 0; r < N; r++)
        {
            Set<Integer> row = new HashSet<Integer>();

            for(int c = 0; c < N; c++)
                row.add(grid[r][c]);

            this.rows.add(row);
        }


        // create the list of sets for each col (this.cols)
        this.cols = new ArrayList<Set<Integer>>();

        for (int r = 0; r < N; r++)
        {
            Set<Integer> col = new HashSet<Integer>();

            for (int c = 0; c < N; c++)
                col.add(grid[c][r]);

            this.cols.add(col);
        }

        /* create the list of sets for each square (this.squares)
           the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
        */
        this.squares = new ArrayList<Set<Integer>>();
        int ctr = 0, ctc = 0;

        // 9 sqr total
        for (int num = 0; num < N; num++)
        {
            ctr = num/3 * 3;
            Set<Integer> square = new HashSet<>();

           
            for (int r = ctr; r < ctr + M; r++)
                for (int c = ctc; c < ctc + M; c++)
                    square.add(grid[r][c]);

            this.squares.add(square);

            //staring loc for C
            ctc += 3;

            if (ctc > 8)
                ctc = 0;
        }

        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<Integer>();
        for (int i = 1; i < 10; i++)
            this.nums.add(i);

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */


      
        Set<Integer> possibleNums = new HashSet<Integer>();//makes a set to add
        possibleNums.addAll(this.nums);//adds all
      int nextSquare = (nextRow - nextRow % M) + nextCol/M;// to get square with have to divide the row and col by 3

       possibleNums.removeAll(this.rows.get(nextRow));
        possibleNums.removeAll(this.cols.get(nextCol));
        possibleNums.removeAll(this.squares.get(nextSquare));

        

        
        Set<Integer> row = this.rows.get(nextRow);
        Set<Integer> col = this.cols.get(nextCol);
        Set<Integer> square = this.squares.get(nextSquare);


        
        

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            grid[nextRow][nextCol] = possibleNum;

            row.add(possibleNum);
            col.add(possibleNum);
            square.add(possibleNum);
            // 

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                grid[nextRow][nextCol] = 0;

                row.remove(possibleNum);
                col.remove(possibleNum);
                square.remove(possibleNum);
                //removes it 
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}
