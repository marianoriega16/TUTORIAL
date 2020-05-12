package Prueba_2;

import java.net.*;
import java.util.*;

public class Cliente {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Socket socket = null;
        String texto, ipServidor = "127.0.0.1";

        try {
            socket = new Socket(ipServidor, 5000);
            ClienteRecibirMensaje recibe = new ClienteRecibirMensaje(socket);
            recibe.recibir();
            ClienteteEnviarMensaje envia = new ClienteteEnviarMensaje(socket);
            envia.enviar();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

}