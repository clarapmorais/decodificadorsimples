package cipherdecoder;

import cipherdecoder.gui.InterfaceGraficaDecodificador;
import javafx.application.Application;
import javafx.stage.Stage;

public class AplicativoDecodificador extends Application {

    @Override
    public void start(Stage primaryStage) {
        InterfaceGraficaDecodificador gui = new InterfaceGraficaDecodificador();
        gui.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
