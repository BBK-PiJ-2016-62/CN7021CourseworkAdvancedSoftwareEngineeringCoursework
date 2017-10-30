import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Eric's laptop on 28/10/2017.
 */
public class CreationAndAdditionOfContacts{

    public static void main(String[] args) throws IOException{

        //Console console = System.console();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Contact> contactList=new ArrayList<>();
        System.out.println("Please type the number of the tasks listed below you want to perform and then press return.\n" +
                "1: Record new contact(s).");
        int numberSelected = Integer.parseInt(br.readLine());
        //CreationOfContactAndMeeting creationOfContactAndMeeting = new CreationOfContactAndMeeting();
        /*creationOfContactAndMeeting.*/
        if(numberSelected==1)  contactList= extendContactList();
        //temp for checking
        System.out.println(contactList.get(0).getIndex()+" "+contactList.get(0).getName()+" "+contactList.get(0).getTel()+" "+contactList.get(0).getEmail()+contactList.get(0).getDescription());
        ReadWriteContactTextFiles.WritingBackContactListToRecord(contactList);
    }

    static ArrayList<Contact> extendContactList () throws IOException{

        ArrayList<Contact> contactList= ReadWriteContactTextFiles.ConstructContactListFromRecord();
        while(true){
            contactList.add(creatNewContact());
            System.out.println("Any new entry? (Y/N)");
            Console console = System.console();
            String entry=console.readLine();
            if(entry.equals("Y")) continue;
            if(entry.equals("N")) break;
        }
        return contactList;
    }

    //static ArrayList<Contact> contactList= new ArrayList<>();

    static Contact creatNewContact() throws IOException{

        Contact contact = new Contact();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter contact's name\n(Surname first. Only alphabets and spaces allowed. Examples Mandela Nelson Rolihlahla, Kim Dae-jung)");
        String contactName = br.readLine();
        contact.setName(contactName);
        contact.setIndex(produceContactIndex(contactName));
        System.out.println("Enter contact's telephone number");
        contact.setTel(br.readLine());
        System.out.println("Enter contact's email address\n(must contain one and only one at sign(\"@\"))");
        contact.setEmail(br.readLine());
        System.out.println("Enter a brief description of the contact(not exceeding 100 words)");
        contact.setDescription(br.readLine());
        contact.setMeetings(new ArrayList<String>(Arrays.asList("00000000000000")));

        return contact;
    }
    static String produceContactIndex (String nameString)
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyMMddHHmm");
        LocalDateTime ldtNow = LocalDateTime.now();
        String dateTimeNowString= ldtNow.format(f);
        String[] nameInArray = nameString.split(" ");
        if (nameInArray[0].length()==1) nameInArray[0]=nameInArray[0]+"aaaa";
        if (nameInArray[0].length()==2) nameInArray[0]=nameInArray[0]+"aaa";
        if (nameInArray[0].length()==3) nameInArray[0]=nameInArray[0]+"aa";
        if (nameInArray[0].length()==4) nameInArray[0]=nameInArray[0]+"a";
        if (nameInArray[1].length()==1) nameInArray[1]=nameInArray[1]+"a";
        System.out.println(Arrays.toString(nameInArray));  //temp
        String namePartOfTheIndex = nameInArray[0].substring(0,5).toLowerCase()+nameInArray[1].substring(0,2).toLowerCase();
        return namePartOfTheIndex+dateTimeNowString;
    }
    /*static void constructContactList (Contact contact){

        contactList.add(contact);
    }*/ //this method can be deleted
}
