/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_redes1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


/**
 *
 * @author andre
 */
public class IniCliente {
    
    static String HOST = "localhost";
    static int PUERTO = 5000;
    
        public void iniciarCliente(int n) throws IOException {
            
        Socket socket;
        ObjectOutputStream dosMsjSalida;
        ObjectInputStream disMsjEnt;
         
        
            //Creamos nuestro socket
            socket = new Socket(HOST, PUERTO);
            
     
//            dosMsjSalida = new ObjectOutputStream(socket.getOutputStream());
//            disMsjEnt = new ObjectInputStream(socket.getInputStream());
// 
//            //Enviamos un mensaje
//            dosMsjSalida.writeObject(c);
//            
//            Cartas cart = (Cartas) disMsjEnt.readObject();
//            
//            System.out.println("El mensaje recibido desde el servidor es: " );
//            //Cerramos la conexión
//            //socket.close();
            
            
            ObjectOutputStream carta1 = new ObjectOutputStream( socket.getOutputStream());
            // Se envía el objeto

            carta1.writeObject(n);
            carta1.close();
            socket.close();//Fin de la conexión
 
        
    }

}


