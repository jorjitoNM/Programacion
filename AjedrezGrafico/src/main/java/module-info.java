module org.example.ajedrezgrafico {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ajedrezgrafico to javafx.fxml;
    exports org.example.ajedrezgrafico;
}