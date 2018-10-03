import java.util.StringTokenizer;

public class Dimension {

    public String  dimension_vector[][] = new String[569][32];
    public String data[] = new String[569];

    public Dimension(String data[])
    {
        this.data = data;
    }

    public String[][] getDimension()
    {

        for(int i = 0 ; i < 569 ; i++)
        {
           String temp[] = data[i].split(",");

           int j = 0;
           for(String s : temp )
           {
               dimension_vector[i][j] = s;
               j++;
           }


        }

        /*
        System.out.println("Dimension Vector :");


        for(int i = 0;i<dimension_vector.length;i++)
        {

            for(int j = 0 ; j< dimension_vector[i].length ;j++)
            {
                System.out.print(dimension_vector[i][j] + ":");
            }
            System.out.println();
        } */
        return dimension_vector;
    }
}
