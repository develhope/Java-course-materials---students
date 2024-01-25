public class MiaClass {
    public static void main(String args[]) {
      int x = 20;
      int y = 50;
      System.out.println("x = " + x);
      System.out.println("y = " + y);
      
      int resultSum = x + y;
      System.out.println("Sum = " + resultSum);
      
      int resultSub = x - y;
      System.out.println("Subtraction = " + resultSub);
      
      int resultMulti = x * y;
      System.out.println("Multiplication = " + resultMulti);
      
      int resultDiv = x / y;
      System.out.println("Division = " + resultDiv);
      
      int resultMod = x % y;
      System.out.println("Modulo = " + resultMod);
      
      x++;
      System.out.println("Inc = " + x);
      
      x--;
      System.out.println("Dec = " + x);
      
      int resultInc = x++;
      System.out.println("resultInc = " + resultInc);
    }
}
