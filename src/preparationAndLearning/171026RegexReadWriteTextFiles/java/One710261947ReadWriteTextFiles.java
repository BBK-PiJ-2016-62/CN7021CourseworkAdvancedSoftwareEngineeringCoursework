import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Eric's laptop on 26/10/2017.
 */
public class One710261947ReadWriteTextFiles {

    public static void main(String[] args) {

        Path path = Paths.get("E:\\UEL2017_18\\CN7021AdvancedSoftwareEngineering\\CN7021CourseworkAdvancedSoftwareEngineeringCoursework\\src\\preparationAndLearning\\171026RegexReadWriteTextFiles\\java\\1710281553_4ContactData.txt");
        try { Files.lines(path).forEach(s->formFirstList(s));
        } catch (IOException e) {
            System.out.println(e);
        }
        ArrayList<Contact> contactArrayList=ConstructContactListFromRecord(firstList);
        System.out.println(contactArrayList.get(2).getName());
        System.out.println(contactArrayList.size());

        Path path1 = Paths.get(//"/animals/gorilla.txt");
                /*"E:\\UEL2017_18\\CN7021AdvancedSoftwareEngineering\\CN7021CourseworkAdvancedSoftwareEngineeringCoursework\\src" +
                        "\\preparationAndLearning\\171026RegexReadWriteTextFiles\\java\\gorilla.txt");*/
                "gorilla1.txt");
        List<String> data = firstList;//new ArrayList(Arrays.asList("This example is similar to the file copy example".split(" ")));
        try (BufferedWriter writer = Files.newBufferedWriter(path1,
                Charset.forName("UTF-16"))) {
            for(String s: data){
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    static ArrayList<String> firstList = new ArrayList();
    static void formFirstList(String s){
        firstList.add(s);
    }
    static ArrayList<Contact> contactList=new ArrayList<>();
    static ArrayList<Contact> ConstructContactListFromRecord(ArrayList<String> firstList) {
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        Contact contact = new Contact();
        for (int i = 0; i < firstList.size(); i++) {
            if (i % 5 == 0) {contact.setIndex(firstList.get(i));
            System.out.println(firstList.get(i));}
            if (i % 5 == 1) {contact.setName(firstList.get(i));
            System.out.println(firstList.get(i));}
            if (i % 5 == 2) {contact.setTel(firstList.get(i));
            System.out.println(firstList.get(i));}
            if (i % 5 == 3) {contact.setEmail(firstList.get(i));
            System.out.println(firstList.get(i));}
            if (i % 5 == 4) {
                contact.setDescription(firstList.get(i));
                System.out.println(firstList.get(i));}
                contactArrayList.add(contact);
            }

        return contactArrayList;
        }
}

