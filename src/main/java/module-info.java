module mx.arturogil.uithreadexample {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens mx.arturogil.uithreadexample to javafx.fxml;
    exports mx.arturogil.uithreadexample;
}