public class Main {
    public static void main(String[] args) {
        Articolo art1 = new Articolo(1.5);
        Articolo art2 = new Articolo(3.5);

        Carrello car1 = new Carrello();
        car1.addArticolo(art1);
        System.out.println("Carrello 1, prezzo totale: " + car1.prezzoTotale);

        Carrello car2 = new Carrello();
        car2.addArticolo(art1);
        car2.addArticolo(art2);

        System.out.println("Carrello 1, prezzo totale: " + car1.prezzoTotale);
        System.out.println("Carrello 2, prezzo totale: " + car2.prezzoTotale);

        Carrello car3 = new Carrello();
        car3.addArticolo(art2);
        System.out.println("Carrello 1, prezzo totale: " + car1.prezzoTotale);
        System.out.println("Carrello 2, prezzo totale: " + car2.prezzoTotale);
        System.out.println("Carrello 3, prezzo totale: " + car3.prezzoTotale);
    }
}