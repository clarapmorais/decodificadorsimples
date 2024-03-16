package cipherdecoder.gui;

import cipherdecoder.cifras.CifraDeCesar;
import cipherdecoder.morse.CodigoMorse;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterfaceGraficaDecodificador {

    private TextArea entradaTextArea;
    private TextArea saidaCesarTextArea;
    private TextArea saidaMorseTextArea;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Decodificador de Cifras");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label rotuloEntrada = new Label("Texto cifrado:");
        GridPane.setConstraints(rotuloEntrada, 0, 0);

        entradaTextArea = new TextArea();
        entradaTextArea.setPromptText("Insira o texto cifrado...");
        entradaTextArea.setWrapText(true);
        entradaTextArea.setPrefRowCount(6);
        entradaTextArea.setPrefColumnCount(20);
        GridPane.setConstraints(entradaTextArea, 1, 0);

        Button botaoDecodificar = new Button("Decodificar");
        botaoDecodificar.setOnAction(e -> decodificarTexto());
        GridPane.setConstraints(botaoDecodificar, 1, 1);

        Label rotuloSaidaCesar = new Label("Decifra de César:");
        GridPane.setConstraints(rotuloSaidaCesar, 0, 2);

        saidaCesarTextArea = new TextArea();
        saidaCesarTextArea.setEditable(false);
        saidaCesarTextArea.setWrapText(true);
        saidaCesarTextArea.setPrefRowCount(6);
        saidaCesarTextArea.setPrefColumnCount(20);
        GridPane.setConstraints(saidaCesarTextArea, 1, 2);

        Label rotuloSaidaMorse = new Label("Decifra de Morse:");
        GridPane.setConstraints(rotuloSaidaMorse, 0, 3);

        saidaMorseTextArea = new TextArea();
        saidaMorseTextArea.setEditable(false);
        saidaMorseTextArea.setWrapText(true);
        saidaMorseTextArea.setPrefRowCount(6);
        saidaMorseTextArea.setPrefColumnCount(20);
        GridPane.setConstraints(saidaMorseTextArea, 1, 3);

        grid.getChildren().addAll(rotuloEntrada, entradaTextArea, botaoDecodificar, rotuloSaidaCesar, saidaCesarTextArea,
                rotuloSaidaMorse, saidaMorseTextArea);

        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 
     */
    private void decodificarTexto() {
        String textoCifrado = entradaTextArea.getText();
        int deslocamentoCesar = 3; 

        String decifraCesar = CifraDeCesar.decifrar(textoCifrado, deslocamentoCesar);
        saidaCesarTextArea.setText(decifraCesar);

        String decifraMorse = CodigoMorse.decodificar(textoCifrado);
        saidaMorseTextArea.setText(decifraMorse);
    }
}
