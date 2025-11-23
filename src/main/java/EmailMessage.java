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
     * @param subject the subject of the email
     * @throws IllegalArgumentException subject cannot be null
     */
    /**
     *
     * @param sender
     * @param content
     * @param sendDate
     * @param subject
     * @param attachments
     */

    /**A constructor that accepts all the fields of the class */
    public  EmailMessage(String sender, String content, Date sendDate,String subject,ArrayList<File> attachments)
    {
    super(sender,content,sendDate);
    setSubject(subject);
        this.attachments = new ArrayList<>();
        this.attachments.addAll(attachments);
    }
    /**A constructor that accepts sender content subject */
    public EmailMessage(String sender, String content,String subject)
    {
        super(sender,content);
        setSubject(subject);
        this.attachments = new ArrayList<>();
    }

    /**
     * @param subject sets the subject
     */
    public void setSubject(String subject) {
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException("Subject cannot be empty");
        this.subject = subject;

    }

    /**
     *
     * provides inforamation about the Email message
     */
    @Override
    public String toString(){
        return "{subject: "+subject+ "}"+" "+super.toString()+ ", Attachments: "+attachments+"}";
}

    /**
     *
     * @return the communication method
     */
    @Override
public String printCommunicationMethod(){
        return "Sent via Email";
}

    /**
     *
     * @return shortened string of the message containing the sender's name and the first 15 characters of the message content.
     */
    @Override
public String generatePreview() {
    return "[Email] Subject: " + subject + " | " + "From: " + sender + "\n";
}

    /**
     *
     * @param method that accepts a File as a parameter and adds it to the dynamic array of files.
     */
    public void addAttachment(File file){
        attachments.add(file);

    }

    /**
     * Deletes all files from the dynamic array that match the file received as a parameter. If this file does not exist in the array at all, an AttachmentException should be thrown with an appropriate message.
     * @param file
     * @throws AttachmentException
     */
    public void removeAttachment(File file) throws AttachmentException {
   boolean removed = false;
   for(int i =0;i<attachments.size();i++){
       if(attachments.get(i).equals(file)){
           attachments.remove(i);
           removed = true;
           i--;
       }
   }
   if(!removed){
       throw new AttachmentException();
   }
}

}
