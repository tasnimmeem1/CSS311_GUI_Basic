module org.example.css311_gui_basic {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.css311_gui_basic to javafx.fxml;
    exports org.example.css311_gui_basic;
}