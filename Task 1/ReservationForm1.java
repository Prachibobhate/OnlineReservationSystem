import java.util.*;

public class ReservationForm1 {

    public static BasicDetails ReservationForm() {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("                     <<<<<<<<<<< Welcome To Reservation Form >>>>>>>>>>>> ");
        System.out.println("----------------------------------------------------------------------------------------------------");

        BasicDetails bd = new BasicDetails();
        System.out.println("Please Fill Basic Details:>>>>");
        System.out.print("Enter Your Name: ");
        bd.name = in.next();
        System.out.print("Enter Your Phone Number: ");
        bd.phoneNumber = in.next();
        System.out.print("Enter Your EmailId: ");
        bd.emailId = in.next();
        System.out.print("Enter Your Age: ");
        bd.age = in.nextInt();

        while (true) {
            System.out.print("Gender: 1.Male 2.Female\nSelect Gender: ");
            int n = in.nextInt();
            if (n == 1) {
                bd.gender = "MALE";
                break;
            } else if (n == 2) {
                bd.gender = "FEMALE";
                break;
            } else {
                System.out.println("Please Enter a Valid Option");
            }
        }

        // Train selection
        Hashtable<Integer, String> trains = new Hashtable<>();
        trains.put(1, "Shabari Express");
        trains.put(2, "Chennai Express");
        trains.put(3, "Krishna Express");
        trains.put(4, "Godavari Express");
        trains.put(5, "Pune Express");

        while (true) {
            System.out.print("Enter Train Number: ");
            bd.trainNumber = in.nextInt();
            if (trains.containsKey(bd.trainNumber)) {
                bd.trainName = trains.get(bd.trainNumber);
                System.out.println("Your Train Name is: " + bd.trainName);
                break;
            }
            System.out.println("Please Enter a Valid Train Number");
        }

        System.out.print("Available Classes: 1.EC 2.1AC 3.2AC 4.3AC 5.FC 6.CC 7.SL 8.2S\nSelect Your Class: ");
        bd.trainClass = in.nextInt();

        System.out.print("Date Of Journey (yyyy-mm-dd): ");
        bd.dateOfJourney = in.next();
        System.out.print("From: ");
        bd.from = in.next();
        System.out.print("To: ");
        bd.to = in.next();

        System.out.println("\nPlease PRESS ENTER to Insert the data into your journey Details");

        return bd;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> loginIds = new ArrayList<>();  // Available login list
        Hashtable<String, Integer> loginData = new Hashtable<>();  // Password & login data
        Hashtable<String, BasicDetails> userDetails = new Hashtable<>();  // User Details

        boolean running = true;  // Variable to control the loop

        while (running) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("            <<<<<<<<<<<<<<<<< WELCOME TO LOGIN FORM >>>>>>>>>>>>>>>>>> ");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("             1.Create Account\n             2.Login\nSelect Option to login: ");
            int choice = in.nextInt();

            if (choice == 2) {
                // Login process
                System.out.print("Enter a valid Login id: ");
                String loginId = in.next();
                if (loginIds.contains(loginId)) {
                    System.out.print("Enter a valid Login Password: ");
                    int password = in.nextInt();
                    if (loginData.get(loginId).equals(password)) {
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("            <<<<<<<<<<<<< WELCOME TO USER INTERFACE >>>>>>>>>>>>>>>> ");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("             1.Reservation Form\n             2.Cancellation Form");
                        System.out.print("Enter User Choice: ");
                        int userChoice = in.nextInt();

                        if (userChoice == 1) {
                            userDetails.put(loginId + password, ReservationForm());
                        } else if (userChoice == 2) {
                            // Cancellation Form
                            String userKey = loginId + password;  // Key used to store and retrieve user trip details
                            if (userDetails.containsKey(userKey)) {
                                BasicDetails bd = userDetails.get(userKey);  // Retrieve stored details
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("<<<<<<<<<<<<<<<<<<<< Your Journey Trip Details >>>>>>>>>>>>>>>>>>>>>>");
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("Passenger Name: " + bd.name);
                                System.out.println("Passenger Phone Number: " + bd.phoneNumber);
                                System.out.println("Passenger Age: " + bd.age);
                                System.out.println("Passenger Gender: " + bd.gender);
                                System.out.println("Train Number: " + bd.trainNumber);
                                System.out.println("Train Class: " + bd.trainClass);
                                System.out.println("Date Of Journey: " + bd.dateOfJourney);
                                System.out.println("From: " + bd.from);
                                System.out.println("To: " + bd.to);
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("Do you want to cancel the trip?\n1.Yes\n2.No");
                                int cancelChoice = in.nextInt();
                                if (cancelChoice == 1) {
                                    userDetails.remove(userKey);  // Remove the trip details from the hashtable
                                    System.out.println("Journey successfully canceled.");
                                } else {
                                    System.out.println("Cancellation aborted.");
                                }
                            } else {
                                System.out.println("You Do Not Have Any Active Trips.");
                            }
                        }
                    } else {
                        System.out.println("Please Enter Correct Password");
                    }
                } else {
                    System.out.println("UserId is not available. Please Enter a Valid Id or Create an Account.");
                }
            } else if (choice == 1) {
                // Account creation process
                System.out.print("UserId: ");
                String id = in.next();
                System.out.print("Password: ");
                int pass = in.nextInt();
                loginIds.add(id);
                loginData.put(id, pass);
                System.out.println("Your Account Has Been Created Successfully.");
            } else {
                System.out.println("Please Enter a Valid Option.");
            }

            // Prompt user whether they want to continue or exit
            System.out.println("Do you want to continue?\n1.Yes\n2.No");
            int continueChoice = in.nextInt();
            if (continueChoice == 2) {
                running = false;  // Exit the loop
                System.out.println("Exiting... Thank you for using the system!");
            }
        }
    }
}

// BasicDetails Class to hold user information
class BasicDetails {
    public String name, emailId, phoneNumber, gender, dateOfJourney, from, to;
    public int trainNumber, age, trainClass;
    public String trainName;
}
