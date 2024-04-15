import java.util.ArrayList;
import java.util.List;

public class Carrello {

    public double prezzoTotale; //member
    List<Articolo> articoli = new ArrayList<>(); //member

    public void addArticolo(Articolo articolo) {
        articoli.add(articolo);

        prezzoTotale = calcoloPrezzo();
    }

    public double calcoloPrezzo() {
        double prezzoIntermedio = 0; //local

        for (int i= 0; i<articoli.size(); i++) {
            double prezzoInEuro = articoli.get(i).prezzo * 1.15; //loop
            prezzoIntermedio += prezzoInEuro;
        }

        return prezzoIntermedio;
    }

}
