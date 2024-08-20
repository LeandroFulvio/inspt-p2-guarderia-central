package com.guarderia.modelo;

import com.guarderia.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private Long dni;
    private String telefono;

    @CreatedBy
    private Date fechaIngreso; //Fecha de Ingreso a la Guarderia

    @OneToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @Transient
    private List<Vehiculo> vehiculoList; //Vehiculos propios del Socio

}
