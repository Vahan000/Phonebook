import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description: This class is designed for presenting the Phonebook Application. We have a simple approach for
 *              characterizing our contacts. We describe them with first names, last names, and phone numbers.
 *              We also have an array list where we keep our contacts.
 *
 * @author Vahan_Grigoryan
 */

public class Contact {

    private long phoneNumber;
    private String firstName;
    private String lastName;
    private static ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * Description: This is the constructor of the Contact class where we initialize the fields of our class.
     *              It has private access because we do not want the user to create objects of our class directly
     *              and outside of the Contact class.
     *
     * @param phoneNumber
     * @param firstName
     * @param lastName
     */

    private Contact(long phoneNumber, String firstName, String lastName) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    /**
     * Description: As we follow the rules of encapsulation our fields are private, but we have setters and getters for setting
     *              and returning their values (starting from lines 43-65).
     */

    long getPhoneNumber() {
        return this.phoneNumber;
    }

    void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getFirstName() {
        return this.firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Description: This is the toString method which we have inherited from the Object class and gave our own
     *              implementation by overriding.
     */

    @Override
    public String toString() {
        return "Phone number: " + this.phoneNumber + ", First name: " + this.firstName + ", Last name: " + this.lastName + ", ID: " + contacts.indexOf(this) + ".";

    }

    /**
     * Description: This method takes the values from the user then it creates a contact object and adds that contact
     *              into our array list (contacts).
     */

    private static void addContact() {
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
        contacts.add(contact);
    }


    /**
     * Description: Simple method which shows the elements of our array list and of course in this case the elements
     *              are the contact/contacts which we had created.
     */

    private static void displayContact() {
        for (Contact element : contacts) {
            System.out.println(element);
        }
    }


    /**
     * Description: This method takes from the user the ID of the contact as input and removes that contact with a
     *              corresponding ID.
     */

    private static void removeContact() {
        Scanner fourthInput = new Scanner(System.in);
        System.out.print("Please enter the ID of the contact you would wish to remove: ");
        int index = fourthInput.nextInt();

        contacts.remove(index);

    }


    /**
     * Description: This simple method gets the index of the contact and returns details about the contact.
     */

    private static Contact getContact(int index) {
        return contacts.get(index);
    }


    /**
     * Description: This method is designed for changing the value/values of the contact which ID we will get as the
     *              second step. At first this method calls the displayContact() method (lines 105-109) because the user
     *              should understand what he/she has in their list of contacts. After that we get the ID as input of
     *              the contact which the user wants to edit and also the field's name which should be edited. Then for
     *              each case, we organize the corresponding actions which are at all just getting the new value and
     *              changing it with the old one.
     */

    private static void editContact() {
        displayContact();

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the ID of the contact you would wish to edit: ");
        int index = input.nextInt();

        Scanner secondInput = new Scanner(System.in);
        System.out.print("Please enter the option of the contact you would want to edit (phone number, first name or last name): ");
        String response = secondInput.nextLine();

        switch (response.toLowerCase()) {
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
                long newPhoneNumber = fifthInput.nextLong();
                getContact(index).phoneNumber = newPhoneNumber;
                break;

        }
    }


    /**
     * Description: This is our general method which organizes the whole workflow of the program. At first its welcome
     *              message is displayed on screen. After that the program asks which operation the user would like to do.
     *              After which we collect the response of the user and in help of the "switch-case" we start to invoke
     *              the corresponding operation. Finally, the program asks whether the user wants to continue the workflow
     *              (just in case the user wants to add a new contact or do some other operations) or not. If the user
     *              wants to continue everything starts from the beginning if not the program just ends.
     *
     *
     */

    static void displayProgram() {

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tYou are welcome to the Phonebook Application.\n ");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String secondResponse = "yes";

        do {

            System.out.println("If you want to add a contact please type - add");
            System.out.println("If you want to remove a contact please type - remove");
            System.out.println("If you want to display a contact please type - display");
            System.out.println("If you want to edit a contact please type - edit\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("Your wished operation: ");

            Scanner input = new Scanner(System.in);
            String response = input.nextLine();

            switch (response.toLowerCase()) {
                case "edit":
                    if (contacts.size() == 0) {
                        System.out.println("Sorry but the contact list is empty. Please add a contact before editing.\n");
                    } else {
                        editContact();
                        System.out.println();
                    }
                    break;
                case "add":
                    addContact();
                    System.out.println();
                    break;
                case "remove":
                    if (contacts.size() == 0) {
                        System.out.println("Sorry but the contact list is empty. Please add a contact before removing.\n");
                    } else {
                        displayContact();
                        System.out.println();
                        removeContact();
                        System.out.println();
                    }
                    break;
                case "display":
                    if (contacts.size() == 0) {
                        System.out.println("Sorry but the contact list is empty. Please add a contact before displaying.\n");
                    } else {
                        displayContact();
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("\nIncorrect input. Please try again.\n");


            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (response.equalsIgnoreCase("add")) {
                System.out.println("Your wished contact was successfully added. \n");
            }
            if (response.equalsIgnoreCase("add") || response.equalsIgnoreCase("remove")
                || response.equalsIgnoreCase("display") || response.equalsIgnoreCase("edit")){

                System.out.println("Do you want to continue? Yes or No? ");
                System.out.print("Your answer: ");

                Scanner secondInput = new Scanner(System.in);
                secondResponse = secondInput.nextLine();
                System.out.println();
            }
        } while (secondResponse.equalsIgnoreCase("yes"));


    }


}
