module org.example.restaurantefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.restaurantefx to javafx.fxml;
    exports org.example.restaurantefx;
    exports ui;
    opens ui to javafx.fxml;
}