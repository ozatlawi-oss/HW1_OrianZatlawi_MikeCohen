import java.util.ArrayList;

public  class Main{
    public static void main(String[] args) {
        ArrayList<Message> messages = new ArrayList<>();
        BoardMessage boardMessage=new BoardMessage("David","I look for brand new car");
        EmailMessage emailMessage=new EmailMessage("Messi","Can i join you again?","Hello Barcelona FC!");
        messages.add(boardMessage);
        messages.add(emailMessage);

    }
}