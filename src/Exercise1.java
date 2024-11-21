import java.io.*;
import java.util.Scanner;

public class Exercise1 {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }

            br.close();
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi");
        }
    }

    public static void main(String[] args) {
        System.out.print("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        Exercise1 readfileEx = new Exercise1();
        readfileEx.readFileText(path);
    }
}
