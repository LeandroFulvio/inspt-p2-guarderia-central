package main.modelo;

import java.io.Serializable;
import java.util.Date;

public class Vehiculo implements Serializable {

    private String matricula;
    private String nombre;
    private TipoVehiculo tipoVehiculo;
    private Date fechaAsignacion;

    public Vehiculo(String matricula, String nombre, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }


}
