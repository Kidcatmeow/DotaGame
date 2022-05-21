import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class stripHtmlTags {
    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/User/IdeaProjects/OOP/html3.txt"));
        stripHtmlTags(input);
    }

    public static void stripHtmlTags(Scanner input) {
        while (input.hasNext()) {
            String line = input.nextLine();

            while (line.contains("<") || (line.contains(">"))) {
                line = line.substring(0, line.indexOf("<")) + line.substring(line.indexOf(">") + 1);
            }
            System.out.println(line);
        }
    }

}
