public class FirstLetterMap
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities\FirstLetterMap\FirstLetterMap2\src\test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            Map<Character, Set<String>> firstLetters = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                // Update the map here
                // Modify Worked Example 15.1
                
                Set<String> words = firstLetters.get(c);

                if (words == null){
                    words = new TreeSet<>();
                    words.add(word);
                    firstLetters.put(c, words);
                }
                else {
                    words.add(word);
                    firstLetters.put(c, words);
                }
            }

            // Print the map here in this form
            // a: [a, able, aardvark]
            
            for (Character key : firstLetters.keySet()){
                System.out.println(key + ": " + firstLetters.get(key));
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