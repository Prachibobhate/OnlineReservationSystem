**Reservation System**
**Overview**
This is a simple Java-based console application that simulates a train ticket reservation system. It allows users to:

1) Create an account and login**
2) Fill in a reservation form with personal details
3) Select a train and class
4) Review and cancel reservations

**Features**
1) User Login System: Users can create accounts and login using their credentials.
2) Reservation Form: Users can fill out personal details and select a train for their journey.
3) Cancellation Form: Users can review and cancel their journey if needed.
   
**Prerequisites**
1) Java Development Kit (JDK) 8 or higher.
2) Visual Studio Code (or any Java-supporting IDE).

**How to Run**
1) Clone the repository:
git clone https://github.com/your-username/reservation-system.git
cd reservation-system

2) Open the project in Visual Studio Code:
Make sure you have the Java Extension Pack installed in VS Code.

3) Compile and Run:
Open the integrated terminal in VS Code.
**Compile the program:**
javac ReservationForm1.java
**Run the program:**
java ReservationForm1

**Usage**
Creating an Account: Users can create a new account by providing a username and password.
Logging In: After account creation, users can log in with their credentials.
Reservation Process: The user fills out the reservation form, including details such as name, phone number, email, age, gender, train number, class, and travel dates.
Cancel Reservation: Users can cancel their reservation by viewing their stored journey details and confirming the cancellation.

**Project Structure**
├── ReservationForm1.java   # Main program file for handling user inputs and system logic
└── BasicDetails.java       # Class to store user and journey details

**Future Enhancements**
Support for more train options and dynamic data loading.
Enhanced user interface with error handling.
Add persistence (database) to store login and journey details.
