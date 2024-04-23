package mx.arturogil.uithreadexample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private ProgressBar progressBar;

    @FXML
    protected void onHelloButtonClick() throws InterruptedException {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
                Platform.runLater(()-> welcomeText.setText("Welcome to JavaFX Application!"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private Thread progressBarThread;

    @FXML
    protected void startProgressBar(ActionEvent e) throws InterruptedException {
        if(progressBarThread != null) {
            progressBarThread.interrupt();
            progressBarThread = null;
        }

        progressBar.setProgress(0);
        progressBarThread = new Thread(() -> {
            while (progressBar.getProgress() < 1) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    Platform.runLater(() -> progressBar.setProgress(progressBar.getProgress() + 0.001));
                } catch (InterruptedException ex) {
                    break;
                }
            }
        });
        progressBarThread.start();
    }
}