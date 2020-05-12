package Prueba_2;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ServidorEnviarMensaje {

    Socket socket;
    DataOutputStream enviar;

    public ServidorEnviarMensaje(Socket s) {
        socket = s;
        try {
            enviar = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al enviar");
        }
    }

    public void enviar() {
        Scanner entrada = new Scanner(System.in);
        String cadena = "";
        try {
            while (true) {
                cadena = entrada.nextLine();
                enviar.writeUTF(cadena);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al enviar el mensaje");
        }
    }

}