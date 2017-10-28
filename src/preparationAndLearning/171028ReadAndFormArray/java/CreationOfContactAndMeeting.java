import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Eric's laptop on 28/10/2017.
 */
public class CreationOfContactAndMeeting{

    public static void main(String[] args){

        Console console = System.console();
        System.out.println("Please type the number of the tasks listed below you want to perform and then press return.\n" +
                "1: Record new contact(s).");
        int numberSelected = Integer.parseInt(console.readLine());
        CreationOfContactAndMeeting creationOfContactAndMeeting = new CreationOfContactAndMeeting();
        creationOfContactAndMeeting.entries (numberSelected);
        System.out.println(contactList.get(2).getDescription());
    }

    static ArrayList<Contact> contactList=new ArrayList<>();

    Contact creatNewContact(){

        Contact contact = new Contact();
        Console console = System.console();
        System.out.println("Enter contact's name\n(Surname first. Only alphabets and spaces allowed. Examples Mandela Nelson Rolihlahla, Kim Dae-jung");
        String contactName = console.readLine();
        contact.setName(contactName);
        contact.setIndex(produceContactIndex(contactName));
        System.out.println("Enter contact's telephone number");
        contact.setTel(console.readLine());
        System.out.println("Enter contact's email address\n(must contain one and only one at sign(\"@\"))");
        contact.setEmail(console.readLine());
        System.out.println("Enter a brief description of the contact(not exceeding 100 words)");
        contact.setDescription(console.readLine());

        return contact;
    }
    String produceContactIndex (String nameString)
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
    void constructContactList (Contact contact){

        contactList.add(contact);
    }
    void entries (int i){

        if(i==1){
            while(true){
                constructContactList(creatNewContact());
                System.out.println("Any new entry? (Y/N)");
                Console console = System.console();
                String entry=console.readLine();
                if(entry.equals("Y")) continue;
                if(entry.equals("N")) break;
            }
        }
    }
}
