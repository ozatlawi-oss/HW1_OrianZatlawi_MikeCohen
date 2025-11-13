
public class SMS extends Message implements IDigital
{
    String phoneNumberSender;
    String phoneNumberReceiver;
    public SMS(String sender, String content,String phoneNumberSender,String phoneNumberReceiver){
        super(sender,content);
        if(checkPhoneNumber(phoneNumberSender) ||checkPhoneNumber(phoneNumberReceiver))
        {
        throw  new IllegalArgumentException("Invalid phone number format must be 05X-XXX-XXXX");
        }
        this.phoneNumberSender=phoneNumberSender;
        this.phoneNumberReceiver=phoneNumberReceiver;

    }
    private boolean checkPhoneNumber(String phoneNumber)
    {
            return !(phoneNumber.substring(0,1).equals("05")) || phoneNumber.length()!=10 ;
    }
}
