package Prueba_1;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class Servidor extends Observable implements Runnable {

    private int puerto;

    public Servidor(int puerto) { this.puerto = puerto; }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;

        try {
            // se crea el socket del servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            // siempre entrara escuchando peticiones
            while (true) {
                // esperar a que el cliente se conecte
                sc = servidor.accept();
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());

                // lee el mensaje que se envia
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                // cerrar el socket
                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}