import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.logging.*;

import org.json.JSONObject;

public class CsvDataFinder {

    private String pathIn = "input.csv";

    private List<Company> data;

    private static final Logger logger = Logger.getLogger("log");

    public CsvDataFinder() throws IOException {

        data = new ArrayList<>();

        File inp = new File(pathIn);
        try (Scanner sc = new Scanner(inp)) {
            while (sc.hasNextLine()) {
                data.add(new Company(sc.nextLine()));
            }
        }
    }

    public void fillFileByRequest() throws IOException, ParseException {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter a number of the request: ");
            int req = Integer.parseInt(sc.next());
            int found = 0;
            String toFind = null;
            String from = null;
            String to = null;
            String reqText;

            JSONObject jsData = new JSONObject();

            try (FileWriter fwJSON = new FileWriter("output.json")) {
                try (FileWriter fwXML = new FileWriter("output.xml")) {
                    fwXML.write("<output>\n");

                    switch (req) {
                        case 0:
                            return;

                        case 1: {
                            reqText = "1.Company by short title";
                            System.out.println(reqText + "\n Enter the title: ");
                            toFind = sc.next();
                            for (Company elem : data) {
                                if (elem.getShortTitle().toLowerCase().equals(toFind.toLowerCase())) {
                                    jsData.put("company_" + found, elem.addToJSON());
                                    elem.writeToXML(fwXML);
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
                                    jsData.put("company_" + found, elem.addToJSON());
                                    elem.writeToXML(fwXML);
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
                                    jsData.put("company_" + found, elem.addToJSON());
                                    elem.writeToXML(fwXML);
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
                                    jsData.put("company_" + found, elem.addToJSON());
                                    elem.writeToXML(fwXML);
                                    found++;
                                }
                            }
                            break;
                        case 5:
                            reqText = "5.Company by employees number";
                            System.out.println(reqText + "\n Enter the period(from/to) form - dd-mm-yyyy: ");
                            from = sc.next();
                            to = sc.next();
                            for (Company elem : data) {
                                if (elem.compareEmpl(from.toLowerCase(), to.toLowerCase())) {
                                    jsData.put("company_" + found, elem.addToJSON());
                                    elem.writeToXML(fwXML);
                                    found++;
                                }
                            }
                            break;
                        default:
                            reqText = "Incorrect request";
                            break;
                    }


                    fwJSON.write(jsData.toString());

                    if (toFind != null) {
                        logger.info("Request: " + reqText + " : " + toFind + " Number of found: " + found + "\n");
                    } else if (from != null && to != null) {
                        logger.info("Request: " + reqText + " : " + from + " / " + to + " Number of found: " + found + "\n");
                    } else {
                        logger.info(reqText);
                    }

                    fwXML.write("</output>");
                }
            }
        }
    }


}
