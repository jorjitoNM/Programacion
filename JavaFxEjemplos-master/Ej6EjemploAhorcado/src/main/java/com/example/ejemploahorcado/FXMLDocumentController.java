package com.example.ejemploahorcado;

import com.example.ejemploahorcado.java.common.Constantes;
import com.example.ejemploahorcado.java.domain.Juego;
import com.example.ejemploahorcado.java.service.GestionPalabras;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.nio.BufferUnderflowException;
import java.util.Optional;
import java.util.ResourceBundle;


public class FXMLDocumentController implements Initializable {

    @FXML
    private GridPane mainGrid;
    @FXML
    private Label palabra;
    @FXML
    private Label fallos;
    @FXML
    private Button boton;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField entrada;
    @FXML
    private Button nuevaPartida;
    @FXML
    private Button retomarPartida;
    @FXML
    private Button aleatorio;
    @FXML
    private Button categoria;
    @FXML
    private Button dificultad;
    @FXML
    private Button personalizada;
    private int errores;  //fallos
    private Juego partida;
    private String adivinar; //en este label podemos ir poniendo ____ y destapando
    private GestionPalabras servicio = new GestionPalabras();
    @FXML
    private DialogPane startDialog;
    @FXML
    private DialogPane menuInicio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dialogoInicial();
        mostrarTablero();
    }


    private void mostrarTablero() {
        Pane pane;
        char caracter = 'A';
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 7; j++, caracter++) {
                pane = new Pane();
                if (i * 8 + j < 26) {
                    if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                        pane.setStyle("-fx-background-color: #07004f;");
                    } else {
                        pane.setStyle("-fx-background-color: #081d3d");
                    }
                    Label letra = new Label(String.valueOf(caracter));
                    letra.setTextFill(Color.web("#ffffff"));
                    //letra.setTextFill(Color.WHITE);
                    pane.getChildren().addAll(letra);
                    letra.layoutXProperty().bind(pane.widthProperty().subtract(letra.widthProperty()).divide(3));
                    letra.layoutYProperty().bind(pane.heightProperty().subtract(letra.heightProperty()).divide(3));
                    mainGrid.add(pane, j, i);
                    String message = "Click on cell [" + i + ", " + j + "]";
                    int fila = i;
                    int columna = j;
                    pane.setOnMouseClicked(e -> {
                        System.out.println(message);
                        try {
                            accion(fila, columna);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                }
            }
        }
    }

    private void accion(int fila, int columna) throws IOException {
        errores = partida.getErrores();
        if (errores != 7) {
            int posicion_pulsada = fila * 8 + columna + 65;
            String letra_pulsada = String.valueOf((char) posicion_pulsada);
            System.out.println("Letra pulsada" + letra_pulsada);
            palabra.setText(partida.imprimirRayas(letra_pulsada));
            fallos.setText("Fallos: " + errores + "/7");
            imagen.setImage(new Image("File:src/main/resources/com/example/ejemploahorcado/images/" + errores + ".png"));
        }
        if (errores == 7)
            palabra.setText("Has perdido");
    }
    public void dialogoInicial () {
        menuInicio = new DialogPane();
        visibilidadBotonesJuego(true);
        visibilidadBotonesRonda(false);
        Label informacion = new Label(Constantes.ELIGAOPCION);
        Button nuevaPartida = new Button(Constantes.NUEVAPARTIDA);
        Button retomarPartida  = new Button(Constantes.RETOMARPARTIDA);
        nuevaPartida.setOnAction(this::nuevaPartida);
        retomarPartida.setOnAction(this::retomarPartida);
        menuInicio.setHeaderText("Bienvenido al Ahorcado");
        menuInicio.setContent(new VBox(informacion,nuevaPartida,retomarPartida));
        menuInicio.visibleProperty().set(true);
    }


    public void nuevaPartida (ActionEvent actionEvent) {
        if (!partidaIniciada()) {
            try {
                partida = new Juego();
                visibilidadBotonesJuego(false);
                visibilidadBotonesRonda(true);
                opcionesRonda();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void opcionesRonda() {
        aleatorio.setOnAction(this::nuevaRonda);
        categoria.setOnAction(this::nuevaRondaCategoria);
        dificultad.setOnAction(this::nuevaRondaDificultad);
        personalizada.setOnAction(this::nuevaRondaPersonalizada);
    }
    public void retomarPartida (ActionEvent actionEvent) {
        try {
            servicio.retomarPartida(0);
            menuVisibilidad(false);
        } catch (IOException e) {
            throw new RuntimeException(Constantes.IOEXCEPTION);
        }
    }

    public void nuevaRondaCategoria(ActionEvent actionEvent) {
        Alert categoria = new Alert(Alert.AlertType.CONFIRMATION);
        //TextInputDialog categoria = new TextInputDialog("Introduzca la categoria");
        categoria.setHeaderText(Constantes.INTRODUCIRCATEGORIA);

        ButtonType movie = new ButtonType("Movie");
        ButtonType basketball = new ButtonType("Basketball");
        ButtonType dessert = new ButtonType("Dessert");
        ButtonType yodaquotes = new ButtonType("YodaQuotes");
        categoria.getButtonTypes().setAll(basketball,dessert,movie,yodaquotes);

        Optional<ButtonType> resultado = categoria.showAndWait();
        try {
            partida.nuevaRonda(servicio.palabraAleatoriaCategoria(resultado.get().getText()));
            menuVisibilidad(false);
        } catch (NumberFormatException exception) {
            categoria.setHeaderText(Constantes.ENTRADANONUMERO);
        } catch (IOException exception) {
            throw new RuntimeException(Constantes.IOEXCEPTION);
        }

    }
    public void nuevaRonda(ActionEvent actionEvent) {
        try {
            partida.nuevaRonda(servicio.palabraAleatoria());
            menuVisibilidad(false);
        } catch (IOException e) {
            throw new RuntimeException(Constantes.IOEXCEPTION);
        }
    }
    public void nuevaRondaDificultad(ActionEvent actionEvent) {
        TextInputDialog dificultad = new TextInputDialog("Introduzca la categoria");
        dificultad.setHeaderText(Constantes.INTRODUCIRCATEGORIA);
        dificultad.showAndWait();
        try {
            partida.nuevaRonda(servicio.palabraAleatoriaDificultad(Integer.parseInt(dificultad.getContentText())));
            menuVisibilidad(false);
        } catch (NumberFormatException exception) {
            dificultad.setHeaderText(Constantes.ENTRADANONUMERO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void nuevaRondaPersonalizada(ActionEvent actionEvent) {
        TextInputDialog palabra = new TextInputDialog("Introduzca la palabra a adivinar");
        palabra.setHeaderText(Constantes.NUEVAPALABRA);
        palabra.showAndWait();
        try {
            partida.nuevaRondaPersonalizada(palabra.getContentText());
            menuVisibilidad(false);
        } catch (NumberFormatException exception) {
            palabra.setHeaderText(Constantes.ENTRADANONUMERO);
        } catch (IOException exception) {
            throw new RuntimeException(Constantes.IOEXCEPTION);
        }

    }

    public boolean partidaIniciada () {
        return partida==null;
    }
    private void menuVisibilidad (Boolean estado) {
        startDialog.visibleProperty().set(estado);
    }
    private void visibilidadBotonesJuego (Boolean estado) {
        retomarPartida.visibleProperty().set(estado);
        nuevaPartida.visibleProperty().set(estado);
    }
    private void visibilidadBotonesRonda(Boolean estado) {
        aleatorio.visibleProperty().set(estado);
        categoria.visibleProperty().set(estado);
        dificultad.visibleProperty().set(estado);
        personalizada.visibleProperty().set(estado);
    }
}
