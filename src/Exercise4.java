import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Exercise4 {
    // [Bài tập] Copy file text
    public void copyFile(String sourceFile, String targetFile) {
        try {
            File file = new File(sourceFile);
            if (!file.exists()) {
                throw new FileNotFoundException(sourceFile);
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            File file2 = new File(targetFile);
            if (file2.exists()) {
                throw new FileAlreadyExistsException(targetFile);
            }
            FileWriter fileWriter = new FileWriter(file2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exercise4 ex = new Exercise4();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source file path: ");
        String sourceFile = scanner.nextLine();
        System.out.print("Enter target file path: ");
        String targetFile = scanner.nextLine();

        ex.copyFile(sourceFile, targetFile);
    }
}
