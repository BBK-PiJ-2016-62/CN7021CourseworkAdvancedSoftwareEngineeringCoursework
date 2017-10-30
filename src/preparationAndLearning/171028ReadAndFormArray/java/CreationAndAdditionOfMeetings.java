import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Eric's laptop on 29/10/2017.
 */
public class CreationAndAdditionOfMeetings {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Meeting> meetingList=new ArrayList<>();
        System.out.println("Please type the number of the tasks listed below you want to perform and then press return.\n" +
                "2: Record new meeting(s)");
        int numberSelected = Integer.parseInt(br.readLine());
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
            System.out.println(m.getMeetingParticipants().toString()
                                                            .replace("[","")
                                                            .replace("]","")
                                                            .trim());

        }
        ReadWriteMeetingTextFiles.WritingBackMeetingListToRecord(meetingList);
    }

    static ArrayList<Meeting> extendMeetingList() throws IOException{

        ArrayList<Meeting> meetingList=ReadWriteMeetingTextFiles.ConstructMeetingListFromTextFile();
        while(true){
            meetingList.add(creatNewMeeting());
            System.out.println("Any new meeting? (Y/N)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String entry=br.readLine();
            if(entry.equals("Y")) continue;
            if(entry.equals("N")) break;
        }
        return meetingList;
    }

    static Meeting creatNewMeeting() throws IOException {

        Meeting meeting = new Meeting();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader console = new InputStreamReader(System.in);
        System.out.println("Enter the date and the starting time of the meeting\n(Format: yy/MM/dd/HH/mm. Example: 18/04/16/16/00)");
        String meetingStartDateTime = br.readLine();
        meeting.setMeetingStartDateTime(meetingStartDateTime);
        System.out.println("Enter the ending time of the meeting\n(Format: HH/mm. Example: 18/30)");
        String meetingEndTime = br.readLine();
        meeting.setMeetingEndTime(meetingEndTime);
        meeting.setMeetingIndex(productionOfMeetingIndex(meetingStartDateTime, meetingEndTime));
        System.out.println("Enter venue of the meeting");
        meeting.setMeetingVenue(br.readLine());
        System.out.println("Enter a brief description of the meeting(not exceeding 100 words)");
        meeting.setMeetingDescription(br.readLine());
        System.out.println("Enter participants of the meeting\n(Surname First. Separating each name with a slash. Example:\n" +
                "(May Boris/Corbyn Treresa/Johnson Jeremy)");
        meeting.setMeetingParticipants(setMeetingParticipants(br.readLine()));
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
