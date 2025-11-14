import java.util.Date;

public class BoardMessage extends Message
{

PriorityType priorityType;

    /**
     *
     * @param sender sender the name of the sender(e.g. "Orian","Mike")
     * @param content the content of the message
     * @param sendDate the date of the sent message (yyyy-MM-dd)
     * @param priorityType the priority of the message(Regular OR Urgent)
     */
    public BoardMessage(String sender, String content, Date sendDate, PriorityType priorityType) {
    super(sender,content,sendDate);
    this.priorityType = priorityType; //איזה אספקשן אפשר לזרוק לזה?

}

    /**
     *
     * @param sender sender the name of the sender(e.g. "Orian","Mike")
     * @param content the content of the message
     * @ sendDate are set in fathers builder for current computer's date
     * @ priorityType is set to REGULAR
     */
    public  BoardMessage(String sender,String content){
    super(sender,content);
    this.priorityType=PriorityType.REGULAR;
}
@Override
public String toString()
{
    return "{MessagePriority: " + this.priorityType+ "}"+ " " +super.toString();
}

    /**
     * method we asked to add
     * this method escalates from REGULAR--->URGENT
     * if the priority set to URGENT it does nothing
     */
    public void escalate(){
        if(this.priorityType==PriorityType.REGULAR){
            this.priorityType=PriorityType.URGENT;
            System.out.println("The message priority is URGENT");
        }
        else System.out.println("The message priority is already URGENT ");

}

    @Override
    /**
     * creats a preview of the message
     * if shorter than 15 char will present the string if longer then 15 chars will display first 15 chars
     */
    public String generatePreview() {
        if(content.length()>15)
        {
            return "[Board] "+sender+":"+content.substring(0,15)+"...\n";
        }
        else return "[Board] "+sender+":"+content+"...\n";
    }
}
