import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {

        //read the dictionary and novel
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/war-and-peace.txt");



        //print all the words in the novel but not the dictionary
        for(String word: novelWords){
            if(!dictionaryWords.contains(word)){
                System.out.println(word);

            }
        }
        //print number of uniqe words

        System.out.println("There are " + novelWords.size() + " unique words in the novel");
        //Number of unique words for than 3

        Iterator<String> iterator = novelWords.iterator();
        while(iterator.hasNext()){
            if(iterator.next().length()>3){
                iterator.remove();
            }
        }
        System.out.println("There are " + novelWords.size() + " unique words with more than 3 letters in the novel");
        
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {


//we used a hashset instead of a treeset winvce the order does'nt work
        Set <String> words = new HashSet<>();
        //determine the current working directory

        //System.out.println(System.getProperty("user.die"));
        Scanner in = new Scanner(new File(filename), "UTF-8");
        //use any character that's not a letter as delimietes(what its using to seperate the words)

        in.useDelimiter("[^a-zA-z]+");
            
        while(in.hasNext()){
            //add words to set(duplicates are ignored)
            words.add(in.next().toLowerCase());
        }






        return words;
    }
}
