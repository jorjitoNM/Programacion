package com.example.ej3gridimageview;

import Ajedrez.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label mensajes;
    @FXML
    private Label turno;
    @FXML
    private GridPane mainGrid;
    private Tablero tablero;
    private Movimiento movimiento;
    private Juego partida;

    @FXML
    protected void onHelloButtonClick() {
        mensajes.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablero = new Tablero();
        pintarTablero();
        partida = new Juego();
        movimiento = new Movimiento();
        turno.setText("Mueven blancas");
    }
    public void accion(String coordenadas){
        String args[] = coordenadas.split(";");
        int fila = Integer.parseInt(args[0]);
        int columna = Integer.parseInt(args[1]);
        System.out.println(fila+"-"+columna);
    }

    private Posicion[] asistencia (Pieza pieza, Posicion posicionInicial) {
        Posicion[] posiciones;
        int contador = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieza.validoMovimiento(new Movimiento(posicionInicial, new Posicion(i, j)), tablero))
                    contador++;
            }
        }
        posiciones = new Posicion[contador];
        if (contador != 0) {
            for (int i = 0; i < contador; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        if (pieza.validoMovimiento(new Movimiento(posicionInicial, new Posicion(i, j)), tablero))
                            posiciones[i] = new Posicion(j, k);
                    }
                }
            }
        }
        return posiciones;
    }
    /**
     * Metodo que recibe las coordenadas del tablero pulsadas y contruye un movimiento (para crear un movimiento entero tiene que ejecutarse 2 veces)
     * @param x Coordenada x (fila)
     * @param y  Coordenada y (columna)
     */
    @FXML
    public void accion(int x, int y){
        System.out.println(x+"-"+y);
        if (movimiento.getPosInicial()==null) {
            movimiento.setPosInicial(new Posicion(x, y));
            mensajes.setText(tablero.devuelvePieza(movimiento.getPosInicial()).getNombre());
            for (int i = 0; i < asistencia(tablero.devuelvePieza(movimiento.getPosInicial()),movimiento.getPosInicial()).length; i++) {
                System.out.println(asistencia(tablero.devuelvePieza(movimiento.getPosInicial()),movimiento.getPosInicial())[i].toString());
            }
        }
        else if (movimiento.getPosInicial()!=null && movimiento.getPosFinal()==null) {
            movimiento.setPosFinal(new Posicion(x, y));
            String error =partida.validarMovimiento(movimiento,tablero,partida);
            if (error==null) {
                if (tablero.devuelvePieza(movimiento.getPosInicial()).validoMovimiento(movimiento,tablero)) {
                    Pieza pieza = tablero.devuelvePieza(movimiento.getPosInicial());
                    tablero.moverPieza(pieza, movimiento);
                    if (pieza instanceof Peon) {
                        if (movimiento.getPosFinal().getFila()==0 && pieza.getColor() || movimiento.getPosFinal().getFila()==7 && !pieza.getColor()) {
                            String result = coronacion(movimiento);
                            if (result.equals("caballo")) {
                                pieza = new Caballo(pieza.getColor());
                            } else if (result.equals("alfil")) {
                                pieza = new Alfil(pieza.getColor());
                            } else if (result.equals("dama")) {
                                pieza = new Dama(pieza.getColor());
                            } else if (result.equals("torre")) {
                                pieza = new Torre(pieza.getColor());
                            }
                            tablero.moverPieza(pieza,movimiento);
                        }
                    }
                    movimiento.setPosInicial(null);
                    movimiento.setPosFinal(null);
                    partida.setTurno();
                    mensajes.setText(null);
                    turno.setText(partida.darTurnoString());
                    pintarTablero();
                } else {
                    mensajes.setText(String.format("%s no puede realizar ese movimiento", tablero.devuelvePieza(movimiento.getPosInicial()).getClass().getSimpleName()));
                    movimiento.setPosInicial(null);
                    movimiento.setPosFinal(null);
                }
            } else {
                mensajes.setText(error);
                movimiento.setPosInicial(null);
                movimiento.setPosFinal(null);
            }
        }
    }
    public String coronacion (Movimiento movimiento) {
        boolean exit = false;

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Acabas de coronar. Escoge la pieza por la que quieres cambiar el peon (recuerda que no puede ser otro peon o un rey)");
                ButtonType dama = new ButtonType("dama");
                ButtonType caballo = new ButtonType("caballo");
                ButtonType alfil = new ButtonType("alfil");
                ButtonType torre = new ButtonType("torre");

                alert.getButtonTypes().setAll(dama, caballo, alfil, torre);
                Optional<ButtonType> result = alert.showAndWait();

            return result.get().getText();
    }


    private void pintarTablero() {
        Pane pane;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    pane.setStyle("-fx-background-color: #A9A9A9;");
                } else {
                    pane.setStyle("-fx-background-color: #FFFFFF");
                }
                if (tablero.hayPieza(i,j))
                    pane.getChildren().add(new ImageView(new Image(tablero.devuelvePieza(i,j).getRuta())));
                mainGrid.add(pane, j, i);
                String message = "Click on cell ["+i+", "+j+"]";
                String envio = i+";"+j;
                int fila = i;
                int columna = j;
                pane.setOnMouseClicked(e -> {
                    System.out.println(message);
                    //accion(envio);
                    accion(fila,columna);
                });
            }
        }
    }


    public void enroque(ActionEvent actionEvent) {

    }
}