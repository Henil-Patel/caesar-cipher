
/**
 * Write a description of class PracticeQuiz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PracticeQuiz
{
    private String word; 
     private String phrase; 
     public PracticeQuiz(int number, String w) { 	
          word = w; 	
          phrase = mystery(number, w);          
     }   
     private String mystery(int num, String s) {  	
          String answer = "";  	
          for (int k=0; k<num; k++) {     	
               answer = answer + s;  	
          }  	
          return answer; 
     } 

     public String toString() { 	
          return phrase + " is " + word + " repeated";
     }
}

