public class UpdateCenter {

    double [][][]membership_matrix;
    int population_size;
    int no_of_cluster;
    double[][] data_point;

    public UpdateCenter(double [][][]membership_matrix,int population_size, int no_of_cluster, double[][] data_point)
    {
        this.membership_matrix = membership_matrix;
        this.population_size = population_size;
        this.no_of_cluster = no_of_cluster;
        this.data_point = data_point;
    }

    public double[][][]  centerUpdate()
    {
        double [][][] updated_center = new double[population_size][no_of_cluster][4];
        Maths obj_math = new Maths();
       for(int p = 0 ; p < population_size ; p++)
       {

           for(int j = 0 ; j < no_of_cluster ; j++)
           {
               double sum_a [] = {0.0,0.0,0.0,0.0};
               double sum_b  = 0.0;

               for(int i = 0 ; i < data_point.length ; i++)
               {
                   Membership_Computation temp_obj_mem = new Membership_Computation();

                   double squared_val_a = temp_obj_mem.getSquareVale(membership_matrix[p][i]);
                   double mat_mul_a[] = obj_math.mulWithDataValue(data_point[i],squared_val_a);
                   sum_a =   obj_math.addMatrix(sum_a, mat_mul_a);
                   sum_b  = sum_b + temp_obj_mem.getSquareVale(membership_matrix[p][i]);

                   /*System.out.println( ":::::::::::::" + sum_b+ "--Sum_a value ::::::::::::::::::::::::::");
                   for(int l = 0 ; l < sum_a.length;l++)
                   {
                       System.out.println(sum_a[l]);
                   }*/

               }

               System.out.println("\nTemp Array center values : ");
               double temp_center[] = obj_math.divideMatrixWithValue(sum_a, sum_b);
               /*for(int i = 0 ; i < 4 ; i++)
               {
                   System.out.println(" "+temp_center[i] + " ");
               }*/

               updated_center[p][j] = temp_center;


           }

       }


       // printing the value...
        for(int p = 0 ; p < population_size ; p++)
        {
            System.out.print("[");

            for(int j = 0 ; j < no_of_cluster ; j++)
            {
                System.out.print("[ ");
                for(int i = 0 ; i < 4 ; i++)
                {
                    System.out.print(" "+updated_center[p][j][i] + " ");
                }
                System.out.print("], ");

            }

            System.out.print("]\n");
        }

       return updated_center;
    }
}
