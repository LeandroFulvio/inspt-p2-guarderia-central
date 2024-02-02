package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo  {

    @Id
    private Long id;

    private String matricula;
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoVehiculo tipoVehiculo;

    @Column(name = "fecha_asignacion")
    private Date fechaAsignacion;

    @ManyToOne
    @JoinColumn(name = "socio_id", updatable = false)
    private Socio socio;

    public boolean tieneCochera(){//Si tiene fecha asignada a cochera, ya esta guardado
        return fechaAsignacion!=null;
    }

}
