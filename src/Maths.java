

public class Maths {

 public double[] mulWithDataValue(double []a , double b)
 {
     for(int i = 0 ; i < a.length ; i++)
     {
         a[i] = a[i] * b;
     }

     return a;
 }
 public  double [] addMatrix(double []a, double []b)
 {
     for(int i = 0 ; i < a.length ; i++)
     {
         a[i] = a[i] + b[i];
     }

     return a;
 }

 public double[] divideMatrixWithValue(double []a , double b)
  {
        for(int i = 0 ; i < a.length ; i++)
        {
            a[i] = a[i] / b;
        }

        return a;
   }

}
