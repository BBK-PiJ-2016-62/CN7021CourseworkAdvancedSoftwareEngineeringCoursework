import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Eric's laptop on 30/10/2017.
 */
public class One710301142ReadingFromConsole {

    public static void main(String[] args)
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a string: ");
        try {
            String s = br.readLine();
            System.out.println("You entered "+s);

        }catch(IOException e){
            System.out.println(e);
        }

    }
}
