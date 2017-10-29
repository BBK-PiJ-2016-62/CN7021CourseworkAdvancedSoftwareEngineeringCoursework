import java.util.ArrayList;

/**
 * Created by Eric's laptop on 29/10/2017.
 */
public class Meeting {

    private String meetingStartDateTime;
    private String meetingEndTime;
    private String meetingIndex;
    private String meetingVenue;
    private String meetingDescription;
    private ArrayList<String> meetingParticipants;

    public void setMeetingStartDateTime(String meetingStartDateTime) {this.meetingStartDateTime = meetingStartDateTime;}
    public void setMeetingEndTime(String meetingEndTime) {this.meetingEndTime = meetingEndTime;}
    public void setMeetingIndex(String meetingEndTime) {this.meetingIndex = meetingIndex;}
    public void setMeetingVenue(String meetingVenue) {this.meetingVenue = meetingVenue;}
    public void setMeetingDescription(String meetingDescription) {this.meetingDescription = meetingDescription;}
    public void setMeetingparticipant(String meetingparticipant) {this.meetingParticipants.add(meetingparticipant);}
    public void setMeetingParticipants(ArrayList<String> meetingParticipants){this.meetingParticipants = meetingParticipants;}

    public String getMeetingStartDateTime (){return this.meetingStartDateTime;}
    public String getMeetingEndTime (){return this.meetingEndTime;}
    public String getMeetingIndex (){return this.meetingIndex;}
    public String getMeetingVenue (){return this.meetingVenue;}
    public String getMeetingDescription (){return this.meetingDescription;}
    public ArrayList<String> getMeetingParticipants (){return this.meetingParticipants;}

}
