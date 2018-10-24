
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import edu.stanford.nlp.math.ArrayMath;

public class Maths {

    public static void main(String args[])
    {
        double []a = {1.0,2.0,3.0};
        double []b = {1.0,2.0,4.0};




        List<List<Double>> l = new ArrayList<>();
        List<Double> list1 = new ArrayList<>();

        list1.add(1.0);
        list1.add(2.0);
        l.add(list1);
        List<Double> list2 = new ArrayList<>();
        list2.add(5.0);
        list2.add(6.0);

        double[]l2 = {5.0,5.0};
        List<Double> list3 = IntStream.range(0, l.get(0).size())
                .mapToObj(i -> list1.get(i) - l2[i])
                .collect(Collectors.toList());
        System.out.print(list3);

     }



}
