import java.util.List;
import java.util.Random;

public class Population_Init {

    // setting the size of population
    public static int population_size = 10;

    // setting the number of clusters
    public  static int no_of_cluster = 3;

    // vector dimension
    public List<List<String>> vector_dimension;

    // population vector
    public  int population_vector[][] = new int[population_size][no_of_cluster];

    // default constructor
    public Population_Init()
    {

    }

    // dimension setter constructor
    public Population_Init(List<List<String>> vector_dimension)
    {
        this.vector_dimension = vector_dimension;
    }


    public int[][] getPopulation()
    {
        // no of vector
        int no_of_vector = vector_dimension.size();

        Random rand = new Random();


        for(int i = 0 ; i < population_size ; i++)
        {
           for(int j = 0 ; j < no_of_cluster ; j++)
           {
                int index = (int)(rand.nextDouble() * no_of_vector);
                population_vector[i][j] = index;


           }
        }

         return population_vector;

    }
}
