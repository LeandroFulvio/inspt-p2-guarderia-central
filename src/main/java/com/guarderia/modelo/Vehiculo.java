package com.guarderia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo  {

    @Id
    private Long id;

    private String matricula;
    private String nombre;

    @Column(name = "tipo")
    private TipoVehiculo tipoVehiculo;

    @Column(name = "fecha_asignacion")
    private Date fechaAsignacion;

    @Column(name = "socio_id")
    private Long idSocio;

    public Vehiculo(String matricula, String nombre, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public boolean tieneCochera(){//Si tiene fecha asignada a cochera, ya esta guardado
        return fechaAsignacion!=null;
    }

//    public void mostrar() {
//        EntradaSalida.mostrarString(
//                "vehiculo: { \n" +
//                    "matricula:'" + matricula + '\'' +
//                    ", nombre:'" + nombre + '\'' +
//                    ", tipoVehiculo:" + tipoVehiculo.name());
//        if(fechaAsignacion!=null) EntradaSalida.mostrarString(", fecha Asignacion:" + fechaAsignacion);
//        EntradaSalida.mostrarString("}" );
//    }

}
