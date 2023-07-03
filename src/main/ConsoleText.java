package main;

public abstract class ConsoleText {

    public static final String MENU_PRIMER_LOGGIN_1 = "No se encontraron usuarios. Se creará el usuario ADMINISTRADOR: \n Ingrese nombre: " ;

    public static final String CREACION_NOMBRE = "Ingrese nombre: ";
    public static final String CREACION_PASSWORD = "Ingrese password: ";
    public static final String CREACION_DIRECCION = "Ingrese direccion: ";
    public static final String CREACION_TELEFONO = "Ingrese telefono: ";
    public static final String CREACION_CODIGO = "Indique el codigo";
    public static final String CREACION_ESPECIALIDAD = "Indique la especialidad";
    public static final String CREACION_MATRICULA = "Indique la matricula";
    public static final String CREACION_MODELO_NOMBRE = "Indique el nombre del vehiculo";
    public static final String CREACION_TIPO_VEHICULO = "Indique cual es el Tipo de Vehiculo";
    public static final String CREACION_ZONA_LETRA = "Ingresa la Letra Identificable para la Zona";
    public static final String CREACION_ZONA_CAPACIDAD = "Ingrese la capacidad";
    public static final String CREACION_ZONA_TIPO_VEHICULO_ADMITIDO = "Seleccione el tipo de vehiculo adminitido en la Zona";
    public static final String CREACION_ZONA_MENU_TIPO_VEHICULO= "1.- Ingresar otro \n 2.- Salir.";
    public static final String CREACION_GARAGE_NUMERO = "Ingrese el numero para el nuevo Garage";
    public static final String CREACION_GARAGE_ZONA = "Ingrese la letra de la Zona del nuevo Garage";
    public static final String CREACION_GARAGE_ZONA_NO_EXISTE = "La zona ingresada no existe. Intente de nuevo.";
    public static final String CREACION_GARAGE_MENU_TIPO_ADMITIDO = "Seleccione el tipo de vehiculo adminitido en la Zona";
    public static final String CREACION_GARAGE_MENU_AGREGAR_TIPO_ADMITIDO = "1.- Agregar Tipo Vehiculo admitido en el Garage. \n 2.- Completar creacion.";

    public static final String MENU_SELECCION_SOCIO = "Elija el Numero correspondiente al Socio que desea seleccionar";
    public static final String NOMBRE_SOCIO_FUERA_RANGO = "El valor ingresado no es valida. Intente nuevamente.";
    public static final String MENU_SELECCION_GARAGE = "Elija el ID del Garage a Seleccionar.";
    public static final String ID_NO_EXISTE = "El ID ingresado no es valido. Intente nuevamente.";
    public static final String MENU_SELECCION_VEHICULO = "Elija el ID del Vehiculo a guardar en cochera.";
    public static final String MENU_SELECCION_EMPLEADO = "Elija el codigo del Empleado a seleccionar.";
    public static final String MENU_CODIGO_NO_EXISTE = "El codigo elegido no es valido. Intente de nuevo.";
    public static final String MENU_SELECCION_ZONA = "Elija la Letra de la Zona a seleccionar.";
    public static final String MENU_LETRA_NO_EXISTE = "La letra elegido no es una Zona valida. Intente de nuevo.";

    public static final String BIENVENIDA = "Bienvenido al sistema de Guarderia Central.";
    public static final String LOGGED_AS = "Log exitoso. Bienvenido ";
    public static final String BAD_CREDENTIALS = "Las credenciales no son validas. Intente nuevamente.";

    //Menu Principal
    public static final String ADM_MENU_PRINCIPAL = " 1.- Registrar Socio\n" +
            " 2.- Registrar Empleado\n" +
            " 3.- Registrar Zona\n" +
            " 4.- Registrar Garage\n" +
            " 5.- Vender Garage a Socio\n" +
            " 6.- Asignar Vehiculo a Garage\n" +
            " 7.- Asignar Empleado a Zona\n" +
            " 8.- Realizar Consulta\n" +
            " 0.- Salir\n" +
            " Ingrese el numero de la opcion que desea: ";

    public static final String SOCIO_MENU_PRINCIPAL = "1.- Mostrar Datos del Propios\n" +
            "2.- Mostrar Vehiculos\n"+
            "3.- Mostrar Garages\n"+
            "4.- Salir\n" +
            " Ingrese el numero de la opcion que desea: ";

    public static final String EMPLEADO_MENU_PRINCIPAL = "1.- Mostrar Datos del Propios\n" +
            "2.- Mostrar Zonas a Cargo\n"+
            "3.- Mostrar Garages a Cargo\n"+
            "4.- Salir\n" +
            " Ingrese el numero de la opcion que desea: ";


    //Crear cosas
    public static final String MENU_CREACION_VEHICULO = "¿Desea registrar un vehiculo? \n" +
            "1.- Agregar Vehiculo\n" +
            "2.- Finalizar";

    public static final String VEHICULO_REGISTRADO = "Vehiculo Registrado!";

    //Consultar cosas

    //Vender auto

    //asignar Zona / Empleado / AutoGarage


    public static final String ERROR_INT_EXPECTED_RETRY = "El valor ingresado no es un entero. Intente nuevamente.";

}
