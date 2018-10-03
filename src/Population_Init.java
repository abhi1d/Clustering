import java.util.Random;

public class Population_Init {

    // no of vector
    private int no_of_vector = 569;

    // setting the size of population
    public static int population_size = 10;

    // setting the number of clusters
    public  static int no_of_cluster = 3;

    // vector dimension
    private String vector_dimension[][] = new String[569][32];

    // population vector
    private int population_vector[][] = new int[population_size][no_of_cluster];

    // dimension setter constructor
    public Population_Init(String vector_dimension[][])
    {
        this.vector_dimension = vector_dimension;
    }

    public int[][] getPopulation()
    {
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
