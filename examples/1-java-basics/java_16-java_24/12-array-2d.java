public class MiaClass {
    public static void main(String args[]) {
      // matrice in forma:
      // 1  2  3
      // 7  8  9  10
      // dichiariamo le colonne come un array, riga per riga, dentro altro array
        
      int[][] matrice = {{1, 2, 3}, {7, 8, 9, 10}};
      
      // per stampare la prima colonna della prima riga, 
      // usiamo prima indice della riga e poi indice della colonna
      // NOTA: indici partono sempre da 0!
      System.out.println("valore in prima riga, prima colonna: " + matrice[0][0]);
      
      // per stampare tutti i valori, dobbiamo avere due cicli for uno dentro l'altro
      for (int i = 0; i < matrice.length; ++i) {
          for (int j = 0; j < matrice[i].length; ++j) {
              System.out.println("riga: " + i + ", colonna: " + j + ", valore: " + matrice[i][j]);
          }
      }
    }
}
