import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {
    // [Thực hành] Tìm giá trị lớn nhất và ghi ra file
    public List<Integer> readFile(String filePath) {

        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }
    public void writeFile(String filePath, List<Integer> numbers) {
        try {
            int max = numbers.get(0);
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Giá trị lớn nhất là: " + max);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Exercise3 ex = new Exercise3();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name to read: ");
        String fileName = sc.nextLine();
        List<Integer> list = ex.readFile(fileName);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.print("Enter file name to write: ");
        fileName = sc.nextLine();
        ex.writeFile(fileName, list);
    }
}
