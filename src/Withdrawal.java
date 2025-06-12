public class Withdrawal extends Transaction {
    private Keypad keypad;
    private CashDispenser cashDispenser;

    public Withdrawal(int accNum, Screen screen, BankDatabase bankDB, Keypad keypad, CashDispenser cashDispenser) {
        super(accNum, screen, bankDB);
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        screen.displayMessage("Enter amount to withdraw: ");
        double amount = keypad.getInput();
        if (amount <= bankDatabase.getAvailableBalance(accountNumber) && cashDispenser.isSufficientCashAvailable(amount)) {
            bankDatabase.debit(accountNumber, amount);
            cashDispenser.dispenseCash(amount);
            screen.displayMessage("Please take your cash.\n");
        } else {
            screen.displayMessage("Insufficient funds or cash not available.\n");
        }
    }
}