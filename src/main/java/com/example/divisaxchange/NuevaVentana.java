package com.example.divisaxchange;

import com.example.divisaxchange.controllers.MenuController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevaVentana{

    public Button btnSalir;
    public static Label labelResult;
    public Button btnNuevaConversion;

    public static Stage stage;

    public void start() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NuevaVentana.class.getResource("NuevaVentana.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 400);
        stage = new Stage();
        stage.setTitle("Resultado de cambio");
        stage.setScene(scene);
        stage.show();

        labelResult = (Label) fxmlLoader.getNamespace().get("labelResult");
    }

    public void btnNuevaClick(MouseEvent mouseEvent) {
        stage.close();
    }

    public void btnSalirClick(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public static void llenarLabel(String resultado){;
        labelResult.setText(resultado);
    }

}
