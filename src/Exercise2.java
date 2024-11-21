import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2 {
    public List<Integer> readTextFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new FileNotFoundException(fileName);
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            List<Integer> list = new ArrayList<Integer>();
            String line;

            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }

            br.close();
            return list;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        Exercise2 ex = new Exercise2();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        List<Integer> list = ex.readTextFile(fileName);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
