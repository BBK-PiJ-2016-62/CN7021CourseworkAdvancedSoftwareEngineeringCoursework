import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Eric's laptop on 26/10/2017.
 */
public class ReadWriteContactTextFiles {

    public static void main (String[] args){

        ArrayList<Contact> contactArrayList=ConstructContactListFromRecord();
        WritingBackContactListToRecord(contactArrayList);

    }

    public static ArrayList<Contact> contactArrayList=new ArrayList<>();

    public static void WritingBackContactListToRecord(ArrayList<Contact> contactArrayList) {

        Path path1 = Paths.get("ContactListOutput.txt");
        //List<String> data = firstList;//new ArrayList(Arrays.asList("This example is similar to the file copy example".split(" ")));
        try (BufferedWriter writer = Files.newBufferedWriter(path1,
                Charset.forName("UTF-16"))) {
            for(Contact c: contactArrayList){
                writer.write(c.getIndex());
                writer.newLine();
                writer.write(c.getName());
                writer.newLine();
                writer.write(c.getTel());
                writer.newLine();
                writer.write(c.getEmail());
                writer.newLine();
                writer.write(c.getDescription());
                writer.newLine();
                writer.write(c.getMeetings().toString().replace(",","")
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")
                        .trim());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static ArrayList<Contact> contactList=new ArrayList<>();

    static ArrayList<Contact> ConstructContactListFromRecord() {

        ArrayList<String> firstList = new ArrayList();

        Path path = Paths.get("1710281553_4ContactData.txt");
        try { Files.lines(path).forEach(s->firstList.add(s));
        } catch (IOException e) {
            System.out.println(e);
        }

        ArrayList<Contact> contactArrayList = new ArrayList<>();

        for(int i=0; i<firstList.size();i++) {
            if (i % 6 == 0) contactArrayList.add(new Contact());
            if (i % 6 == 0) contactArrayList.get(i / 6).setIndex(firstList.get(i));
            if (i % 6 == 1) contactArrayList.get(i / 6).setName(firstList.get(i));
            if (i % 6 == 2) contactArrayList.get(i / 6).setTel(firstList.get(i));
            if (i % 6 == 3) contactArrayList.get(i / 6).setEmail(firstList.get(i));
            if (i % 6 == 4) contactArrayList.get(i / 6).setDescription(firstList.get(i));
            if (i % 6 == 5) {String[] firstListArray=firstList.get(i).split("//s");
                contactArrayList.get(i/6).setMeetings(new ArrayList<String>(Arrays.asList(firstListArray)));}
        }
        //temp for checking
        /*for (Contact c: contactArrayList)
        {
            System.out.println(c.getIndex()+" "+c.getName()+" "+c.getEmail()+" "+c.getDescription());
        }*/

        return contactArrayList;
    }
}

