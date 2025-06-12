public class ATM {
    private boolean userAuthenticated;
    private int currentAccountNumber;
    private Screen screen;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase;

    public ATM() {
        userAuthenticated = false;
        currentAccountNumber = 0;
        screen = new Screen();
        keypad = new Keypad();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();
        bankDatabase = new BankDatabase();
    }

    public void run() {
        while (true) {
            screen.displayMessage("Welcome!");
            authenticateUser();
            performTransactions();
            userAuthenticated = false;
            screen.displayMessage("Thank you! Goodbye!\n");
        }
    }

    private void authenticateUser() {
        while (!userAuthenticated) {
            screen.displayMessage("Please enter your account number:");
            int accNum = keypad.getInput();
            screen.displayMessage("Enter your PIN:");
            int pin = keypad.getInput();
            userAuthenticated = bankDatabase.authenticateUser(accNum, pin);
            if (userAuthenticated) currentAccountNumber = accNum;
            else screen.displayMessage("Invalid account number or PIN. Try again.\n");
        }
    }

    private void performTransactions() {
        boolean userExited = false;
        while (!userExited) {
            screen.displayMessage("Main menu:\n1 - View my balance\n2 - Withdraw cash\n3 - Deposit funds\n4 - Exit\nEnter a choice:");
            int choice = keypad.getInput();
            Transaction transaction = null;

            switch (choice) {
                case 1:
                    transaction = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
                    break;
                case 2:
                    transaction = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
                    break;
                case 3:
                    transaction = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
                    break;
                case 4:
                    userExited = true;
                    continue;
                default:
                    screen.displayMessage("Invalid selection. Try again.\n");
            }

            if (transaction != null) {
                transaction.execute();
            }
        }
    }
}
