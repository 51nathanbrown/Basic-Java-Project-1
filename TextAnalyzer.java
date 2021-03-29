import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * A class that analyzes a text file
 * @author Nathan Brown
 * @version 10/10/2019
 */
public class TextAnalyzer {
    /**
     * Computes whether a string is capitalized
     * @param input that is evaluated
     * @return Boolean value, true if capitalized, false if not
     */
    public static Boolean wordIsCapitalized(String input) {
        if (Character.isUpperCase(input.charAt(0)))
            return true;
        else 
            return false;
    }
    /**
     * 
     */
    public static void analyze() throws FileNotFoundException {
        System.out.println("Let's analyze some text!");
        System.out.print("Enter file name: ");
        Scanner myObj = new Scanner(System.in);
        String fileName = myObj.nextLine();
        File text = new File(fileName);
        Scanner readFile = new Scanner(text);       
        int fileLine = 0;
        int fileWords = 0;
        int fileLongWords = 0;
        int fileSentences = 0;
        int fileCaps = 0;
        char whiteSpace = ' ';
        char sentenceEnd = '.';
        while (readFile.hasNextLine()) {
            String line = readFile.nextLine();
            fileLine++;
            
            for (int i = 0; i < line.length(); i++)
                if (line.charAt(i) == whiteSpace)
                    fileWords++;
                else if (line.charAt(i) == sentenceEnd)
                    fileSentences++;
            
            
            Scanner words = new Scanner(line);
            if (words.hasNextLine())
                fileWords++;
            while (words.hasNext()) {
                String word = words.next();
                if (wordIsCapitalized(word))
                    fileCaps++;
                for (int i = 0; i < word.length(); i++)
                    if (i == 5) {
                        fileLongWords++;
                    }
            }
        }
        
        System.out.println("Number of lines: " + fileLine);
        
        System.out.println("Number of words: " + fileWords);
        
        System.out.println("Number of long words: " + fileLongWords);
        
        System.out.println("Number of sentences: " + fileSentences);
        
        System.out.println("Number of capitalized words: " + fileCaps);
        
    }
    
    
}