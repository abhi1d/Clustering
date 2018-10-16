import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Access_File {
    public List<String> getFile()
    {
        List<String> data_point_list = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader("iris.data.txt"))) {
            String line = null;
            while ((line = br.readLine()) != null) {

                data_point_list.add(line);

            }



        } catch (Exception e)
        {
            System.out.println("error" + e);

        }
        return data_point_list;

    }
}
