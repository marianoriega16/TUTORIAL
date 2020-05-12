package Prueba_2;

import java.net.*;
import java.util.*;

public class Servidor {

    public static void main(String[] args) {
        String texto;
        Scanner entrada = new Scanner(System.in);
        ServerSocket servidor = null;
        Socket socket = null;

        ServidorEnviarMensaje e;

        try {
            servidor = new ServerSocket(5000);
            socket = servidor.accept();
            ServidorRecibirMensaje recibe = new ServidorRecibirMensaje(socket);
            recibe.recibir();
            ServidorEnviarMensaje envia = new ServidorEnviarMensaje(socket);
            envia.enviar();;
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

}


