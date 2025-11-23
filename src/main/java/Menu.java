import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



/*
* util class to print out Menu functions and execute them via Message classes
* */
public  class Menu {

    /**
     * Prints main menu
     */
    public static void printMenu() {
        System.out.println("please select an option:\n" +
                "1)Add Message\n" +
                "2)Delete Message\n" +
                "3)Print all Messages\n" +
                "4)Show number of Messages that contain words\n" +
                "5)print digital Messages\n" +
                "6)Get Status(seen or not)\n" +
                "7)EXIT");
    }

    /**
     *
     * @param i uses input
     * @return  if user input is correct
     */
    public static boolean checkInput(int i) {
        return i >= 1 && i <= 7;
    }
    public static boolean checkInputSubMenu(int i){
        return i >= 1 && i <= 3;
    }

    /**
     * submenu for option one
     */

    public static void addMessage() {
        System.out.println("""
                1)Add emailMessage\s
                2)Add BoardMessage
                3)Add SMS""");
    }

    /**
     * mthood that returns EmailMessage
     *
     * @return new EmailMessage
     */
    public static EmailMessage createEmailMessage() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<File> files = new ArrayList<>();
        String fileName;
        String fileType;
        String sender, content, subject, userDate;
        String selection = "Y";
        Date date;

        while (selection.equals("Y")) {
            System.out.println("add Attachment? Y/N...");
            selection = scanner.nextLine();
            selection = selection.toUpperCase();
            if (selection.equals("Y")) {
                System.out.println("Please enter the file name");
                fileName = scanner.nextLine();
                System.out.println("Please enter the file type");
                fileType = scanner.nextLine();
                files.add((new File(fileName, fileType)));

            }
        }
        System.out.println("Enter Subject");
        subject = scanner.nextLine();
        System.out.println("Enter content");
        content = scanner.nextLine();
        System.out.println("Enter Sender");
        sender = scanner.nextLine();
        date=getDate();

        return new EmailMessage(sender, content, date, subject, files);
    }

    /**
     *
     * @return boardMessage
     */
    public static BoardMessage createBoardMessage() {
        Scanner scanner = new Scanner(System.in);
        String sender, content;
        int priority;
        PriorityType priorityType;
        Date date;
        System.out.println("Enter Sender");
        sender = scanner.nextLine();
        System.out.println("Enter content");
        content = scanner.nextLine();
        date=getDate();
        System.out.println("Enter Priority Type 0=REGULAR, 1=URGENT");
        priority=scanner.nextInt();
        if(priority!=0|| priority!=1){
            System.out.println("Invalid Priority Type,Defaulting To Regular");
            priorityType=PriorityType.REGULAR;
        }
        else priorityType=PriorityType.values()[priority];
        return new BoardMessage(sender,content,date,priorityType);

    }

    /**
     *
     * @return SMS message
     */
    public static SMS createSMS() {
        String phoneNumberSender;
        String phoneNumberReceiver;
        String sender,content;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sender");
        sender = scanner.nextLine();
        System.out.println("Enter content");
        content = scanner.nextLine();
        System.out.println("Enter Sender number");
        phoneNumberSender = scanner.nextLine();
        System.out.println("Enter Receiver number");
        phoneNumberReceiver = scanner.nextLine();
        return new SMS(sender,content,phoneNumberSender,phoneNumberReceiver);
        }

        public static void deleteMessage(ArrayList<Message> messages) {
        if(messages.size()>0){
            messages.remove(messages.size()-1);
            return;//remove last message from message array
        }
        System.out.println("There is no message to delete");



        }
        public static void printAllMessages(ArrayList<Message> messages) {
            if (messages.size() < 0) {
                System.out.println("There are no messages to delete");
                return;
            }
            for (Message message : messages) {
                System.out.println(message.toString());


            }
        }
        public static int words(ArrayList<Message> messages) {
        int wordcnt=0;
        for(Message message:messages){
            if(!message.content.isEmpty()){
                wordcnt++;
            }
        }
        return wordcnt;
        }
        public static void printDigitalMessages(ArrayList<Message> messages) {
        if(messages.size()<0){
            System.out.println("There are no messages to delete");
            return;
        }
        for(Message message:messages){
            if(message instanceof IDigital){
                System.out.println(message.toString());
            }
        }
        }
       public static void getSeenStatus(ArrayList<Message> messages) {
           for(Message message:messages){
               System.out.println("seen: "+message.getStatus());
           }
       }


    private static Date getDate(){
        Scanner scanner = new Scanner(System.in);
        String selection,userDate;
        Date date;
        System.out.println("Use current date? Y/N.....");
        selection = scanner.nextLine();
        selection = selection.toUpperCase();

        if (selection.equals("Y")) {
            date = new Date();
            return date;
        }
        else  {
            System.out.println("Enter date in the next format dd/MM/yyyy");
            userDate = scanner.nextLine();
            try {
                date = new Date(userDate);
            } catch (Exception e) {
                System.out.println("Invalid date format defaulting to current date");
                date = new Date();
            }
            return date;
        }
    }

    }









