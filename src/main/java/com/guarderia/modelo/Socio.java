package com.guarderia.modelo;

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
@Table(name = "socio")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "socio")
    private List<Vehiculo> vehiculoList; //Vehiculos propios del Socio

    private Long dni;

    private String direccion;
    private String telefono;

    @CreatedBy
    private Date fechaIngreso; //Fecha de Ingreso a la Guarderia

    @JoinColumn(name = "user_id", updatable = false)
    private User user;


//    @Override
//    public void mostrarMenuPrincipal() {
//        EntradaSalida.mostrarString(ConsoleText.SOCIO_MENU_PRINCIPAL);
//        switch (EntradaSalida.leerEntero()) {
//            case 1: //1.- Mostrar data propia
//                this.mostrar();
//                mostrarMenuPrincipal();
//                break;
//            case 2: //2.- Mostrar Vehiculos
//                vehiculoList.forEach(Vehiculo::mostrar);
//                mostrarMenuPrincipal();
//                break;
//            case 3: //3.- mostrar Garages
//                Guarderia.getIntance().getGaragesBySocio(this)
//                        .forEach(Garage::mostrar);
//                mostrarMenuPrincipal();
//                break;
//            case 4: //4.- Salir
//                EntradaSalida.mostrarString("Hasta la proxima!");
//                break;
//            default:
//                break;
//        }
//
//    }

    public boolean tieneVehiculoSinGarage(){
        for (Vehiculo vehiculo : vehiculoList) {
            if (!vehiculo.tieneCochera())
                return true;
        }
        return false;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculoList.add(vehiculo);
    }

}
