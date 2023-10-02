import java.util.*;
import java.io.*;


public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "C:\Users\eshah\Desktop\GithubSE1\data-structures\Chapter 15 Activities\StringLengthMap\src\test1.txt";
        try (Scanner in = new Scanner(new File(filename)))
        {

            Map<Integer, String> lens = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                // Update the map here
                // Modify Worked Example 15.1
                
                String words = lens.get(len);

                if (words == null) words = word;
                else {
                    words = words + ", " + word;
                }

                lens.put(len, words);

            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i

            for (int key : lens.keySet()){
                System.out.println(key + ": " + lens.get(key));
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}