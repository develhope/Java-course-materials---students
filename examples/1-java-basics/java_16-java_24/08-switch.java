public class MiaClass {
    public static void main(String args[]) {
      int x = 10;
      
      switch(x) {
          case 0:
              xUgualeA0();
              break;
          case 10:
              xUgualeA10();
              break;
          default:
              xAltriCasi(x);
      }
    }
    
    public static void xAltriCasi(int x) {
      System.out.println("X e':" + x);  
    }
    
    public static void xUgualeA0() {
      System.out.println("X e' uguale a 0");  
    }
    
    public static void xUgualeA10() {
      System.out.println("X e' uguale a 10");  
    }
}
