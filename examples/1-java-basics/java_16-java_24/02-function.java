public class MiaClass {
    public static void main(String args[]) {
      double x = 1.0;
      double y = 3.0;
      
      System.out.println("Sum of x+y = " + somma(x, y));
    }
    
    public static int somma (double x, double y) {
        int z = (int) x + (int) y;
        return z;
    }
}
