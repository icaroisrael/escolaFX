
package controller;

import dao.AlunoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Aluno;
import view.Palco;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class FXMLCadastroAlunoController implements Initializable {

    @FXML
    private RadioButton rbF;

    @FXML
    private Button btSalvar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumero;

    @FXML
    private RadioButton rbM;

    @FXML
    void salvar(ActionEvent event) {
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setNumero(89);
        aluno.setNome("Israel");
        aluno.setSexo("M");
        
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setHeaderText("Esse é o cabeçalho...");
         alert.setContentText(dao.salvar(aluno));
         alert.showAndWait();
        Palco.telaPrincipal();

    }

    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
