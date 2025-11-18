import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class EmailMessage extends Message implements IDigital {
     private String subject;
     private ArrayList<File> attachments;
     // הוספתי תכונה
    /**
     *
     * @param sender the name of the sender(e.g. "Orian","Mike")
     * @param content the content of the message
     * @param sendDate the date of the sent message (yyyy-MM-dd)
     * @param category the category of the message
     * @param subject the subject of the email
     * @throws IllegalArgumentException subject cannot be null
     */
    public  EmailMessage(String sender, String content, Date sendDate, String category,String subject , ArrayList<File> attachments)
    {
    super(sender,content,sendDate,category);
    setSubject(subject);
        this.attachments = new ArrayList<>();
    }
    public EmailMessage(String sender, String content,String subject)
    {
        super(sender,content);
        setSubject(subject);
    }
    // כדי למנוע חזרתיות של כתיבה יצרתי סט בשביל הסבגקט
    public void setSubject(String subject) {
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException("Subject cannot be empty");
        this.subject = subject;
    }

@Override
    public String toString(){
        return "{subject: "+subject+ "}"+" "+super.toString()+ ", Attachments: "+attachments+"}";
}
@Override
public String printCommunicationMethod(){
        return "Sent via Email";
}
@Override
public String generatePreview() {
    return "[Email] Subject: " + subject + " | " + "From: " + sender + "\n";
}
    // הוספתי את הפעולות
public void addAttachment(File file){
        attachments.add(file);
}
public void removeAttachment(File file){
   boolean removed = false;
   for(int i =0;i<attachments.size();i++){
       if(attachments.get(i).equals(file)){
           attachments.remove(i);
           removed = true;
           i--;
       }
   }
   if(!removed){
       throw new IllegalArgumentException("Attachment not found");
   }
}

}
