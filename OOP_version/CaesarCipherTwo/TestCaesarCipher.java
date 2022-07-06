import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
public class TestCaesarCipher
{
    private String plainText = "Just a test string with lots of eeeeeeeeeeeeeeeees";
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String halfOfString(String message, int start){
        String halfString = "";
        for (int i = start; i < message.length(); i+=2){
            halfString = halfString + Character.toString(message.charAt(i));
        }
        return halfString;
    }
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
        //System.out.println("Most used letter: " + alphabet.charAt(maxDex) + " at " + maxDex);
        if (maxDex >= assumed){
            key = maxDex - assumed;
        }
        else{
            key = 26 - (assumed - maxDex);
        }
        return key;
    }
    
    
    public void simpleTests(){
        int key1 = 14;
        int key2 = 24;
        //FileResource fr = new FileResource();
        //String simpleText = fr.asString();
        CaesarCipher cc = new CaesarCipher(key1, key2);
        //String cipherText = cc.encryptTwoKeys(simpleText);
        String cipherText = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        //System.out.println(cipherText);
        String simpleText = cc.decryptTwoKeys(cipherText);
        System.out.println(simpleText); 
        //breakCaesarCipher(cipherText);
        
    }
    
    public void breakCaller(){
        FileResource fr = new FileResource();
        String cipherText = fr.asString();
        //String cipherText = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        breakCaesarCipher(cipherText);
    }
    
    public void breakCaesarCipher(String cipherText){
        String zerothAltSeq = halfOfString(cipherText, 0);
        String firstAltSeq = halfOfString(cipherText, 1);
        String simpleText = "";
        
        int key1 = getKey(zerothAltSeq, 4);
        int key2 = getKey(firstAltSeq, 4);
        
        System.out.println(key1);
        System.out.println(key2);
        
        CaesarCipher cc = new CaesarCipher(key1, key2);
        simpleText = cc.decryptTwoKeys(cipherText);
        System.out.println(simpleText);
        
    }
}
