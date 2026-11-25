void main() {
    Scanner scanner = new Scanner(System.in);
    Account account = new Account();
    boolean running = true;
    int choice = 0;

    while (running) {
        System.out.println("BANKING PROGRAM\n" +
                "1. Show Balance\n" +
                "2. Deposit\n" +
                "3. Withdraw\n" +
                "4. History\n" +
                "5. Exit");


        try {
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(account.getBalance());
                case 2 -> {
                    System.out.print("Enter an amount to be deposited: ");
                    BigDecimal amount = scanner.nextBigDecimal();
                    account.deposit(amount);
                }
                case 3 -> {
                    System.out.print("Enter an amount to be withdrawn: ");
                    BigDecimal amount = scanner.nextBigDecimal();
                    account.withdraw(amount);
                }
                case 4 -> showHistory(account.getTransactions());
                case 5 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please use only numbers");
            scanner.nextLine();
        } catch (IllegalArgumentException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    System.out.println("Thank you for using our Banking Program!");

    scanner.close();
}

static void showHistory(List<Transaction> transactions) {

    if (transactions.isEmpty()) {
        System.out.println("No history found!");
    }else{
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

static void showBalance(BigDecimal balance) {
    System.out.printf("$%,.2f\n", balance);
}

