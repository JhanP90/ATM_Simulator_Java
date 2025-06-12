public class Deposit extends Transaction {
    private Keypad keypad;
    private DepositSlot depositSlot;

    public Deposit(int accNum, Screen screen, BankDatabase bankDB, Keypad keypad, DepositSlot depositSlot) {
        super(accNum, screen, bankDB);
        this.keypad = keypad;
        this.depositSlot = depositSlot;
    }

    @Override
    public void execute() {
        screen.displayMessage("Enter amount to deposit (in cents): ");
        int cents = keypad.getInput();
        double amount = cents / 100.0;

        screen.displayMessage("Please insert a deposit envelope now.\n");
        if (depositSlot.isEnvelopeReceived()) {
            bankDatabase.credit(accountNumber, amount);
            screen.displayMessage("Envelope received. Funds will be available after verification.\n");
        } else {
            screen.displayMessage("No envelope received. Transaction canceled.\n");
        }
    }
}