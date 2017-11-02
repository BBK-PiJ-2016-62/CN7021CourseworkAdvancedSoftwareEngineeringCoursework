import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Eric's laptop on 30/10/2017.
 */
public class One710301355CheckingExistenceAndCreationOfContact {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name: ");
        String nameEntered = br.readLine();
        checkWhetherNameAlreadyInContactList(nameEntered);
    }

    public static void checkWhetherNameAlreadyInContactList(String nameEntered) throws IOException
    {
        ArrayList<Contact> contactList = ReadWriteContactTextFiles.ConstructContactListFromRecord();
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Enter the name: ");
        //String nameEntered = br.readLine();
        int numberOfSameNameContact = 0;
        for(Contact c: contactList){
            ArrayList<String> sameNameContactList = new ArrayList<>();
            if(c.getName().matches(nameEntered)){
                String sameNameContact=c.getIndex();
                sameNameContactList.add(sameNameContact);
                System.out.println(sameNameContact);
                System.out.println(c.getName());
                System.out.println(c.getTel());
                System.out.println(c.getDescription());
                System.out.println(c.getMeetings().toString().replace("[","").replace("]",""));
                numberOfSameNameContact++;
            }
        }
        if (numberOfSameNameContact != 0){
            System.out.printf("\nContact(s) which has/have the same name (%s) is/are already in the contact list(Shown above). " +
                    "Do you want to create a new contact with this name? (Y/N)\n", nameEntered);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String createNewContactOrNot = br.readLine();
            if (createNewContactOrNot.equals("Y")){
                contactList = CreationAndAdditionOfContacts.extendContactList();
                ReadWriteContactTextFiles.WritingBackContactListToRecord(contactList);
                System.out.printf("New contact %s added\n", nameEntered);
            }
        }
        //ReadWriteContactTextFiles.WritingBackContactListToRecord(contactList);

    }
}
