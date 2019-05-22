
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
   static Stage palco;
   
 
   public static Scene sceneCadAluno;
   public static Scene sceneVisualizarAluno ;
   public static Scene scener;
    
    @Override
    public void start(Stage stage) throws IOException{
        palco = stage;
        //Carregar os FXMLs
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        Parent cadAluno =        FXMLLoader.load(getClass().getResource("FXMLCadastroAluno.fxml"));
        Parent visualizarAluno = FXMLLoader.load(getClass().getResource("FXMLVisualizar.fxml"));
        //Crio as scenas com os fxmls
         scener = new Scene(root, 600, 600);
         sceneCadAluno = new Scene(cadAluno, 600, 600);
         sceneVisualizarAluno = new Scene(visualizarAluno, 600, 600);
        stage.setTitle("Tela Principal");
        stage.setScene(scener);
        stage.setResizable(true);
        stage.show();
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void cadastroAluno(){
        palco.setTitle("Cadastro de Aluno");
        palco.setScene(sceneCadAluno);        
    }
    
    public static void mostrarAluno(){
        palco.setTitle("Visualizar Aluno");
        palco.setScene(sceneVisualizarAluno);
    }
    
    public static void telaPrincipal(){
        palco.setTitle("Tela Principal");
        palco.setScene(scener);
    }
    
    
}
