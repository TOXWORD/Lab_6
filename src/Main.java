import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {

            Date d = new Date();
            FileWriter fw = new FileWriter("logfile.txt", true);
            fw.write(d.toString() + "\n");
            fw.close();


            CsvDataFinder cdf = new CsvDataFinder();
            cdf.print();
            cdf.getByRequest();
        }
        catch (FileNotFoundException e) {
            System.out.println("FNF");
        }
        catch (IOException e) {
            System.out.println("IOE");
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect input");
        }

    }
}
