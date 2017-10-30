import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Eric's laptop on 30/10/2017.
 */
public class ReadWriteMeetingTextFiles {

    public static void main (String[] args){

        ArrayList<Meeting> meetingArrayList=ConstructMeetingListFromTextFile();
        WritingBackMeetingListToRecord(meetingArrayList);

    }

    public static ArrayList<Contact> meetingArrayList=new ArrayList<>();

    public static void WritingBackMeetingListToRecord(ArrayList<Meeting> meetingArrayList) {

        Path path = Paths.get("gorilla2.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path,
                Charset.forName("UTF-16"))) {
            for(Meeting m: meetingArrayList){
                writer.write(m.getMeetingIndex());
                writer.newLine();
                writer.write(m.getMeetingStartDateTime());
                writer.newLine();
                writer.write(m.getMeetingEndTime());
                writer.newLine();
                writer.write(m.getMeetingVenue());
                writer.newLine();
                writer.write(m.getMeetingDescription());
                writer.newLine();
                writer.write(m.getMeetingParticipants().toString()
                        .replace("[", "")
                        .replace("]", "")
                        .trim());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //static ArrayList<Meeting> meetingList=new ArrayList<>();

    static ArrayList<Meeting> ConstructMeetingListFromTextFile() {

        ArrayList<String> firstList = new ArrayList();

        Path path = Paths.get("1710301019MeetingData.txt");
        try { Files.lines(path).forEach(s->firstList.add(s));
        } catch (IOException e) {
            System.out.println(e);
        }

        ArrayList<Meeting> meetingArrayList = new ArrayList<>();

        for(int i=0; i<firstList.size();i++) {
            if (i % 6 == 0) meetingArrayList.add(new Meeting());
            if (i % 6 == 0) meetingArrayList.get(i / 6).setMeetingIndex(firstList.get(i));
            if (i % 6 == 1) meetingArrayList.get(i / 6).setMeetingStartDateTime(firstList.get(i));
            if (i % 6 == 2) meetingArrayList.get(i / 6).setMeetingEndTime(firstList.get(i));
            if (i % 6 == 3) meetingArrayList.get(i / 6).setMeetingVenue(firstList.get(i));
            if (i % 6 == 4) meetingArrayList.get(i / 6).setMeetingDescription(firstList.get(i));
            if (i % 6 == 5) {String[] firstListArray=firstList.get(i).split(", ");
                meetingArrayList.get(i/6).setMeetingParticipants(new ArrayList<String>(Arrays.asList(firstListArray)));}
        }
        //temp for checking
        for (Meeting m: meetingArrayList)
        {
            System.out.println(m.getMeetingIndex()+" "+m.getMeetingStartDateTime()+" "
                    +m.getMeetingEndTime()+" "+m.getMeetingVenue()+" "
                    +m.getMeetingDescription()+" "
                    +m.getMeetingParticipants().toString()
                                                    .replace("[","")
                                                    .replace("]",""));
        }

        return meetingArrayList;
    }
}

