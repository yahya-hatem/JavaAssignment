import java.util.Scanner;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int correctPin = 1234;
        double accountBalance = 2500.75;
        int loginAttemptsLeft = 3;
        boolean isUserLoggedIn = false;
        int successfulTransactionsCount = 0;
        System.out.println("=== Welcome to the ATM ===");
        while (loginAttemptsLeft > 0) {
            System.out.print("Please enter your 4-digit PIN: ");
            int enteredPin = input.nextInt();
            if (enteredPin == correctPin) {
                isUserLoggedIn = true;
                System.out.println("Login successful!");
                break;
            } else {
                loginAttemptsLeft--;
                if (loginAttemptsLeft > 0) {
                    System.out.println("Incorrect PIN. Attempts remaining: " + loginAttemptsLeft);
                } else {
                    System.out.println("Your account has been locked.");
                }
            }
        }

        if (!isUserLoggedIn) {
            return;
        }
        int menuChoice;
        do {
            // Display ATM Menu
            System.out.println("========= ATM =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("=======================");
            System.out.print("Choose an option: ");
            menuChoice = input.nextInt();

            switch (menuChoice) {
                case 1:
                    // Option 1: Check Balance
                    System.out.printf("Your current balance is: $%.2f%n%n", accountBalance);
                    break;
                case 2:
                    // Option 2: Deposit
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();

                    // Multiple if-else logic for valid amount checking
                    if (depositAmount > 0) {
                        accountBalance += depositAmount;
                        successfulTransactionsCount++; // Bonus: Increment transaction count
                        System.out.println("Deposit successful.");
                        System.out.println("Updated Balance:$ "+ accountBalance); // Bonus: Display balance
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    // Option 3: Withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = input.nextDouble();

                    // Multiple if-else conditions checking for funds validation
                    if (withdrawalAmount == 0) {
                        System.out.println("Transaction cancelled"); // Bonus: Cancellation check
                    } else if (withdrawalAmount > 0) {
                        if (withdrawalAmount > accountBalance) {
                            System.out.println("Insufficient balance");
                        } else {
                            accountBalance -= withdrawalAmount;
                            successfulTransactionsCount++; // Bonus: Increment transaction count
                            System.out.println("Withdrawal successful");
                            System.out.printf("Updated Balance: $%.2f%n", accountBalance); // Bonus: Display balance

                            // Bonus: Warning if balance drops to precisely zero
                            if (accountBalance == 0) {
                                System.out.println("Warning: Your account is empty");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid amount. Must be greater than 0");
                    }
                    break;

                case 4:
                    if (accountBalance >= 5000) {
                        System.out.println("Account Status: VIP Customer");
                    } else if (accountBalance >= 1000) {
                        System.out.println("Account Status: Regular Customer");
                    } else {
                        System.out.println("Account Status: Low Balance");
                    }
                    break;
                case 5:
                    break;
                default:
                    // Invalid Menu Choice
                    System.out.println("Invalid option");
                    break;
            }
        } while (menuChoice != 5);
        System.out.println("Thank you for using our ATM.");
        System.out.println("Total successful transactions: " + successfulTransactionsCount);

        input.close();
    }
