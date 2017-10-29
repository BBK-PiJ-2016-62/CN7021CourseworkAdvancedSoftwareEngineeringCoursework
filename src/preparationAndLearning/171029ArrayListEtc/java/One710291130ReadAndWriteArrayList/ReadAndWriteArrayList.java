package One710291130ReadAndWriteArrayList;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Eric's laptop on 29/10/2017.
 */
public class ReadAndWriteArrayList {

    public static void main(String[] args) {
        String[] strings = "There,    are,  ,       two main ways to get a collection".split("(\\s|\\s+,+)+");  //regex here not good
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        String formattedArrayListString = arrayList.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
        System.out.println(formattedArrayListString);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("One710291130ReadAndWriteArrayList.txt"),
                Charset.forName("UTF-16"))) {
            writer.write(formattedArrayListString);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("0{14}");
    }
}

/*E:\UEL2017_18\CN7021AdvancedSoftwareEngineering\CN7021CourseworkAdvancedSoftwareEngineeringCoursework\src\preparationAndLearning\171029ArrayListEtc\java\One710291130ReadAndWriteArrayList\ReadAndWriteArrayList.java*/