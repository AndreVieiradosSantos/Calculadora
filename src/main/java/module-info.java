module com.calculadora.calculadora {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calculadora.calculadora to javafx.fxml;
    exports com.calculadora.calculadora;
}