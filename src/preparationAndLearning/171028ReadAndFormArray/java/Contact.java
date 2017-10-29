import java.util.ArrayList;

/**
 * Created by Eric's laptop on 28/10/2017.
 */
public class Contact {
    private String contactName;
    private String contactIndex;
    private String contactTel;
    private String contactEmail;
    private String contactDescription;
    private ArrayList<String> contactMeetings;

    public void setName (String contactName){
        this.contactName = contactName;
    }
    public void setIndex (String contactIndex){
        this.contactIndex = contactIndex;
    }
    public void setTel (String contactTel){
        this.contactTel = contactTel;
    }
    public void setEmail (String contactEmail){this.contactEmail = contactEmail;}
    public void setDescription (String contactDescription){
        this.contactDescription = contactDescription;
    }
    public void setMeeting (String contactMeeting){contactMeetings.add(contactMeeting);}
    public void setMeetings (ArrayList<String> contactMeetings){this.contactMeetings=contactMeetings;}

    public String getName (){return this.contactName;}
    public String getIndex (){return this.contactIndex;}
    public String getTel (){return this.contactTel;}
    public String getEmail (){
        return this.contactEmail;
    }
    public String getDescription(){return this.contactDescription;}
    public ArrayList<String> getMeetings(){return this.contactMeetings;};
}