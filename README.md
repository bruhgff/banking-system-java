# Console Banking System in Java

The program can make transactions and withdraws, show the history of transactions and show the actual balance of your
account. The objective of the program, is to practice OOP, Java good practices and automated tests;

## Features
- Consult actual balance in your account
- Make deposits, that are saved in your account
- Withdraw the money that got deposited
- See the history of transactions made using the program

## Technical Highlights
- **Object-Oriented Programming (OOP):** The OOP was used to maintain each file with each responsable individuality;
- **BigDecimal:** The use of decimal was used to prevent eventual imprecision of results, since the program is related
to money
- **try-catch:** Prevents program crashes on invalid user input (InputMismatchException) and handles business rule
violations cleanly
- **Data Persistence:** The history of transaction is stored on a .csv file, which is read in "AccountStorage.java"
using "java.nio.file"
- **Automated Tests:** It was created, using "JUnit", to test and validate the logic of the program

## Project Structure
- `Main.java`: The "Main.java", has the responsability to collect user input and be the interface of the project
- `Account.java`: Is responsible for receiving the inputs and process the data in private to retrieve to "Main.java"
- `Transaction`: Save the transaction information made in "Account.java" and formats in a readable way, to be stored
later in "AccountStorage.java"
- `AccountStorage.java`: Creates the storage file "transactions.csv" and read it back, whenever the program executes
- `InsufficientBalanceException.java`: Throws an error message, whenever the amount that is withdrawn is more than the
current balance
- `AccountTest.java`: Executes automated tests on the program and shows if everything is working

## Tech Stack
- Java: the project is made using JDK 27
- JUnit 5: Was used JUnit 5, to make the automated tests

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/bruhgff/banking-system-java.git
   ```
2. Open the project in IntelliJ IDEA (or your preferred Java IDE)
3. Run `Main.java` to start the console application
4. *(Optional)* Run `AccountTest.java` to execute the automated test suite