import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    public Account() {
        this.transactions = storage.loadTransactions();

        for (Transaction transaction : transactions) {
            if(transaction.getType().equals("DEPOSIT")) {
                balance = balance.add(transaction.getAmount());
            }else if(transaction.getType().equals("WITHDRAW")) {
                balance = balance.subtract(transaction.getAmount());
            }
        }
    }

    private BigDecimal balance =  BigDecimal.ZERO;
    private List<Transaction> transactions = new ArrayList<>();
    private AccountStorage storage = new AccountStorage();

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        } else {
            Transaction transaction = new Transaction("DEPOSIT", amount);
            transactions.add(transaction);
            storage.saveTransaction(transaction);
            balance = balance.add(amount);
        }

    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        } else if (amount.compareTo(balance) > 0) {
            throw new InsufficientBalanceException("You don't have enough money");
        } else {
            Transaction transaction = new Transaction("WITHDRAW", amount);
            transactions.add(transaction);
            storage.saveTransaction(transaction);
            balance = balance.subtract(amount);
        }
    }
}

