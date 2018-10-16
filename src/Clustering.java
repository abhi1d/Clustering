import java.util.List;

public class Clustering {
    public static int population_size;
    public static int no_of_cluster;

    public static void main(String args[])
    {
        Access_File obj_file = new Access_File();
        List<String> data_point_list = obj_file.getFile();

        Dimension obj_dimension = new Dimension(data_point_list);
        List<List<String>> dimension= obj_dimension.getDimension();

        Population_Init obj_population = new Population_Init(dimension);
        int population_vector[][] =  obj_population.getPopulation();

        population_size = obj_population.population_size;
        no_of_cluster = obj_population.no_of_cluster;

        for(int i = 0 ; i < population_size ; i++)
        {
            System.out.print("[");
            for(int j = 0 ; j < no_of_cluster ; j++)
            {
                System.out.print(population_vector[i][j] + ","); // data[population_vector[i][j]]

            }
            System.out.println("]");
        }



    }
}
