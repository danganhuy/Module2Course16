import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    // [Bài tập] Đọc file .csv
    public static void main(String[] args) {
        try {
            String line;
            File file = new File("file\\country.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                printCountry(parseCsvLine(line));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void printCountry(List<String> country) {
        System.out.println(
                "Country [id= "
                        + country.get(0)
                        + ", code= " + country.get(1)
                        + " , name=" + country.get(2)
                        + "]");
    }
}
