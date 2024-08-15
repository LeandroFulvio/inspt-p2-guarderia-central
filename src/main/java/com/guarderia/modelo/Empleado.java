package com.guarderia.modelo;

import com.guarderia.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String especialidad;

    private Long dni;
    private String direccion;
    private String telefono;

    @ManyToMany()
    @JoinTable(
            name = "empleado_zona",
            joinColumns = @JoinColumn(name = "zona_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    private Set<Zona> zonasAsignadas;

    @OneToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

}
