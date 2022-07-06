import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

public class CaesarCipher
{
    /**
     *      HELPERS 
     */
    String fixedAlphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String adjustedAlphabet = "";
    
    public String createAdjustedAlphabet(int key){
        adjustedAlphabet = fixedAlphabet.substring(key) + fixedAlphabet.substring(0, key);
        return adjustedAlphabet;
    }
    
    public String encrypt(String input, int key){
        adjustedAlphabet = createAdjustedAlphabet(key);
        String encryptedMessage = "";
        boolean capsLock = false;
        for (int i = 0; i < input.length(); i++){
            char simpleText = input.charAt(i);
            if (Character.isUpperCase(simpleText)){
                capsLock = true;
            }
            if (Character.isLowerCase(simpleText)){
                capsLock = false;
                simpleText = Character.toUpperCase(simpleText);
            }
            
            int indexSimpleText = fixedAlphabet.indexOf(simpleText);
            if (indexSimpleText != -1){
                char cipherText = adjustedAlphabet.charAt(indexSimpleText);
                if (capsLock == false){
                    encryptedMessage = encryptedMessage + Character.toLowerCase(cipherText);
                }
                else{
                    encryptedMessage = encryptedMessage + cipherText;
                }
            }
            else{
                // Account for non-alphabet characters
                encryptedMessage = encryptedMessage + simpleText;  
            }
        }
        return encryptedMessage;
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        String cipherText = "";
        // String type of an individual character
        String cipherTextChar = "";
        for (int i = 0; i < input.length(); i++){
            String simpleTextChar = input.substring(i, i + 1);
            if (i % 2 == 0){
                // Use key1
                cipherTextChar = encrypt(simpleTextChar, key1);
            }
            else{
                //Use key2
                cipherTextChar = encrypt(simpleTextChar, key2);
            }
            cipherText = cipherText + cipherTextChar;
        }
        return cipherText;
    }
    
    /**
     *      TESTERS
     */
    public void testCreateAdjustedAlphabet(){
        adjustedAlphabet = createAdjustedAlphabet(23);
        System.out.println(fixedAlphabet);
        System.out.println(adjustedAlphabet);
    }
    
    public void testEncrypt(){
        FileResource fr = new FileResource();
        int key = 15;
        String simpleText = fr.asString();
        System.out.println("Original: " + simpleText);
        String cipherText = encrypt(simpleText, key);
        System.out.println("Encrypted: " + cipherText);
    }

    public void testEncryptTwoKeys(){
        FileResource fr = new FileResource();
        int key1 = 8;
        int key2 = 21;
        String simpleText = fr.asString();
        System.out.println("Original: " + simpleText);
        String cipherText = encryptTwoKeys(simpleText,key1,key2);
        System.out.println("Encrypted: " + cipherText);
    }
}
//Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!
//Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!
