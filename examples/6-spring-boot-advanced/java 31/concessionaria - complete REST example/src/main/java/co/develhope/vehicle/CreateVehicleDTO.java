package co.develhope.vehicle;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateVehicleDTO {

    @NotEmpty
    public String azienda;

    @NotEmpty
    public String colore;

    @NotEmpty
    public String modello;

    @Positive
    public double prezzo;

    @NotNull
    public VehicleType tipo;
}
