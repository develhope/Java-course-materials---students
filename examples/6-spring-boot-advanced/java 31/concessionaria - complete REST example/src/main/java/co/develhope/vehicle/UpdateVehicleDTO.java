package co.develhope.vehicle;


import jakarta.annotation.Nullable;

public class UpdateVehicleDTO {

    @Nullable
    public String azienda;

    @Nullable
    public String colore;

    @Nullable
    public String modello;

    @Nullable
    public Double prezzo;

    @Nullable
    public VehicleType tipo;
}
