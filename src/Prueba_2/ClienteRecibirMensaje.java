package Prueba_2;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteRecibirMensaje {

    Socket socket;
    DataInputStream recibir;
    String lineaRecibida;

    public ClienteRecibirMensaje(Socket s) {
        socket = s;
        try {
            recibir = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al recibir");
        }
    }

    public void recibir() {
        try {
            while (true) {
                System.out.println("Esperando un mensaje...");
                lineaRecibida = recibir.readUTF();
                System.out.println(lineaRecibida);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al enviar el mensaje");
        }
    }
}