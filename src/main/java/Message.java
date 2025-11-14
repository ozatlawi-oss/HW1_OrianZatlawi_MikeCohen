import java.util.ArrayList;
import java.util.Date;

public abstract class Message {
    String sender;
    String content;
    Date sendDate;

    /**
     *
     * @param sender the name of the sender(e.g. "Orian","Mike")
     * @param content the content of the message
     * @param sendDate the date of the sent message (yyyy-MM-dd)
     * @throws IllegalArgumentException if the sender/content/sendDate are empty
     */
    public Message(String sender, String content, Date sendDate)
    {
        if (sender.isEmpty() || content.isEmpty() || sendDate == null) {
            throw new IllegalArgumentException("sender/content/date cannot be empty");
        }
        this.sender = sender;
        this.content = content;
        this.sendDate = sendDate;
    }

    /**
     *dose the same as the first builder but date doesn't need to be provided
     * uses current date of local machine as default
     */
    public Message(String sender, String content)
    {
        if (sender.isEmpty() || content.isEmpty()) {
            throw new IllegalArgumentException("sender/content cannot be empty");
        }
        this.sender = sender;
        this.content = content;
        this.sendDate = new Date();
    }
    @Override
    public String toString()
    {
        return "{SenderName: " + sender + ", Content: " + content + ", SendDate(yy-MM-dd: " + sendDate + "}" +"\n";
    }

    /**
     *
     * @param words dynamic Array of words
     * @return true if words contains one common word with content
     */
    public boolean find(ArrayList<String> words){
        return words.contains(content);

    }

    /**
     * Self added method according to the request in the task
     * @return if a message contains more then 500 chars it considered big
     */
    public boolean bigMessage(){
        return content.length() >= 500;
    }

    public abstract String generatePreview();
}
