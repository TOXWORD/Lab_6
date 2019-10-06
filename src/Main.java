import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            CsvDataFinder cdf = new CsvDataFinder();
            cdf.print();
            cdf.getByRequest();
        }
        catch (FileNotFoundException e) {
            System.out.println("FNF");
        }

    }
}
