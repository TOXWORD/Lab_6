import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CsvDataFinder {

    private String pathIn = "input.csv";
    private final int ELEMENTS_NUMBER = 12;

    private List<Company> data;

    public CsvDataFinder() throws FileNotFoundException {

        data = new ArrayList<>();

        File inp = new File(pathIn);
        Scanner sc = new Scanner(inp);

        while (sc.hasNextLine()) {
            Company temp = new Company(sc.nextLine());
            data.add(temp);
        }
    }

    public void getByRequest() throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number of the request: ");
        int req = Integer.parseInt(sc.next());
        int found = 0;
        String toFind;
        String from;
        String to;
        String reqText;

        FileWriter fwJSON = new FileWriter("output.json");
        fwJSON.write("{\n");

        switch (req) {
            case 0:
                return;

            case 1: {
                reqText = "1.Company by short title";
                System.out.println(reqText + "\n Enter the title: ");
                toFind = sc.next();
                for (Company elem : data) {
                    if (elem.getShortTitle().toLowerCase().equals(toFind.toLowerCase())) {
                        elem.writeToJSON(fwJSON,found);
                        found++;
                    }
                }
            }
            break;
            case 2:
                reqText = "2.Company by branch";
                System.out.println(reqText + "\n Enter the branch: ");
                toFind = sc.next();
                for (Company elem : data) {
                    if (elem.getBranch().toLowerCase().equals(toFind.toLowerCase())) {
                        elem.writeToJSON(fwJSON,found);
                        found++;
                    }
                }
                break;
            case 3:
                reqText = "3.Company by activity";
                System.out.println(reqText + "\n Enter the activity: ");
                toFind = sc.next();
                for (Company elem : data) {
                    if (elem.getActivity().toLowerCase().equals(toFind.toLowerCase())) {
                        elem.writeToJSON(fwJSON,found);
                        found++;
                    }
                }
                break;
            case 4:
                reqText = "4.Company by foundation date";
                System.out.println(reqText + "\n Enter the period(from/to): ");
                from = sc.next();
                to = sc.next();
                for (Company elem : data) {
                    if (elem.compareDates(from.toLowerCase(), to.toLowerCase())) {
                        elem.writeToJSON(fwJSON,found);
                        found++;
                    }
                }
                break;
            case 5:
                reqText = "5.Company by employees number";
                System.out.println(reqText + "\n Enter the period(from/to): ");
                from = sc.next();
                to = sc.next();
                for (Company elem : data) {
                    if (elem.compareEmpl(from.toLowerCase(), to.toLowerCase())) {
                        elem.writeToJSON(fwJSON, found);
                        found++;
                    }
                }
                break;
            default:
                reqText = "Incorrect request";
                System.out.println(reqText);
                break;
        }
        FileWriter fw = new FileWriter("logfile.txt", true);
        fw.write("Request: " + reqText + "\nNumber of found: " + found + "\n\n");
        fw.close();
        fwJSON.write("}\n");
        fwJSON.close();

    }

    public void print() {

    }

}
