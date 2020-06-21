/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author andre
 */
public class IniciarServidor {
    private InputStream isMiSocket;
   
    public void IniServ(){
       
 
        // Declaramos un servidor de Sockets.
        ServerSocket MiServidor = null;        
        Socket socket;
        
        
        //Variables para la entrada y salida de datos
      
        ObjectInputStream inSocket;
        ObjectOutputStream outSocket;
        
        //while (true) // Repita por siempre
        //{    
            try {
                // Asignamos el puerto 1018 al servidor.
                MiServidor = new ServerSocket(5000);         
                System.out.println("\nEsperando Conexiones");
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());

            }
//         while (true) // Repita por siempre
//        {   
            try {
                // Espere hasta que llegue una peticion de conexion y aceptela.                  
                socket = MiServidor.accept();                 
                System.out.println("\nCliente conectado...");
                System.out.println("El cliente tiene la IP: " + socket.getInetAddress()); 
                outSocket = new ObjectOutputStream(socket.getOutputStream());
                inSocket = new ObjectInputStream(socket.getInputStream());
                
                
                Cartas cart = (Cartas) inSocket.readObject();
                System.out.println(cart);
                System.out.println("El mensaje recibido es: "+ cart);
                
                MiServidor.close();
                 socket.close();
                inSocket.close();
               
                
            } catch (Exception e) {
                System.out.print("Exception: " + e);
            }   
//        }         
 
    }
    }

