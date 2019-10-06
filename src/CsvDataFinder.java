import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CsvDataFinder {

    private String pathIn = "input.csv";
    private final int ELEMENTS_NUMBER = 12;

    private List<HashMap<String, String>> data;

    public CsvDataFinder() throws FileNotFoundException {

        data = new ArrayList<>();

        File inp = new File(pathIn);
        Scanner sc = new Scanner(inp);

        String[] dataEl;
        HashMap<String, String> dataOrgEl;

        while(sc.hasNextLine()){

            dataEl = sc.nextLine().split(";");
            dataOrgEl = new HashMap<>();

            if(dataEl.length < ELEMENTS_NUMBER){
                String[] loader = new String[ELEMENTS_NUMBER];
                for(int i = 0; i < dataEl.length; i++){
                    loader[i] = dataEl[i];
                }
                for(int i = dataEl.length; i < ELEMENTS_NUMBER; i++){
                    loader[i] = "";
                }
                dataEl = loader;
            }

            dataOrgEl.put("name", dataEl[0]);
            dataOrgEl.put("shortTitle", dataEl[1]);
            dataOrgEl.put("dateUpdate", dataEl[2]);
            dataOrgEl.put("address", dataEl[3]);
            dataOrgEl.put("dateFoundation", dataEl[4]);
            dataOrgEl.put("countEmployees", dataEl[5]);
            dataOrgEl.put("auditor", dataEl[6]);
            dataOrgEl.put("phone", dataEl[7]);
            dataOrgEl.put("email", dataEl[8]);
            dataOrgEl.put("branch", dataEl[9]);
            dataOrgEl.put("activity", dataEl[10]);
            dataOrgEl.put("link", dataEl[11]);

            data.add(dataOrgEl);
        }
    }

    public void getByRequest(){

        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.println("Enter a number of the request: ");
            int req = Integer.parseInt(sc.next());
            switch (req) {
                case 0:
                    return;

                case 1: {
                    System.out.println("1.Company by short title\n Enter the title: ");
                    String title = sc.next();
                    for (HashMap<String, String> elem : data) {
                        if (elem.get("shortTitle").equals(title)) {
                            System.out.println(elem);
                        }
                    }
                }
                break;
                case 2:
                    System.out.println("2.Company by branch\n Enter the branch: ");
                    String branch = sc.next();
                    for (HashMap<String, String> elem : data) {
                        if (elem.get("branch").equals(branch)) {
                            System.out.println(elem);
                        }
                    }
                    break;
            }
        }


    }

    public void print(){
        for(HashMap<String, String> m : data){
            System.out.println(m.get("link"));
        }
    }

}
