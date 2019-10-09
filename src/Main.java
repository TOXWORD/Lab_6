import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        try {

            Date d = new Date();
            FileWriter fw = new FileWriter("logfile.txt", true);
            fw.write(d.toString() + "\n");
            fw.close();

            CsvDataFinder cdf = new CsvDataFinder();
            cdf.print();
            cdf.getByRequest();
        }
        catch (Exception e) {
            FileWriter fw = new FileWriter("logfile.txt", true);
            fw.write("Input error!!!" + "\n\n");
            fw.close();
            System.out.println("Incorrect input!!!");
        }

    }
}
