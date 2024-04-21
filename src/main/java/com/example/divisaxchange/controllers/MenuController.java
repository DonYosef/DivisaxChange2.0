package com.example.divisaxchange.controllers;

import com.example.divisaxchange.HelloApplication;
import com.example.divisaxchange.NuevaVentana;
import com.example.divisaxchange.models.DivisaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuController {


    public ComboBox comboDesdeMenu;
    public ComboBox comboHaciaMenu;
    public TextField inputMenu;
    public Button btnMenu;

    HelloApplication main = new HelloApplication();
    CalculoDivisas calDi = new CalculoDivisas();
    ComunicacionAPI comAPI = new ComunicacionAPI();
    NuevaVentana nuevaVen = new NuevaVentana();

    DivisaModel rate = null;
    String resultado;



    ObservableList<String> lista = FXCollections.observableArrayList("USD", "CLP","ARS","BRL");

    public void btnClick(MouseEvent mouseEvent) {

        String base = comboDesdeMenu.getSelectionModel().getSelectedItem().toString();
        String target = comboHaciaMenu.getSelectionModel().getSelectedItem().toString();

        try {
            //Comunicacion con API externa, en funcion de los parametros de ambos combobox
            rate = comAPI.informacionAPI(base, target);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (target.equalsIgnoreCase("USD")){
            resultado = String.valueOf(calDi.redondear(calDi.convercionDeMoneda(rate.conversion_rate(),Double.parseDouble(inputMenu.getText()))));
        }else{
            resultado = String.valueOf(calDi.redondearSinDecimal(calDi.convercionDeMoneda(rate.conversion_rate(),Double.parseDouble(inputMenu.getText()))));

        }

        try {
            //Se abre nueva ventana para mostrar resultado
            nuevaVen.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Se reinicia el Input para ingresar cantidad a convertir
        inputMenu.setText("");
        main.llenarCombo(comboDesdeMenu, lista);
        main.llenarCombo(comboHaciaMenu, lista);

        //Se envia informacion del resultado al label que muestra dicha información
        NuevaVentana.llenarLabel(resultado);

    }

    public void desdeMethod(Event event) {
        main.llenarCombo(comboDesdeMenu, lista);
    }

    public void haciaMethod(Event event) {
        main.llenarCombo(comboHaciaMenu, lista);
    }



}
