import java.io.*;

public class FileManager {

    //pagina 158 apunte
    public FileManager() {
    }

    public Guarderia deserealizarGuarderia(String nomArch){
        try {
            ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArch)));

            Guarderia guarderia = (Guarderia) o.readObject();

            o.close();

            return guarderia;
        }catch (IOException | ClassNotFoundException e){
            System.out.println("No fue posible deserealizar el achivo: " + nomArch);
        }
        return Guarderia.getIntance();
    }

    public void serializarGuaderia(String nomArch, Guarderia guarderia) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomArch)));
            o.writeObject(guarderia);
            o.close();
        }catch (IOException e) {
            System.out.println("No fue posible serealizar el achivo: " + nomArch);
        }
    }


}
