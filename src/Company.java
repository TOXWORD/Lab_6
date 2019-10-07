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

        if (!(Integer.parseInt(divDate[divDate.length - 1]) >= Integer.parseInt(divFrom[divDate.length - 1]) && Integer.parseInt(divDate[divDate.length - 1]) <= Integer.parseInt(divTo[divDate.length - 1]))) {
            return false;
        }

        if (!(Integer.parseInt(divDate[divDate.length - 2]) >= Integer.parseInt(divFrom[divDate.length - 2]) && Integer.parseInt(divDate[divDate.length - 2]) <= Integer.parseInt(divTo[divDate.length - 2]))) {
            return false;
        }

        if (!(Integer.parseInt(divDate[divDate.length - 3]) >= Integer.parseInt(divFrom[divDate.length - 3]) && Integer.parseInt(divDate[divDate.length - 3]) <= Integer.parseInt(divTo[divDate.length - 3]))) {
            return false;
        }

        return true;
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

}
