import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountStorage {
    private Path filePath = Path.of("transactions.csv");

    public void saveTransaction(Transaction transaction) {
        String csvLine = transaction.toCSV() + System.lineSeparator();

        try {
            Files.writeString(filePath, csvLine, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    public List<Transaction> loadTransactions() {
        List<Transaction> loadedTransactions = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return loadedTransactions;
        }

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                if(line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(",");

                LocalDateTime timestamp = LocalDateTime.parse(parts[0]);
                String type = parts[1];
                BigDecimal amount = new BigDecimal(parts[2]);

                loadedTransactions.add(new Transaction(type, amount, timestamp));
            }
        } catch (IOException e){
            System.out.println("Error loading transactions: " + e.getMessage());
        }
        return loadedTransactions;
    }
}
