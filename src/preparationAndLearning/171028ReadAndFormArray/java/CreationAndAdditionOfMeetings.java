import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Eric's laptop on 29/10/2017.
 */
public class CreationAndAdditionOfMeetings {

    public static void main(String[] args){
        //System.out.println(productionOfMeetingIndex("17/11/23/18/25","20/00"));
        Console console = System.console();
        ArrayList<Meeting> meetingList=new ArrayList<>();
        System.out.println("Please type the number of the tasks listed below you want to perform and then press return.\n" +
                "2: Record new meeting(s).");
        int numberSelected = Integer.parseInt(console.readLine());
        //CreationOfContactAndMeeting creationOfContactAndMeeting = new CreationOfContactAndMeeting();
        /*creationOfContactAndMeeting.*/
        if(numberSelected==2)  meetingList= extendMeetingList();
        for (Meeting m: meetingList)
        {
            System.out.println(m.getMeetingIndex());
            System.out.println(m.getMeetingStartDateTime());
            System.out.println(m.getMeetingEndTime());
            System.out.println(m.getMeetingVenue());
            System.out.println(m.getMeetingDescription());
            System.out.println(m.getMeetingParticipants().toString().replace(",","")
                                                            .replace("[","").replace("]","")
                                                            .trim());

        }
    }

    static ArrayList<Meeting> extendMeetingList(){

        ArrayList<Meeting> meetingList= new ArrayList<>();
        while(true){
            meetingList.add(creatNewMeeting());
            System.out.println("Any new meeting? (Y/N)");
            Console console = System.console();
            String entry=console.readLine();
            if(entry.equals("Y")) continue;
            if(entry.equals("N")) break;
        }
        return meetingList;
    }

    static Meeting creatNewMeeting(){

        Meeting meeting = new Meeting();
        Console console = System.console();
        System.out.println("Enter the date and the starting time of the meeting\n(Format: yy/MM/dd/HH/mm. Example: 18/04/16/16/00)");
        String meetingStartDateTime = console.readLine();
        meeting.setMeetingStartDateTime(meetingStartDateTime);
        System.out.println("Enter the ending time of the meeting\n(Format: HH/mm. Example: 18/30)");
        String meetingEndTime = console.readLine();
        meeting.setMeetingEndTime(meetingEndTime);
        meeting.setMeetingIndex(productionOfMeetingIndex(meetingStartDateTime, meetingEndTime));
        System.out.println("Enter venue of the meeting");
        meeting.setMeetingVenue(console.readLine());
        System.out.println("Enter a brief description of the contact(not exceeding 100 words)");
        meeting.setMeetingDescription(console.readLine());
        System.out.println("Enter participants of the meeting\n(Surname First. Separating each name with a slash. Example:\n" +
                "May Boris/Corbyn Treresa/Johnson Jeremy");
        meeting.setMeetingParticipants(setMeetingParticipants(console.readLine()));
        //meeting.setMeetings(new ArrayList<String>(Arrays.asList("00000000000000")));

        return meeting;
    }

    static String productionOfMeetingIndex (String meetingStartDateTime, String meetingEndTime)
    {
        StringBuilder meetingIndex1 = new StringBuilder();
        String meetingIndex = meetingIndex1.append(meetingStartDateTime.substring(0,2)+meetingStartDateTime.substring(3,5)
                +meetingStartDateTime.substring(6,8)+meetingStartDateTime.substring(9,11)
                +meetingStartDateTime.substring(12,14)+meetingEndTime.substring(0,2)+meetingEndTime.substring(3,5))
                .toString();
        return meetingIndex;
    }

    static ArrayList<String> setMeetingParticipants(String s){
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(s.split("/")));
        return arrayList;
    }
}
