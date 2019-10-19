import java.io.FileInputStream;
import java.util.logging.*;
import java.io.IOException;



public class Lab_6_reforged {
    private static final Logger log = Logger.getLogger("Log");

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));

        try {
            CsvDataFinder cdf = new CsvDataFinder();
            cdf.getByRequest();
        }
        catch (Exception e) {
            log.fine("Incorrect input!!!\n");
            System.out.println("Incorrect input!!!");
        }

    }
}
