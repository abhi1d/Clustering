

public class Clustering {

    public static void main(String args[])
    {
        Access_File obj_file = new Access_File();
        String data[] = obj_file.getFile();

        Dimension obj_dimension = new Dimension(data);
        String dimension[][] = obj_dimension.getDimension();

        Population_Init obj_population = new Population_Init(dimension);
        int population_vector[][] =  obj_population.getPopulation();


        for(int i = 0 ; i < Population_Init.population_size ; i++)
        {
            System.out.print("[");
            for(int j = 0 ; j < Population_Init.no_of_cluster ; j++)
            {
                System.out.print(population_vector[i][j] + ",");

            }
            System.out.println("]");
        }
    }
}
