import java.util.ArrayList;
import java.util.List;

// Inverse of the matrix : Due

public class Membership_Computation {

    private List<String> data_point_list;
    private int population_vector[][];
    private int population_size;
    private int no_of_cluster;
    private double[][] data_points;
    List<List<String>> dimension_vector;

    public Membership_Computation(){}

   // setter contructor
    public Membership_Computation( double[][] data_points, int population_vector[][],  int population_size, int no_of_cluster, List<List<String>> dimension_vector)
    {

        this.data_points = data_points;
        this.population_vector = population_vector;
        this.population_size = population_size;
        this.no_of_cluster = no_of_cluster;
        this.dimension_vector = dimension_vector;
    }

    public double[][][] getMembershipMatrix()
    {

        // membership matrix
        // Copying the dimension vector data into membership matrix for the dummy values
        // for getting the dimension
         double [][][] membership_matrix = new double[population_size][data_points.length][no_of_cluster];

         try{
             for(int p = 0 ; p < population_size ; p++)
             {
                 for(int i = 0 ; i < data_points.length ; i++)
                 {
                     for(int j = 0 ; j < no_of_cluster ; j++)
                     {
                         double Diff_a[] = DifferenceMatrix(data_points[i],dimension_vector.get(population_vector[p][j]));
                         double a = getSquareVale(Diff_a);

                         double sum_b = 0.0;


                         for(int  k = 0 ; k < no_of_cluster ; k++)
                         {
                              double []Diff_b = DifferenceMatrix(data_points[i], dimension_vector.get(population_vector[p][k]));

                              double b = getSquareVale(Diff_b);
                              double b_temp = 0.0;
                              try{
                                  b_temp =  (1/b);
                              }catch (Exception e){
                                  b_temp = 1.0;
                                  System.out.print("zero division not allowed");
                              }
                             sum_b = sum_b + b_temp;
                            /*
                             System.out.print("[  (" + p + "x" + k + ") ");
                             for(int g  = 0 ; g < Diff_b.length ; g++)
                             {
                                 System.out.print(Diff_b[g]);
                             }
                             System.out.print( "\t");
                             System.out.println("]");
                            */

                         }

                         try{
                             membership_matrix[p][i][j] = (1.0 / (a * sum_b));
                         } catch (Exception e){
                             membership_matrix[p][i][j] = 1.0;
                         }


                        /* System.out.print("[  (" + i + "x" + j + ") ");
                         for(int g  = 0 ; g < Diff_a.length ; g++)
                         {
                             System.out.print(Diff_a[g]);
                         }
                         System.out.print( "\t");
                         System.out.println("]"); */

                     }
                 }
             }
         } catch (Exception e){
             System.out.println("-e-" + e);
         }




        return membership_matrix;
    }

    public double [] DifferenceMatrix(double [] data_points, List<String> center)
    {
        double [] diff_mat = new double[center.size()];

        for(int i = 0 ; i < 4 ; i++)
        {
            diff_mat[i] = data_points[i] - Double.parseDouble(center.get(i).trim());
        }

        return diff_mat;
    }

    public double [] AdditionMatrix(double [] data_points, List<String> center)
    {

        return null;
    }

    public double getSquareVale(double []matrix)
    {
        double square = 0.0; // transpose and then multipying value
                             // seemingly addition
        for(int i = 0 ; i < matrix.length ; i++)
        {
            square = square + matrix[i] * matrix[i];
        }

        return square;

    }
}
