import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputSource1 {

        String inputString = "";

        InputSource1(String fileName)
        {
            try {
                this.inputString = readFile("src/file2.txt");

            } catch (Exception e) {
                // Handle it.
                System.out.println(e.getMessage());

            }
        }

        String readFile(String fileName) throws IOException {

//        final Path filePath = Paths.get(fileName);
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder(); String line = br.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }

            return sb.toString();

        }

    }



