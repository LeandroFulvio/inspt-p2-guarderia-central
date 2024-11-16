package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_id")
    private TipoVehiculo tipoVehiculo;

    @Column(name = "fecha_asignacion")
    private Date fechaAsignacion;

    @ManyToOne
    @JoinColumn(name = "socio_id", updatable = false)
    private Socio socio;

    @Transient
    public boolean tieneCochera(){//Si tiene fecha asignada a cochera, ya esta guardado
        return fechaAsignacion!=null;
    }

}
