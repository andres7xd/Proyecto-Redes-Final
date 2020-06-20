/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_redes1;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author andre
 */
public class FXMLDocumentController implements Initializable {

    private ArrayList<Cartas> Maso = new ArrayList<>();
    private ArrayList<Cartas> Mano = new ArrayList<>();
    private ArrayList<Cartas> Mano2 = new ArrayList<>();
    private ArrayList<Cartas> Mano3 = new ArrayList<>();

    private ArrayList<Cartas> Mesaj1List = new ArrayList<>();

    private boolean Selec;
    public static int Contador = 0;
    private static Cartas cartaSelec;
    private boolean transplante = false;
    private int m = 0;

    Image Imagen;
    private Label label;
    @FXML
    private ImageView MasoImv;
    @FXML
    private ImageView ManoSplitPane;
    @FXML
    private HBox ManoJ1;
    private ImageView Imvjugador1;
    @FXML
    private HBox Mesaj1;
    @FXML
    private HBox Mesaj4;
    @FXML
    private HBox Mesaj5;
    @FXML
    private HBox Mesaj3;
    @FXML
    private HBox Mesaj12;
    @FXML
    private HBox Mesaj6;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Cartas carprueba = new Cartas("rojo", "Corazón_rojo", "Imagenes/Corazón_rojo.png");

        IniCliente inicia = new IniCliente();
        try {
            inicia.iniciarCliente(0);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cartas objetocarta;
        objetocarta = Cartas.cart;

        LLenarMaso();

        for (int i = 0; i < 9; i++) {
            Repartir(i);
        }

        infectar();
    }

    public void LLenarMaso() {
        for (int i = 0; i < 68; i++) {
            if (i < 5) {
                Maso.add(new Cartas("rojo", "Corazón_rojo", "Imagenes/Corazón_rojo.png"));
            }

            if (i >= 5 && i < 10) {
                Maso.add(new Cartas("azul", "Cerebro_azul", "Imagenes/Cerebro_azul.png"));
            }

            if (i >= 10 && i < 15) {
                Maso.add(new Cartas("verde", "Estomago_verde", "Imagenes/Estomago_verde.png"));
            }

            if (i >= 15 && i < 20) {
                Maso.add(new Cartas("amarillo", "Hueso_amarillo", "Imagenes/Hueso_amarillo.png"));
            }

            if (i == 20) {
                Maso.add(new Cartas("multicolor", "Organo_multicolor", "Imagenes/Organo_multicolor.png"));
            }

            if (i > 20 && i < 25) {
                Maso.add(new Cartas("rojo", "Virus_rojo", "Imagenes/Virus_rojo.png"));
            }
//           
            if (i >= 25 && i < 29) {
                Maso.add(new Cartas("verde", "Virus_verde", "Imagenes/Virus_verde.png"));
            }

            if (i >= 29 && i < 33) {
                Maso.add(new Cartas("azul", "Virus_azul", "Imagenes/Virus_azul.png"));
            }

            if (i >= 33 && i < 37) {
                Maso.add(new Cartas("amarillo", "Virus_amarillo", "Imagenes/Virus_amarillo.png"));
            }

            if (i == 37) {
                Maso.add(new Cartas("multicolor", "Virus_multicolor", "Imagenes/Virus_multicolor.png"));
            }

            if (i > 37 && i < 42) {
                Maso.add(new Cartas("rojo", "Medicina_rojo", "Imagenes/Medicina_rojo.png"));
            }
            if (i >= 42 && i < 46) {
                Maso.add(new Cartas("verde", "Medicina_verde", "Imagenes/Medicina_verde.png"));
            }
            if (i >= 46 && i < 50) {
                Maso.add(new Cartas("amarillo", "Medicina_amarillo", "Imagenes/Medicina_amarillo.png"));
            }
            if (i >= 50 && i < 54) {
                Maso.add(new Cartas("azul", "Medicina_azul", "Imagenes/Medicina_azul.png"));
            }
            if (i >= 54 && i < 58) {
                Maso.add(new Cartas("multicolor", "Medicina_multicolor", "Imagenes/Medicina_multicolor.png"));
            }

            if (i >= 58 && i < 60) {
                Maso.add(new Cartas("blanco", "Transplante", "Imagenes/Transplante.png"));
            }

            if (i >= 60 && i < 63) {
                Maso.add(new Cartas("blanco", "Ladrón", "Imagenes/Ladrón.png"));
            }
            if (i >= 63 && i < 66) {
                Maso.add(new Cartas("blanco", "Contagio", "Imagenes/Contagio.png"));
            }

            if (i == 66) {
                Maso.add(new Cartas("blanco", "Guante Latex ", "Imagenes/Guante Latex .png"));
            }

            if (i == 67) {
                Maso.add(new Cartas("blanco", "ErrorMédico", "Imagenes/ErrorMédico.png"));
            }
        }

    }

    @FXML
    private void Dropear(MouseEvent event) {
        int rand;
        rand = (int) Math.floor(Math.random() * Maso.size());
        //   hboxMasoJug.getChildren().add(MainServidor.juegoMain.mazo.get(MainServidor.juegoMain.mazo.size()-1));
        Cartas objetocarta;

        objetocarta = Maso.get(rand);
        objetocarta.setNumerocarta(Mano.size());
        objetocarta.setOnMouseClicked(e -> {
            
            if(objetocarta.nombre == "Transplante"){
                transplante = true;
                cartaSelec = null;
               ManoJ1.getChildren().remove(objetocarta);
               
            }else{
                if(transplante == false){
                cartaSelec = objetocarta;
                }
                   
                
            }
        });

        ManoJ1.getChildren().add(objetocarta);

        Mano.add(objetocarta);

        Maso.remove(Maso.get(rand));

    }

    @FXML
    private void MesaJ1(MouseEvent event) {
        Cartas objetocarta;

        if (Contador == 0) {

            for (Cartas c : Mano) {
               
                if (c.Seleccionada == true) {

                    objetocarta = c;

                }
            }
            Contador++;
        }
        infectar();
    }

    @FXML
    private void MesaAccion(MouseEvent event) {

        Cartas objetocarta;
      
//        if(Contador == 1){
//             if(cartaSelec.color== "rojo"){
        if (cartaSelec != null) {

            boolean exist = false;

            
            final boolean existe = exist;
            
            if (existe == false && (cartaSelec.nombre == "Corazón_rojo" || cartaSelec.nombre == "Cerebro_azul" || cartaSelec.nombre == "Estomago_verde" || cartaSelec.nombre == "Hueso_amarillo" || cartaSelec.nombre == "Organo_multicolor")) {
                
                objetocarta = cartaSelec;
                cartaSelec.setOnMouseClicked(e -> {
                    //-------------------------------------------------------------------------------VACUNAR ORGANO--------------------------------------------------------------------------------
                    if (this.cartaSelec != null) {

                        if (this.cartaSelec.nombre == "Medicina_rojo" || this.cartaSelec.nombre == "Medicina_multicolor") {

                            if (objetocarta.nombre == "Corazón_rojo") {
                                

                                objetocarta.setImage(new Image("Imagenes/Corazón_rojo_vacunado.png"));
                                ManoJ1.getChildren().remove(cartaSelec);

                            }
                        }
                        if (this.cartaSelec.nombre == "Medicina_azul") {

                            if (objetocarta.nombre == "Cerebro_azul") {

                                objetocarta.setImage(new Image("Imagenes/Cerebro_azul_vacunado.png"));
                                ManoJ1.getChildren().remove(cartaSelec);
//          
                            }

                        }

                        if (cartaSelec.nombre == "Medicina_verde") {

                            if (objetocarta.nombre == "Estomago_verde") {

                                objetocarta.setImage(new Image("Imagenes/Estomago_verde.png"));
                                ManoJ1.getChildren().remove(cartaSelec);
//                     
                            }

                        }

                        if (cartaSelec.nombre == "Medicina_amarillo") {

                            if (objetocarta.nombre == "Hueso_amarillo") {

                                objetocarta.setImage(new Image("Imagenes/Hueso_amarillo_vacunado.png"));
                                ManoJ1.getChildren().remove(cartaSelec);
//                     
                            }

                        }
                        if(transplante==true){
                             System.out.println(cartaSelec.nombre);
                                   if(cartaSelec!=null && Existe()==false){
                                       
                                   Mesaj1.getChildren().remove(objetocarta);
                                   Mesaj1.getChildren().add(cartaSelec);
                                   Mesaj1List.remove(objetocarta);
                                   Mesaj1List.add(cartaSelec);
                                    if(m == 1){
                                    Mesaj3.getChildren().add(objetocarta);
                                    }
                                    if(m == 2){
                                    Mesaj4.getChildren().add(objetocarta);
                                    }
                                    if (m==3){
                                    Mesaj5.getChildren().add(objetocarta);
                                    }
                                   transplante = false;
                                   
                                   }

                                }

                    }

                });
                if(transplante==false){
                Mesaj1.getChildren().add(cartaSelec);
                Mesaj1List.add(cartaSelec);
                cartaSelec = null;
                }
            }

        }

//           Contador = 0;
//      }
    }
    private boolean Existe(){
        

        for (int i = 0; i < Mesaj1List.size(); i++) {
                System.out.println(Mesaj1List.get(i).nombre);
                if (Mesaj1List.get(i).nombre == cartaSelec.nombre) {
                   
                    return true;
                }
            }
        return false;
    }

    private void infectar() {

        Cartas objetocarta;
        objetocarta = cartaSelec;

//        if (cartaSelec != null) {
//             
//            System.out.println("va por aqui");
//            
//            if(cartaSelec.nombre == "Virus_rojo"){
//                
//                System.out.println("entraaaa");
//                
//                
//                
//                     System.out.println("entraaaa");
//                     System.out.println(objetocarta.nombre);
//                     
//                    if(cartaSelec.nombre == "Corazón_rojo"){
//                        System.out.println("coraaaaaaaaaaaa");
//                    }
//             
//            
//            }
//       
//                }
    }

    private void Repartir(int i) {

        Cartas objetocarta;

        int rand;
        rand = (int) Math.floor(Math.random() * Maso.size());

        objetocarta = Maso.get(rand);
        objetocarta.setOnMouseClicked(e -> {
            //----------------------------------------------------------------------Infectar VIrus------------------------------------------------------------------------
            if (cartaSelec != null) {

               if(transplante==false){

                if (cartaSelec.nombre == "Virus_rojo"||cartaSelec.nombre == "Virus_multicolor") {

             

                    if (objetocarta.getNombre().equals("Corazón_rojo")) {
                        objetocarta.setImage(new Image("Imagenes/Corazón_rojo_infectado.png"));
                    }

                }
                
                if (cartaSelec.nombre == "Virus_azul"||cartaSelec.nombre == "Virus_multicolor") {
                    
                    if (objetocarta.getNombre().equals("Cerebro_azul")) {
                       
                        objetocarta.setImage(new Image("Imagenes/Cerebro_azul_infectado.png"));
                    }
                }
                
                 if (cartaSelec.nombre == "Virus_verde"||cartaSelec.nombre == "Virus_multicolor") {
                    
                    if (objetocarta.getNombre().equals("Estomago_verde")) {
                       
                        objetocarta.setImage(new Image("Imagenes/Estomago_verde_infectado.png"));
                    }
                }
                 
                  if (cartaSelec.nombre == "Virus_amarillo"||cartaSelec.nombre == "Virus_multicolor") {
                    
                    if (objetocarta.getNombre().equals("Hueso_amarillo")) {
                       
                        objetocarta.setImage(new Image("Imagenes/Hueso_amarillo_infectado.png"));
                    }
                }

            }
            }
                if(transplante == true){
                    if(objetocarta.nombre == "Corazón_rojo" || objetocarta.nombre == "Cerebro_azul" || objetocarta.nombre == "Estomago_verde" || objetocarta.nombre == "Hueso_amarillo" || objetocarta.nombre == "Organo_multicolor") {
               
                    cartaSelec = objetocarta;
                       
                        if (i < 3) {
                            m=1;
                        } else if (i < 6) {
                            m=2;
                        } else if (i < 9) {
                            m=3;
                        }
                    }
              
        
            }
        });

        if (i < 3) {
            Mesaj3.getChildren().add(objetocarta);

            Mano.add(objetocarta);
            Maso.remove(Maso.get(rand));

        } else if (i < 6) {
            Mesaj4.getChildren().add(objetocarta);

            Mano2.add(objetocarta);
            Maso.remove(Maso.get(rand));

        } else if (i < 9) {
            Mesaj5.getChildren().add(objetocarta);

            Mano3.add(objetocarta);
            Maso.remove(Maso.get(rand));

        }

    }
                

}
