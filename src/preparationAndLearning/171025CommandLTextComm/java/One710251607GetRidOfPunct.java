/**
 * Created by Eric's laptop on 25/10/2017.
 */
public class One710251607GetRidOfPunct {

    public static void main(String[] args){

        String word = "!Words word! ";
        word = word.replaceAll("\\s*\\p{Punct}+\\s*$", "");
        System.out.println(word); // => !Words word

    }
}
