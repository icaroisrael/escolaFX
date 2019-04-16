
package view;

import java.io.IOException;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author Israel
 */
public class Palco extends Application {
    
    @Override
    public void start(Stage stage) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLVisualizar.fxml"));
        
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Cadastro de Aluno");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
