import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Eric's laptop on 30/10/2017.
 */
public class One710301355CheckingExistenceAndCreationOfContact {

    public static void main(String[] args) throws IOException
    {
        ArrayList<Contact> contactList = ReadWriteContactTextFiles.ConstructContactListFromRecord();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name: ");
        String nameEntered = br.readLine();
        int numberOfSameNameContact = 0;
        for(Contact c: contactList){
            if(c.getName().matches(nameEntered)){
                System.out.println(c.getName());
                System.out.println(c.getTel());
                System.out.println(c.getDescription());
                System.out.println(c.getDescription());
            }
        }
        if (numberOfSameNameContact != 0){
            System.out.println("Details of contact(s) already in the contact list are shown above. " +
                    "You want to create a new contact? (Y/N)");
            String createNewContactOrNot = br.readLine();
            if (createNewContactOrNot == "Y") contactList = CreationAndAdditionOfContacts.extendContactList();
        }
    }
}
