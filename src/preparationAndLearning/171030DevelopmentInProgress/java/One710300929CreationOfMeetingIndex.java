/**
 * Created by Eric's laptop on 30/10/2017.
 */
public class One710300929CreationOfMeetingIndex {

    public static void main(String[] args){
        String meetingIndex=productionOfMeetingIndex("17/12/10/18/00","20/30");
        System.out.println(meetingIndex);
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
}
