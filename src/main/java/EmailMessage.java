import java.io.Serializable;
import java.util.Date;

public class EmailMessage extends Message implements IDigital {
    String subject;

    /**
     *
     * @param sender the name of the sender(e.g. "Orian","Mike")
     * @param content the content of the message
     * @param sendDate the date of the sent message (yyyy-MM-dd)
     * @param subject the subject of the email
     * @throws IllegalArgumentException subject cannot be null
     */
    public  EmailMessage(String sender, String content, Date sendDate,String subject)
{
    super(sender,content,sendDate);
    if(subject.isEmpty()) {
        throw new IllegalArgumentException("subject cannot be empty");
    }
    else  {
        this.subject = subject;
    }
}
public EmailMessage(String sender, String content,String subject)
{
    super(sender,content);
     if(subject.isEmpty()) {
        throw new IllegalArgumentException("subject cannot be empty");
}
       else{this.subject = subject;}
}
@Override
    public String toString(){
        return "{subject: "+subject+ "}"+" "+super.toString();
}
@Override
public String printCommunicationMethod(){
        return "Sent via Email";
}
@Override

public String generatePreview() {
    return "[Email] Subject: " + subject + " | " + "From: " + sender + "\n";
}
//public void addAttachment(File file){
//        יש עניין בסעיפים g/h תחת 5
    // נראה שצריך שדה שקשור לFile אבל בתרשים זה לא מצויין צריך לבדוק
//}

}
