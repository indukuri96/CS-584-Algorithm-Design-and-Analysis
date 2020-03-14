import java.io.*;
public class InputSource
{
    String inputString = "";

    InputSource(String fileName)
    {
        try {
            this.inputString = readFile("src/file1.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = br.readLine();
        }

        return sb.toString();

    }
}
