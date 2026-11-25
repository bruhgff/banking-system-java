import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AccountTest {
    @BeforeEach
    void cleanUpFIle() throws IOException {
        Files.deleteIfExists(Paths.get("transactions.csv"));
    }

    @Test
    void shouldIncreaseBalanceWhenDepositing(){
        Account account = new Account();

        account.deposit(new BigDecimal("100.00"));

        BigDecimal expectedBalance = new BigDecimal("100.00");
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void shouldDecreaseBalanceWhenWithdrawing(){
        Account account = new Account();
        account.deposit(new BigDecimal("100.00"));

        account.withdraw(new BigDecimal("40.00"));

        BigDecimal expectedBalance = new BigDecimal("60.00");
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenWithdrawingMoreThanBalance(){
        Account account = new Account();
        account.deposit(new BigDecimal("50.00"));

        assertThrows(InsufficientBalanceException.class, () -> {
            account.withdraw(new BigDecimal("100.00"));
        });
    }
}
