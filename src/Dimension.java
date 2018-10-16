import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Dimension {

    List<List<String>> dimension_vector = new ArrayList<List<String>>();

    public List<String> data_point_list = new ArrayList<>();

    public Dimension(List<String> data_point_list)
    {
        this.data_point_list = data_point_list;
    }

    public List<List<String>> getDimension()
    {

        for(int i = 0 ; i < data_point_list.size() ; i++)
        {
           String []temp = data_point_list.get(i).split(",");
           List<String>inner_list = new ArrayList<>();

           for(String s : temp )
           {
               if(!s.contains("Iris"))
               {
                   inner_list.add(s);
               }

           }
            dimension_vector.add(inner_list);


        }


        System.out.println("Dimension Vector :");


        for(int i = 0;i<dimension_vector.size();i++)
        {
            System.out.print("[");

            for(int j = 0 ; j< dimension_vector.get(i).size() ;j++)
            {
                System.out.print(dimension_vector.get(i).get(j) + " ");
            }
            System.out.println("]");
        }
        return dimension_vector;
    }
}
