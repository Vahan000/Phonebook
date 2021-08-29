import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Contact{

    private long phoneNumber;
    private String firstName;
    private String lastName;
    private static ArrayList<Contact> contacts = new ArrayList<>();

    Contact(long phoneNumber, String firstName, String lastName){
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        contacts.add(this);
    }

    long getPhoneNumber(){
        return this.phoneNumber;
    }

    void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    String getFirstName(){
        return this.firstName;
    }

    void setFirstName(String firstName){
        this.firstName = firstName;
    }

    String getLastName(){
        return this.lastName;
    }

    void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Phone number: " + this.phoneNumber + ", First name: " + this.firstName+ ", Last name: " + this.lastName+ ", ID: " + contacts.indexOf(this) + ".";

    }

    static void addContact(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of your wished contact: ");
        long phoneNumber = input.nextLong();

        Scanner secondInput = new Scanner(System.in);
        System.out.print("Please enter the firstname of your wished contact: ");
        String firstname = secondInput.nextLine();

        Scanner thirdInput = new Scanner(System.in);
        System.out.print("Please enter the lastname of your wished contact: ");
        String lastname = thirdInput.nextLine();

        Contact contact = new Contact(phoneNumber, firstname, lastname);

    }

    static void displayContact(){

        for(Contact element: contacts){
            System.out.println(element);
        }
    }

    static void removeContact(){
        Scanner fourthInput = new Scanner(System.in);
        System.out.print("Please enter the ID of the contact you would wish to remove: ");
        int index = fourthInput.nextInt();

        contacts.remove(index);

    }

    static Contact getContact(int index){
        return contacts.get(index);
    }

    static void editContact(){
        displayContact();

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the ID of the contact you would wish to edit: ");
        int index = input.nextInt();

        Scanner secondInput = new Scanner(System.in);
        System.out.print("Please enter the option of the contact you would want to edit (phone number, first name or last name): ");
        String response = secondInput.nextLine();

        switch(response.toLowerCase()){
            case "first name":
                Scanner thirdInput = new Scanner(System.in);
                System.out.print("Please enter the new first name: ");
                String newFirstName = thirdInput.nextLine();
                getContact(index).firstName = newFirstName;
                break;
            case "last name":
                Scanner fourthInput = new Scanner(System.in);
                System.out.print("Please enter the new last name: ");
                String newLastName = fourthInput.nextLine();
                getContact(index).lastName = newLastName;
                break;
            case "phone number":
                Scanner fifthInput = new Scanner(System.in);
                System.out.print("Please enter the new phone number: ");
                int newPhoneNumber = fifthInput.nextInt();
                getContact(index).phoneNumber = newPhoneNumber;
                break;

        }
    }

    static void displayProgram(){

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tYou are welcome to the Phonebook Application.\n ");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String secondResponse = " ";

        do{

            System.out.println("If you want to add a contact please type - add");
            System.out.println("If you want to remove a contact please type - remove");
            System.out.println("If you want to display a contact please type - display");
            System.out.println("If you want to edit a contact please type - edit\n");

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("Your wished operation: ");

            Scanner input = new Scanner (System.in);
            String response = input.nextLine();

            switch(response.toLowerCase()){
                case "edit":
                    if(contacts.size()==0){
                        System.out.println("Sorry but the contact list is empty. Please add a contact before editing.\n");
                    }
                    else{
                        editContact();
                        System.out.println();
                    }
                    break;
                case "add":
                    addContact();
                    System.out.println();
                    break;
                case "remove":
                    if(contacts.size()==0){
                        System.out.println("Sorry but the contact list is empty. Please add a contact before removing.\n");
                    }
                    else{
                        displayContact();
                        System.out.println();
                        removeContact();
                        System.out.println();
                    }
                    break;
                case "display":
                    if(contacts.size()==0){
                        System.out.println("Sorry but the contact list is empty. Please add a contact before displaying.\n");
                    }
                    else{
                        displayContact();
                        System.out.println();
                    }
                    break;
            }

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Do you want to continue? Yes or No? ");
            System.out.print("Your answer: ");

            Scanner secondInput = new Scanner (System.in);
            secondResponse = secondInput.nextLine();
            System.out.println();
        }while(secondResponse.equalsIgnoreCase("yes"));


    }



}
