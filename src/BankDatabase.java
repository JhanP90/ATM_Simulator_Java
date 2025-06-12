import java.util.ArrayList;
import java.util.List;

public class BankDatabase {
    private List<Account> accounts;

    public BankDatabase() {
        accounts = new ArrayList<>();
        accounts.add(new Account(12345, 54321, 1000.0));
        accounts.add(new Account(98765, 56789, 500.0));
    }

    public boolean authenticateUser(int accNum, int pin) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNum && acc.validatePIN(pin)) {
                return true;
            }
        }
        return false;
    }

    public double getAvailableBalance(int accNum) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNum) {
                return acc.getAvailableBalance();
            }
        }
        return 0.0;
    }

    public void credit(int accNum, double amount) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNum) {
                acc.credit(amount);
            }
        }
    }

    public void debit(int accNum, double amount) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNum) {
                acc.debit(amount);
            }
        }
    }
}
