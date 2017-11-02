import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Eric's laptop on 30/10/2017.
 */
public class One710301557BufferedReader {

    public static void main(String[] args) throws IOException{

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter YY");
        String createNewContactOrNot = br1.readLine();
        System.out.println(createNewContactOrNot);
        if (createNewContactOrNot.equals("YY")) System.out.println("Y is here");
        System.out.println("New contact \"nameEntered\" added");  //just for learning using \ as the escape symbol
        String s="abc"; int i=45;
        System.out.printf("The string is %s and the integer is %d", s,i);
    }
}
