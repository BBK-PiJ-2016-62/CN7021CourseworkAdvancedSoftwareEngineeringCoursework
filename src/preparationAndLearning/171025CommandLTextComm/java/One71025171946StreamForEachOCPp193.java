import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Created by Eric's laptop on 25/10/2017.
 */
public class One71025171946StreamForEachOCPp193 {

    public static void main(String[] args)
    {
        TreeSet<String> strArrayLt =new TreeSet<>();
        Stream<String> s= Stream.of("Monkey", "Gorilla", "Bonobo");
        s.forEach(l->strArrayLt.add(l));
        System.out.println(strArrayLt);
    }
}
