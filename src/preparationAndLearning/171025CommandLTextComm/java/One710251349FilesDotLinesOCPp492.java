
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Eric's laptop on 25/10/2017.
 */
public class One710251349FilesDotLinesOCPp492 {

    public static void main(String[] args)
    {
        Console console = System.console();
        while(true) {
            System.out.println("Please enter the path of the text file you want it to be put into a string arraylist.");
            String pathString=console.readLine();
            Path path = Paths.get(/*"/fish/sharks.log"*/pathString);
            try {
                Files.lines(path).forEach(System.out::println);
                Files.lines(path).forEach(ReadingLinesFromATextFile::readingLinesFromATextFile);
                break;
            } catch (IOException e) {
                // Handle file I/O exception...
                System.out.println("Entry has error or no such path. Please check the correctness of" +
                        " the path you entered.");
            }
        }
        System.out.println();
        for(String s: arrayList)
        {
            System.out.println(s);
        }
        TreeSet<String> treeSet = treeSetOfWordsOfAStringArrayListWithPunctuationsCleared(arrayList);
        System.out.println(treeSet);
    }
    static ArrayList<String> arrayList = new ArrayList<>();
    static class ReadingLinesFromATextFile{
        static void readingLinesFromATextFile(String s){
            arrayList.add(s);
        }
    }

    static TreeSet<String> treeSetOfWordsOfAStringArrayListWithPunctuationsCleared(ArrayList<String> strAryList){

        TreeSet<String> treeSet= new TreeSet<>();
        //ArrayList<String> aryL= new ArrayList<>();
        int i=0;
        for(String s: strAryList){
            String[] strings1 = s.split(" ");
            for (String s1: strings1){
                treeSet.add(s1.replaceAll("\\s*\\p{Punct}+\\s*$", ""));
            }
            //strings[i]  = strings1;
            //aryL.add(strings1);
            //i++;
        }
        /*for(int ii=0; ii<i; ii++) {
            for (String s : strings[ii]) {
                s=s.replaceAll("\\s*\\p{Punct}+\\s*$", "");
                treeSet.add(s);
            }
        }*/

        //Stream<String[]> temp = Stream.of(aryL);
        //Stream<String> stream=temp.flatMap(l->Arrays.stream(l));//stringStream.flatMap(l->Arrays.stream(l)).forEach(w->treeSet.add(w));
        //stream.forEach(w->treeSet.add(w));
        return treeSet;


    }

}
//E:\UEL2017_18\CN7021AdvancedSoftwareEngineering\CN7021CourseworkAdvancedSoftwareEngineeringCoursework\textFormatFiles\Sonnet18.txt
