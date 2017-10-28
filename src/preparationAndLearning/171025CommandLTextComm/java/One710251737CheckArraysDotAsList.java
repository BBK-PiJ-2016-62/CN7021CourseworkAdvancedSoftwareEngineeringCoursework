import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Eric's laptop on 25/10/2017.
 */
public class One710251737CheckArraysDotAsList {

    public static void main(String[] args)
    {
        String[] strings = {"How", "are", "you"};
        List<String> list=new ArrayList<>(Arrays.asList(strings));

        //String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        String[][] data = new String[5][5];
        data[0] = new String[]{"a", "b"};
        data[0] = new String[]{"c", "d"};
        data[0] = new String[]{"e", "f"};

        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //Stream<String>, GOOD!
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

        Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);

		/*Stream<String> stream = Arrays.stream(data)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()));*/

    }
}
