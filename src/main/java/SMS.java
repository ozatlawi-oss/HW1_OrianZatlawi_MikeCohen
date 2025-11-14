
public class SMS extends Message implements IDigital
{
    String phoneNumberSender;
    String phoneNumberReceiver;
    public SMS(String sender, String content,String phoneNumberSender,String phoneNumberReceiver){
        super(sender,content);
        if(checkPhoneNumber(phoneNumberSender) ||checkPhoneNumber(phoneNumberReceiver))
        {
        throw  new IllegalArgumentException("Invalid phone number format must be 05X-XXX-XXXX and conation only numbers!");
        }
        this.phoneNumberSender=phoneNumberSender;
        this.phoneNumberReceiver=phoneNumberReceiver;

    }

    /**
     *  a method to check if phone number is valid
     * @param phoneNumber the phone number the user entered
     * @return will return true if phone number is the wrong format
     */
    private boolean checkPhoneNumber(String phoneNumber)
    {
            return !(phoneNumber.substring(0,2).equals("05")) || phoneNumber.length()!=10 || !phoneNumber.matches("\\d+");
    }
    @Override
    public String printCommunicationMethod(){
        return "SMS";
    }
@Override
    public String generatePreview(){
        if(content.length()>15)
        return "You have incoming message from: "+sender+"-"+phoneNumberSender+"\n"+content.substring(0,15)+"......\n";
        return "You have incoming message from: "+sender+"-"+phoneNumberSender+"\n"+content+"......\n"; //returns the entire massage because it shorter then 15
    }

    @Override
    public String toString() {
        return "sender: "+sender+"-"+phoneNumberSender+"\n"+
                "recipient: "+phoneNumberReceiver+"\n";
    }
}
