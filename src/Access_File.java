import java.io.BufferedReader;
import java.io.FileReader;

public class Access_File {
    public String[] getFile()
    {
        String data[] = new String[570];
        int i = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("wdbc_data.txt"))) {
            String line = null;
            while ((line = br.readLine()) != null) {

                data[i] = line;
                i++;
            }


        } catch (Exception e)
        {
            System.out.println("hhhh" + e);

        }
        return data;

    }
}
