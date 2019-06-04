
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

    

    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void salvar(ActionEvent event) {
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setNumero(Integer.parseInt(txtNumero.getText()));
        aluno.setNome(txtNome.getText());
        if(rbM.isSelected()){
            aluno.setSexo("M");
        }else if(rbF.isSelected()){
            aluno.setSexo("F");
        }       
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setHeaderText("Cadastro de Aluno");
         alert.setContentText(dao.salvar(aluno));
         alert.show();
         Palco.telaPrincipal();
    }
    public void limpaCampos(){
        rbM.setSelected(false);
        rbF.setSelected(false);
        txtNumero.setText("");
        txtNome.setText("");
    }
}
