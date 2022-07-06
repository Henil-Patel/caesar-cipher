import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
import java.util.Arrays;
public class CaesarBreaker
{
    /**
     * MAIN METHODS 
     */
    
    private String plainText = "Just a test string with lots of eeeeeeeeeeeeeeeees";
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
    
    public String decrypt(String message){
        CaesarCipher cc = new CaesarCipher();
        int dist2Key = getKey(message, 4);
        String decryptedMessage = cc.encrypt(message, 26 - dist2Key);
        return decryptedMessage;
    }
    
    public String halfOfString(String message, int start){
        String halfString = "";
        for (int i = start; i < message.length(); i+=2){
            halfString = halfString + Character.toString(message.charAt(i));
        }
        return halfString;
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
    
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String zerothAltSeq = halfOfString(encrypted, 0);
        String firstAltSeq = halfOfString(encrypted, 1);
        String decrypted = "";
        //System.out.println(zerothAltSeq);
        //System.out.println(firstAltSeq);
        
        int key1 = getKey(zerothAltSeq, 4);
        int key2 = getKey(firstAltSeq, 4);
        
        
        System.out.println("Sequence 0 encrypted with: " + key1);
        System.out.println("Sequence 1 encrypted with: " + key2);
        decrypted = cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
        return decrypted;
    }
    /**
     * TESTERS
     */
    public void testCountLetters(){
        String message = "FedEx Sux Ants Frm Anthills Bt Delivrs Pkgs Fst";
        int[] freqs = countLetters(message);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < freqs.length; i++){
            System.out.println(freqs[i] + " " + alphabet.charAt(i));
        }
        int maxFreq = maxIndex(freqs);
        System.out.println("Letter " + alphabet.charAt(maxFreq) + " occurred " + freqs[maxFreq] + " times.");
    }
    
    public void testDecrypt(){
        //int[] freqs = countLetters(in);
        //int maxFreq = maxIndex(freqs);
        //System.out.println(maxFreq);
        String out = decrypt(plainText);
        System.out.println(out);
    }
    
    public void testHalfOfString(){
        int start = 0;
        String halfMessage = halfOfString(plainText, start);
        System.out.println(halfMessage);
    }
    
    public void testDecryptTwoKeys(){
        //CaesarCipher cc = new CaesarCipher();
        //int key1 = 23;
        //int key2 = 2;
        //String cipherText = cc.encryptTwoKeys(message, key1, key2);
        //System.out.println(cipherText);
        //String cipherText = "Top ncmy qkff vi vguv vbg ycpx";
        String cipherText = "";
        FileResource fr = new FileResource();
        cipherText = fr.asString();
        //System.out.println(cipherText);
        String decryptedText = decryptTwoKeys(cipherText);
        System.out.println(decryptedText);
    }
    
}
