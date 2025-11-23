import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public  class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Message> messages = new ArrayList<>();
        BoardMessage boardMessage=new BoardMessage("David","I look for brand new car");
        EmailMessage emailMessage=new EmailMessage("Messi","Can i join you again?","Hello Barcelona FC!");
        messages.add(boardMessage);
        messages.add(emailMessage);
        int userInput=-1;
        while(userInput!=7){
            Menu.printMenu();
            System.out.println("Enter Selection");
           try{
               userInput=input.nextInt();
           }
           catch(InputMismatchException e){
               System.out.println("Invalid Selection please enter number 1-7");
               input.nextLine();
               continue;
           }

           if(!Menu.checkInput(userInput)){
               System.out.println("Wrong INPUT! Valid input 1-7");
               continue;
           }
           switch(userInput){
               case 1:
                   Menu.addMessage();
                   userInput=input.nextInt();
                   while(!Menu.checkInputSubMenu(userInput)){
                       System.out.println("Wrong INPUT! Valid input 1-3");
                       userInput=input.nextInt();
                   }
                   switch(userInput){
                       case 1:
                           messages.add(Menu.createEmailMessage());
                           break;
                       case 2:
                           messages.add(Menu.createBoardMessage());
                           break;
                       case 3:
                           messages.add(Menu.createSMS());
                           break;
                   }
                   break;
               case 2:
                   Menu.deleteMessage(messages);
                   break;
               case 3:
                   Menu.printAllMessages(messages);
                   break;
               case 4:
                   System.out.println(Menu.words(messages));
                   break;
               case 5:
                   Menu.printDigitalMessages(messages);
                   break;
               case 6:
                   Menu.getSeenStatus(messages);
                   break;
               case 7:
                   System.out.println("Exiting...");
                   break;


           }

        }
        System.exit(0);

    }
}