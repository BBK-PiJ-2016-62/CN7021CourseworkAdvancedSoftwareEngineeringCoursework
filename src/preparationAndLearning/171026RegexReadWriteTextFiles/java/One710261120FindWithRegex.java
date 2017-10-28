import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Eric's laptop on 26/10/2017.
 */
public class One710261120FindWithRegex {

    public static void main(String[] args) {

        String person001Name = "Chiu Chung Hoi";
        String person002Name = "Wu A";
        String meeting001BeginTime = "17/12/28/15/20";
        String meeting001EndTime = "17/40";
        String meeting002BeginTime = "17/11/24/09/50";
        String meeting002EndTime = "12/00";

        String person001Index = productionOfPersonIndex(person001Name);
        String person002Index = productionOfPersonIndex(person002Name);
        String meeting001Index = productionOfMeetingIndex(meeting001BeginTime, meeting001EndTime);
        String meeting002Index = productionOfMeetingIndex(meeting002BeginTime, meeting002EndTime);
        System.out.println(person001Index+"\t"+person002Index);
        System.out.println(meeting001Index+"\t"+meeting002Index);
        System.out.println(meetingOrPerson(person001Index));
        System.out.println(meetingOrPerson(person001Index));
        System.out.println(meetingOrPerson(meeting001Index));
        System.out.println(meetingOrPerson(meeting002Index));
    }

    static String meetingOrPerson(String s) {
        Pattern person = Pattern.compile("\\$[a-z]{6}[0-9]{10}");
        Pattern meeting = Pattern.compile("\\$[0-9]{10}-[0-9]{4}");
        if (meeting.matcher(s).matches()) return "meeting";
        else if(person.matcher(s).matches()) return "person";
        else return "neither a meeting nor a person";
    }

    static String productionOfMeetingIndex (String startTime, String endTime)
    {
        StringBuilder meetingIndex = new StringBuilder();
        meetingIndex.append("$"+startTime.substring(0,2)+startTime.substring(3,5)+startTime.substring(6,8)+startTime.substring(9,11)
                                +startTime.substring(12,14)+"-"+endTime.substring(0,2)+endTime.substring(3,5));
        String meetingIndex1=meetingIndex.toString();
        return meetingIndex1;
    }
    static String productionOfPersonIndex (String nameString)
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyMMddhhmm");
        LocalDateTime ldtNow = LocalDateTime.now();
        String dateTimeNowString= ldtNow.format(f);
        String[] nameInArray = nameString.split(" ");
        if (nameInArray[0].length()==1) nameInArray[0]=nameInArray[0]+"aaa";
        if (nameInArray[0].length()==2) nameInArray[0]=nameInArray[0]+"aa";
        if (nameInArray[1].length()==1) nameInArray[1]=nameInArray[1]+"a";
        String namePartOfTheIndex = nameInArray[0].substring(0,4).toLowerCase()+nameInArray[1].substring(0,2).toLowerCase();
        return "$"+namePartOfTheIndex+dateTimeNowString;
    }
}

class Persons {
        private String name;
        private String description;

        public void setName (String name){
            this.name = name;
        }
        public void setDescription (String description){
            this.description = description;
        }
        public String getName (){
            return this.name;
        }
        public String getDescription(){
            return this.description;
        }
}
class Meetings {
    private String beginDateTime;
    private String endTime;
    private String description;
    private ArrayList<String[]>  participentsNameAndIndex;

}
//"\\s*\\p{Punct}+\\s*$", ""