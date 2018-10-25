import java.io.FileWriter;
import java.util.List;

public class Clustering {
    public static int population_size;
    public static int no_of_cluster;

    public static void main(String args[])
    {
        Access_File obj_file = new Access_File();
        List<String> raw_data_point = obj_file.getFile();

        Dimension obj_dimension = new Dimension(raw_data_point);
        List<List<String>> dimension_vector= obj_dimension.getDimension();

        // dimesnion vector in the String, Conversion into Double data type.
        DataTypeConversion obj_datDataTypeConversion = new DataTypeConversion(dimension_vector);
        double data_points[][] = obj_datDataTypeConversion.getDataPoints();


        Population_Init obj_population = new Population_Init(dimension_vector);
        int population_vector[][] =  obj_population.getPopulation();

        population_size = obj_population.population_size;
        no_of_cluster = obj_population.no_of_cluster;

        System.out.print("**********************************************************************************************");
        System.out.print("\n\tPopulation Intitalization matrix :  Without the labels (P)\n");
        for(int i = 0 ; i < population_size ; i++)
        {
            System.out.print("[  ");
            for(int j = 0 ; j < no_of_cluster ; j++)
            {
                //System.out.print("[ ");

               // for(int v = 0 ; v < population_vector[0].length ;v++ ) // length is 4 in the Irish Data-set
                System.out.print( population_vector[i][j] );
                   System.out.print( dimension_vector.get(population_vector[i][j]) + " "); // data[population_vector[i][j]]

               // System.out.print(" ], ");

            }
            System.out.println("   ]");
        }
        System.out.print("**********************************************************************************************");

   //*************************************************************************************************************************
      Membership_Computation obj_membership_computation = new Membership_Computation(data_points, population_vector, population_size, no_of_cluster, dimension_vector);
      double[][][] membership_matrix = obj_membership_computation.getMembershipMatrix();

      // if mistakely something becomes Nan number then converting into normal default value = 1.0;
      for(int i = 0 ; i < membership_matrix.length ; i++)
        {

            for(int j = 0 ; j < membership_matrix[i].length ; j++)
            {


                for(int k = 0 ; k < membership_matrix[i][j].length ; k++)
                {
                    if(Double.isNaN(membership_matrix[i][j][k]))
                    {
                        membership_matrix[i][j][k] = 1.0;
                    }

                }



            }
        }

      // Writing membership matrix into file named membership_output.txt.
        try{
             FileWriter fw = new FileWriter("membership_output.txt");

             for(int i = 0 ; i < membership_matrix.length ; i++)
             {
                 fw.write( ""+ (i + 1));
                 for(int j = 0 ; j < membership_matrix[i].length ; j++)
                 {
                     double sum = 0.0;
                     fw.write("\t" + j+"\t");
                     for(int k = 0 ; k < membership_matrix[i][j].length ; k++)
                     {
                         sum = sum + membership_matrix[i][j][k];
                         fw.write( membership_matrix[i][j][k] + " ");
                     }
                     fw.write("::::::::::" + sum);
                     fw.write("\n");

                 }
             }


             fw.close();
        }catch (Exception e){
            System.out.print("File Writing error " + e);
        }
    //************************************************************************************************************************
    // updation of cluster center
    UpdateCenter obj_updateCenter = new UpdateCenter(membership_matrix, population_size, no_of_cluster, data_points);
    double [][][] updated_center =  obj_updateCenter.centerUpdate();
        // Writing membership matrix into file named membership_output.txt.
        try{
            FileWriter fw = new FileWriter("membership_output.txt", true);

            fw.append("\n Now updated center data is updated.\n");

            for(int i = 0 ; i < updated_center.length ; i++)
            {
                fw.append( "[");
                for(int j = 0 ; j < updated_center[i].length ; j++)
                {

                    fw.append("[");
                    for(int k = 0 ; k < updated_center[i][j].length ; k++)
                    {

                        fw.write( updated_center[i][j][k] + " ");
                    }
                    fw.append("],");
                    fw.append("\t");

                }
                fw.append("]\n");
            }


            fw.close();
        }catch (Exception e){
            System.out.print("File Writing error " + e);
        }


    }
}
