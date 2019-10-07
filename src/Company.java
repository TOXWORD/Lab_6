import java.io.FileWriter;
import java.io.IOException;

public class Company {

    private final int NUMBER_OF_ELEMENTS = 12;

    private String name;
    private String shortTitle;
    private String dateUpdate;
    private String address;
    private String dateFoundation;
    private String countEmployees;
    private String auditor;
    private String phone;
    private String email;
    private String branch;
    private String activity;
    private String link;

    public Company() {
        name = "";
        shortTitle = "";
        dateUpdate = "";
        address = "";
        dateFoundation = "";
        countEmployees = "";
        auditor = "";
        phone = "";
        email = "";
        branch = "";
        activity = "";
        link = "";
    }

    public Company(String data) {

        String[] dataEl = data.split(";");

        if (dataEl.length < NUMBER_OF_ELEMENTS) {
            String[] tmp = new String[NUMBER_OF_ELEMENTS];
            for (int i = 0; i < dataEl.length; i++) {
                tmp[i] = dataEl[i];
            }
            for (int i = dataEl.length; i < NUMBER_OF_ELEMENTS; i++) {
                tmp[i] = "";
            }
            dataEl = tmp;
        }
        name = dataEl[0];
        shortTitle = dataEl[1];
        dateUpdate = dataEl[2];
        address = dataEl[3];
        dateFoundation = dataEl[4];
        countEmployees = dataEl[5];
        auditor = dataEl[6];
        phone = dataEl[7];
        email = dataEl[8];
        branch = dataEl[9];
        activity = dataEl[10];
        link = dataEl[11];

    }


    public String getName() {
        return name;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getBranch() {
        return branch;
    }

    public String getActivity() {
        return activity;
    }


    public boolean compareDates(String from, String to) {
        String[] divDate = dateFoundation.split("[.,; ]+");
        String[] divFrom = from.split("[.,; ]+");
        String[] divTo = to.split("[.,; ]+");

        if (divDate.length != divFrom.length || divDate.length != divTo.length) {
            return false;
        }

        int yearFrom = Integer.parseInt(divFrom[divFrom.length - 1]);
        int yearTo = Integer.parseInt(divTo[divTo.length - 1]);
        int year = Integer.parseInt(divDate[divDate.length - 1]);

        int monthFrom = Integer.parseInt(divFrom[divFrom.length - 2]);
        int monthTo = Integer.parseInt(divTo[divTo.length - 2]);
        int month = Integer.parseInt(divDate[divDate.length - 2]);

        int dayFrom = Integer.parseInt(divFrom[divFrom.length - 2]);
        int dayTo = Integer.parseInt(divTo[divTo.length - 2]);
        int day = Integer.parseInt(divDate[divDate.length - 2]);

        if ((year >= yearFrom && year <= yearTo) || (year <= yearFrom && year >= yearTo)) {
            return true;
        } else if ((month >= monthFrom && month <= monthTo) || (month <= monthFrom && month >= monthTo)) {
            return true;
        } else if ((day >= dayFrom && day <= dayTo) || (day <= dayFrom && day >= dayTo)) {
            return true;
        }

        return false;
    }

    public boolean compareEmpl(String from, String to) {
        int fr = Integer.parseInt(from);
        int t = Integer.parseInt(to);
        int employees = Integer.parseInt(countEmployees);

        if (fr > t) {
            int tmp = t;
            t = fr;
            fr = tmp;
        }

        if (employees >= fr && employees <= t) {
            return true;
        }
        return false;

    }

    public void writeToXML() {

    }

    public void writeToJSON(FileWriter fw, int cons) throws IOException {
        if(cons != 0){
            fw.write(",\n");
        }
        fw.write("\"output" + cons + "\":\n{\n");
        fw.write("\"name\":\"" + name + "\",\n");
        fw.write("\"shortTitle\":\"" + shortTitle + "\",\n");
        fw.write("\"dateUpdate\":\"" + dateUpdate + "\",\n");
        fw.write("\"address\":\"" + address + "\",\n");
        fw.write("\"dateFoundation\":\"" + dateFoundation + "\",\n");
        fw.write("\"countEmployees\":\"" + countEmployees + "\",\n");
        fw.write("\"auditor\":\"" + auditor + "\",\n");
        fw.write("\"phone\":\"" + phone + "\",\n");
        fw.write("\"email\":\"" + email + "\",\n");
        fw.write("\"branch\":\"" + branch + "\",\n");
        fw.write("\"activity\":\"" + activity + "\",\n");
        fw.write("\"link\":\"" + link + "\"\n");
        fw.write("}");

    }

}
