
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Guarderia g = Guarderia.getIntance();

        //Manejo de archivo - Excepciones manejadas por el FileManager
        FileManager fileManager = new FileManager();
        g.inicializarDatosGuarderia(fileManager.deserealizarGuarderia("Guarderia-central.txt"));

        //Guarderia inicializa los datos y lanza la aplicacion
        //Run app
        g.run();

        //Serializar
        fileManager.serializarGuaderia("Guarderia-central.txt", g);

    }



}
