
/**
 * Write a description of class WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
    /**
     *      METHODS
     */
    public boolean isVowel(char ch){
        if ((ch == 'a' || ch == 'A') ||
            (ch == 'e' || ch == 'E') ||
            (ch == 'i' || ch == 'I') ||
            (ch == 'o' || ch == 'O') ||
            (ch == 'u' || ch == 'U')){
                return true;
            }
        else{
            return false;
        }
    }
    
    public String replaceVowels(String phrase, char ch){
        String repPhrase = "";
        for (int i = 0; i < phrase.length(); i++){
            char currChar = phrase.charAt(i);
            if (isVowel(currChar) == true){
                repPhrase = repPhrase + "*";
            }
            else{
                repPhrase = repPhrase + currChar;
            }
        }
        return repPhrase;
    }
    
    public String emphasize(String phrase, char ch){
        char asterisk = '*';
        char plus = '+';
        String empString = "";
        for (int i = 0; i < phrase.length(); i++){
            char currChar = phrase.charAt(i);
            if (currChar == Character.toUpperCase(ch)||
                currChar == Character.toLowerCase(ch)){
                if (i % 2 == 0){
                    // even index , odd location
                    empString = empString + "*";
                }
                else{
                    // odd
                    empString = empString + "+";
                }
            }
            else{
                empString = empString + currChar;
            }
        }
        return empString;
    }
    
    /**
     *      TESTERS
     */
    public void testIsVowel(){
        boolean output = isVowel('f');
        System.out.println(output);
    }
    
    public void testReplaceVowels(){
        String phrase = "Hello World";
        char ch = '*';
        String outPhrase = replaceVowels(phrase, ch);
        System.out.println(outPhrase);
    }
    
    public void testEmphasize(){
        String p1 = "dna ctgaaactga";
        String p2 = "Mary Bella Abracadabra";
        char ch = 'a';
        String out1 = emphasize(p1, ch);
        String out2 = emphasize(p2, ch);
        System.out.println(out1);
        System.out.println(out2);
    }
    
    /**
     *      MAIN
     */
    public void main(String args[]){
        WordPlay wp = new WordPlay();
    }
}
