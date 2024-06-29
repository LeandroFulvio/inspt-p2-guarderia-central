package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
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
    //TODO: Nueva tabla para relacion zona - empleado

    @JoinColumn(name = "user_id", updatable = false)
    private User user;

//
//    @Override
//    public void mostrarMenuPrincipal() {
//        EntradaSalida.mostrarString(ConsoleText.EMPLEADO_MENU_PRINCIPAL);
//        switch (EntradaSalida.leerEntero()) {
//            case 1: //1.- Menu mostrar data propia
//                this.mostrar();
//                mostrarMenuPrincipal();
//                break;
//            case 2: //2.- Mostrar zonas
//                this.zonasAsignadas.forEach(Zona::mostrar);
//                mostrarMenuPrincipal();
//                break;
//            case 3: //3.- mostrar garages de las zonas a cargo
//                zonasAsignadas.forEach(x->{
//                    Guarderia.getIntance().getGaragesByZona(x)
//                            .forEach(Garage::mostrar);
//                });
//                mostrarMenuPrincipal();
//                break;
//            case 4: //4.- Salir
//                EntradaSalida.mostrarString("Hasta la proxima!");
//                break;
//            default:
//                break;
//        }
//    }

    public boolean isCodigo(String codigo){
        return codigo.equals(this.codigo);
    }

}
