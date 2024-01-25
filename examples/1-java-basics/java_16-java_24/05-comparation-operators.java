public class MiaClass {
    public static void main(String args[]) {
      int x = 20;
      int y = 50;
      System.out.println("x = " + x);
      System.out.println("y = " + y);
      
      boolean xyEquals = x == y;
      System.out.println("Equals = " + xyEquals);
      
      boolean xyNotEquals = x != y;
      System.out.println("Not equals = " + xyNotEquals);
      
      boolean xySmaller = x < y;
      System.out.println("X smaller than Y = " + xySmaller);
      
      boolean xyBigger = x > y;
      System.out.println("X bigger than Y = " + xyBigger);
    }
}
