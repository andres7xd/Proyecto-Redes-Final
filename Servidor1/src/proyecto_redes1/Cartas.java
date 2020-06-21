/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_redes1;

import java.io.Serializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author andre
 */
public class Cartas extends ImageView implements Serializable {
//    Image Imagen;
    // ImageView ImagenV;

    private static final long serialVersionUID = 6529685098267757694L;
    public static Cartas cart;
    public String color;
    public String nombre;
    public String URL;
    private int numerocarta;
    public static boolean Seleccionada;

    public Cartas(String tipo, String nombre, String URL) {

        this.Seleccionada = false;
        this.color = tipo;
        this.nombre = nombre;
        this.URL = URL;
//        this.Imagen = new Image(URL);
        this.setImage(new Image(URL));

        this.setFitHeight(120);
        this.setFitWidth(80);

        this.setOnMouseClicked(e -> {
            System.out.println(color);
            Seleccionada = true;

        });
    }

    public String getTipo() {
        return color;
    }

    public void setTipo(String tipo) {
        this.color = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumerocarta(int numerocarta) {
        this.numerocarta = numerocarta;
    }

    public int getNumerocarta() {
        return numerocarta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

}
