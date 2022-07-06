import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

public class WordLengths
{
    public int[] countWordLengths(FileResource resource, int[] counts){
        for (String word: resource.words()){
            int wordSize = getAdjLength(word);
            //System.out.println(word + " has len " + wordSize);
            if (wordSize > 0 && wordSize < 30){
                counts[wordSize] += 1;
            }
            else if (wordSize >= 30){
                counts[30] += 1;
            }
        }
        //System.out.println("Num of words with len");
        for (int i = 0; i < counts.length; i++){
            System.out.println("Len: " + i + ", Freq: " + counts[i]);
        }
        return counts;
    }
    
    public int getAdjLength(String word){
        int length = 0;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            //System.out.println(ch);
            if (Character.isLetter(ch)){
                //System.out.println("Got letter");
                length = length + 1;
            }
            else{
                //System.out.println("Got non-letter");
                if (i == 0 || i == word.length() - 1){
                    ;
                }
                else{
                    length = length + 1;
                }
            }
        }
        return length;
    }
    
    public int indexOfMax(int[] values){
        int maxIndex = 0;
        int maxVal = 0;
        for (int i = 0; i < values.length; i++){
            if (maxVal == 0){
                maxVal = values[i];
            }
            else if (maxVal < values[i]){
                maxVal = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public void testGetAdjLength(){
        String word1 = "\"Blue-jeans,\"";
        int adjLen = getAdjLength(word1);
        System.out.println(adjLen);
    }
    
    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        int[] freqs = countWordLengths(fr, counts);
        int maxInd = indexOfMax(freqs);
        System.out.println(maxInd);
    }
    
}
