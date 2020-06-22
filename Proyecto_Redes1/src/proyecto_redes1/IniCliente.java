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
    
    static String HOST = "25.18.189.212";
    static int PUERTO = 50000;
    
        public void iniciarCliente(Cartas c) throws IOException, ClassNotFoundException {
            
        Socket socket;
       
         
        
            //Creamos nuestro socket
            socket = new Socket(HOST, PUERTO);
            
              ObjectOutputStream carta1 = new ObjectOutputStream( socket.getOutputStream());
//           
             ObjectInputStream disMsjEnt = new ObjectInputStream(socket.getInputStream());
// 
//            //Enviamos un mensaje
//            dosMsjSalida.writeObject(c);
               carta1.writeObject(c);
               Cartas cart = (Cartas) disMsjEnt.readObject();
//            
            System.out.println("El mensaje recibido desde el servidor es: " +cart);
//            //Cerramos la conexión
//            //socket.close();
            
            
            
           
            // Se envía el objeto

            
            carta1.close();
            socket.close();//Fin de la conexión
 
        
    }
        
        
       

}


