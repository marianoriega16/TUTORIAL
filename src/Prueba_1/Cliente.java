package Prueba_1;
import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        final String HOST = "127.0.0.1"; //Host del servidor
        DataOutputStream out; //Puerto del servidor

        try {
            Socket sc = new Socket(HOST, puerto); // se crea el socket para conetar con el cliente
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(mensaje); //Envio un mensaje al cliente
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}