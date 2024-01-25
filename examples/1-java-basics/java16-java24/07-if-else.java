public class MiaClass {
    public static void main(String args[]) {
      int x = 10;
      int y = 25;
	  System.out.println("x = " + x);
      System.out.println("y = " + y);
      
      if (x > y) {
        xMaggioreDiY();
      } else if (x == y) {
        xUgualeAY();
      } else {
        xMinoreDiY();
      }
    }
    
    public static void xMaggioreDiY() {
      System.out.println("X e' maggiore di Y");  
    }
    
    public static void xUgualeAY() {
      System.out.println("X e' uguale a Y");  
    }
    
    public static void xMinoreDiY() {
      System.out.println("X e' minore di Y");  
    }
}
