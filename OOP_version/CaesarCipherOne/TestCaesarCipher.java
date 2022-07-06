import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
import java.util.Arrays;

public class TestCaesarCipher
{
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public int[] countLetters(String encrypted){
        int[] freqs = new int[26];
        for(int i = 0; i < encrypted.length(); i++){
            char ch = encrypted.charAt(i);
            if (Character.isLetter(ch)){
                int idxLoc = alphabet.indexOf(Character.toUpperCase(ch));
                if (idxLoc != -1){
                    freqs[idxLoc] += 1;
                }
            }
            
        }
        return freqs;
    }
    
    public int maxIndex(int[] counter){
        int maxDex = 0;
        int maxVal = 0;
        for(int i = 0; i < counter.length; i++){
            //System.out.println("Freq val: " + counter[i] + " Max Val: " + maxVal);
            if (maxVal == 0){
                maxVal = counter[i];
                maxDex = i;
            }
            else if (maxVal < counter[i]){
                maxVal = counter[i];
                maxDex = i;
                //System.out.println("Max val " + maxVal + " at " + maxDex + " counter " + i);
            }
        }
        return maxDex;
    }
    
    public int getKey(String s, int assumed){
        int key = 0;
        int[] letterFreqs = countLetters(s);
        int maxDex = maxIndex(letterFreqs);
        System.out.println("Most used letter: " + alphabet.charAt(maxDex) + " at " + maxDex);
        if (maxDex >= assumed){
            key = maxDex - assumed;
        }
        else{
            key = 26 - (assumed - maxDex);
        }
        return key;
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String simpleText = fr.asString();
        System.out.println(simpleText);
        int key = 15;
        CaesarCipher cc = new CaesarCipher(key);
        String cipherText = cc.encrypt(simpleText);
        System.out.println(cipherText);
        //simpleText = cc.decrypt(cipherText);
        //System.out.println(simpleText);
        breakCaesarCipher(cipherText);
    }
    
    public void breakCaesarCipher(String input){
        int key = getKey(input, 4);
        System.out.println("Key: " + key);
        CaesarCipher cc = new CaesarCipher(key);
        String simpleText = cc.decrypt(input);
        System.out.println(simpleText);
    }
}
