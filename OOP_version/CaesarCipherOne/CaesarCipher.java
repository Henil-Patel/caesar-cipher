
public class CaesarCipher
{
    
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet = "";
    private int mainKey = 0;
    
    public CaesarCipher(int key)
    {
        if (key != -1){
            shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
            mainKey = key;
        }
    }
    
    public String encrypt(String simpleText){
        String cipherText = "";
        boolean capsLock = false;
        for (int i = 0; i < simpleText.length(); i++){
            char simpleChar = simpleText.charAt(i);
            if (Character.isUpperCase(simpleChar)){
                capsLock = true;
            }
            if (Character.isLowerCase(simpleChar)){
                capsLock = false;
                simpleChar = Character.toUpperCase(simpleChar);
            }
            
            int simpleDex = alphabet.indexOf(simpleChar);
            if (simpleDex != -1){
                char cipherChar = shiftedAlphabet.charAt(simpleDex);
                if (capsLock == false){
                    cipherText = cipherText + Character.toLowerCase(cipherChar);
                }
                else{
                    cipherText = cipherText + cipherChar;
                }
                
            }
            else{
                // Account for the non-alphabet characters
                cipherText = cipherText + simpleChar;
            }
        }
        return cipherText;
    }

    public String decrypt(String cipherText){
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        String simpleText = cc.encrypt(cipherText);
        return simpleText;
    }

}
