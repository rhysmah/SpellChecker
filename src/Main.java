import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

class SpellChecker {

    /*
     * Returns an ArrayList of words from a file.
     */
    static ArrayList<String> read(String file) throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>();
        new Scanner(System.in);
        Scanner reader;

        reader = new Scanner(new FileReader(file));
        while (reader.hasNext())                   // Reads file until EOF is reached
            list.add(reader.next().toLowerCase()); // Converts words to lowercase, stores them in array

        reader.close();
        return list;
    }

    /*
     * Sequential Search or Linear Search is a brute force technique which forces
     * the program to loop through each index until the key value is found.
     * Normally the technique would have an efficiency of O(n) if the program is looking
     * for a single key. However, in this case the efficiency should be O(n^2) as we are
     * comparing 2 different ArrayLists and the outer loop is dependent of the inner loop.
     * Efficiency : O(n^2)
     */
    static void seqSearch(ArrayList<String> test, ArrayList<String> words) {

        double startTime;
        double elapsedTime;

        ArrayList <String> wordsNotFound = new ArrayList<>();
        int count = 0;

        startTime = System.currentTimeMillis();

        // Sequential Search Algorithm
        for (String testWord : test) {       // Loop through each testWord.
            boolean matchFound = false;

            for (String word : words) {      // For each testWord, loop through all words.
                if (word.equals(testWord)) { // If there's a match, set a flag and break loop.
                    matchFound = true;
                    break;
                }
            }
            // If no match found, add testWord to array and increment count.
            if (!matchFound) {
                wordsNotFound.add(testWord);
                ++count;
            }
        }
        elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
        System.out.println("Sequential Search:\t" + count + " words not found. " + elapsedTime + " microseconds.");
        System.out.println("Words not found:\t" + wordsNotFound);
    }

    /*
     *  Binary search is a method in which the 'middle' index of reference array
     *  and the 'key' value is always compared. In each comparison, the middle
     *  index adjusts depending on ig the key is < or > or = to the middle.
     *  Looping through the test_data is (n) times, and comparing it using
     *  binary search technique is (logn).Thus, program is supposed to run (n)(logn) times
     *  Efficiency : O(nlogn)
     */
    static void binSearch(ArrayList<String> test, ArrayList<String> words) {

        double startTime;
        double elapsedTime;

        ArrayList <String> wordsNotFound = new ArrayList<>();
        int count = 0;

        startTime = System.currentTimeMillis();

        // Binary Search Algorithm

        elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
        System.out.println("Binary Search:\t\t" + count + " words not found. " + elapsedTime + " microseconds.");
        System.out.println("Words not found:\t" + wordsNotFound);
    }

    /*
     * main method
     */
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList <String> test  = read("src/lab3_testdata.txt");
        ArrayList <String> words = read("src/lab3_wordlist.txt");

        seqSearch(test, words);
        System.out.println();
        binSearch(test,words);
    }
}
