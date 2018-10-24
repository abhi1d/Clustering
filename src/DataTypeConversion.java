import java.util.ArrayList;
import java.util.List;

public class DataTypeConversion {


    private List<List<String>> dimension_vector = new ArrayList<>();

    public DataTypeConversion(List<List<String>> dimension_vector)
    {
        this.dimension_vector = dimension_vector;
    }


    public double[][] getDataPoints()
    {
        // if we want  to use list then we should always declare inside the method area. : Doubt Theory
        double data_point[][]= new double[dimension_vector.size()][dimension_vector.get(0).size()];
        System.out.print("\nDouble Value converted\n");
        try{
            for(int i = 0 ; i < dimension_vector.size() ; i++)
            {

                System.out.print("[");
                //List<Double> temp_list = new ArrayList<>();
                for(int j = 0 ; j < 4; j++)
                {
                    if(!dimension_vector.get(i).get(j).equals(null))
                    {
                        double temp = Double.parseDouble((dimension_vector.get(i).get(j)).trim());
                        data_point[i][j] = temp;
                        System.out.print(" " +data_point[i][j]);
                    }


                }
                System.out.print("]\n");


            }


        } catch (Exception e)
        {
            System.out.print("Error occured : " + e);
        }


        return data_point;
    }

}
