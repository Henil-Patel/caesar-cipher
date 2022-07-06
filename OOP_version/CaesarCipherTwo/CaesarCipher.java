public class CaesarCipher
{
    // instance variables - replace the example below with your own
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet1 = "";
    private String shiftedAlphabet2 = "";
    private int mainKey1 = 0;
    private int mainKey2 = 0;

    public CaesarCipher(int key1, int key2)
    {
        // initialise instance variables
        if (key1 != -1 && key2 != -1){
            shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
            shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
            mainKey1 = key1;
            mainKey2 = key2;
        }
    }
    
    public String encryptTwoKeys(String simpleText){
        CaesarCipherOne cc1 = new CaesarCipherOne(mainKey1);
        CaesarCipherOne cc2 = new CaesarCipherOne(mainKey2);
        String cipherText = "";
        String cipherTextChar = "";
        for (int i = 0; i < simpleText.length(); i++){
            String simpleTextChar = simpleText.substring(i, i + 1);
            if (i % 2 == 0){
                cipherTextChar = cc1.encrypt(simpleTextChar);
                
            }
            else{
                cipherTextChar = cc2.encrypt(simpleTextChar);
            }
            cipherText = cipherText + cipherTextChar;
        }
        return cipherText;
    }
    
    public String decryptTwoKeys(String cipherText){
        String simpleText = "";
        CaesarCipherOne cc1 = new CaesarCipherOne(mainKey1);
        CaesarCipherOne cc2 = new CaesarCipherOne(mainKey2);
        for (int i = 0 ; i < cipherText.length(); i++){
            String cipherTextChar = cipherText.substring(i, i + 1);
            if (i % 2 == 0){
                simpleText = simpleText + cc1.decrypt(cipherTextChar);
            }
            else{
                simpleText = simpleText + cc2.decrypt(cipherTextChar);
            }
        }
        return simpleText;
    }
    
}
