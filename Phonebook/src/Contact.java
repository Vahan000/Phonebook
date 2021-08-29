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
        System.out.println("Please enter the ID of the contact you would wish to remove: ");
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



}
