package ui;

import dao.Restaurante;
import domain.Plato;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RestauranteController {
    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Plato> carta;
    @FXML
    private TableColumn<Plato, String> nombre;
    @FXML
    private TableColumn<Plato, String> tipo;
    @FXML
    private TableColumn<Plato, String> precio;
    @FXML
    private TableColumn<Plato, String> calorias;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}