package co.develhope.vehicle;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="azienda")
    private String azienda;

    @Column(name="colore")
    private String colore;

    @Column(name="modello")
    private String modello;

    @Column(name="prezzo")
    private double prezzo;

    @Column(name="tipo")
    @Enumerated(EnumType.STRING)
    private VehicleType tipo;

    protected VehicleEntity() {}

    public VehicleEntity(String azienda, String colore, String modello, double prezzo, VehicleType tipo) {
        this.azienda = azienda;
        this.colore = colore;
        this.modello = modello;
        this.prezzo = prezzo;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public VehicleType getTipo() {
        return tipo;
    }

    public void setTipo(VehicleType tipo) {
        this.tipo = tipo;
    }
}
