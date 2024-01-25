public class MiaClass {
    public static void main(String args[]) {
      int x = 10;
      int y = 150;
      System.out.println("x = " + x);
      System.out.println("y = " + y);
      
      // && = AND
      boolean xyAnd = (x >= 10) && (y < 100);
      System.out.println("x is bigger or equal to 10 AND y is smaller than 100 = " + xyAnd);
      
      // || = OR
      boolean xyOr = (x >= 10) || (y < 100);
      System.out.println("x is bigger or equal to 10 OR y is smaller than 100 = " + xyOr);
      
      // ! = NOT
      boolean xyNor = !xyOr;
      System.out.println("x is NOT bigger than 10 AND y is NOT smaller than 100 = " + xyNor);
    }
}
