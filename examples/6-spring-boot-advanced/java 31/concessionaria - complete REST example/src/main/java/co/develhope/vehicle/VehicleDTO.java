package co.develhope.vehicle;


public class VehicleDTO {

    public Long id;

    public String azienda;

    public String colore;

    public String modello;

    public double prezzo;

    public VehicleType tipo;

    public VehicleDTO(String azienda, String colore, Long id, String modello, double prezzo, VehicleType tipo) {
        this.azienda = azienda;
        this.colore = colore;
        this.id = id;
        this.modello = modello;
        this.prezzo = prezzo;
        this.tipo = tipo;
    }

    public VehicleDTO(VehicleEntity entity) {
        this.azienda = entity.getAzienda();
        this.colore = entity.getColore();
        this.id = entity.getId();
        this.modello = entity.getModello();
        this.prezzo = entity.getPrezzo();
        this.tipo = entity.getTipo();
    }
}
