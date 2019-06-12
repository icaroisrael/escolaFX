package controller;
import dao.AlunoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aluno;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class FXMLAtualizarAlunoController implements Initializable {
    @FXML private RadioButton rbF;
    @FXML private TextField txtNome;
    @FXML private TextField txtNumero;
    @FXML private RadioButton rbM;    
    private Stage stage;
    private boolean btnAtualizar = false;
    Aluno aluno = new Aluno();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isBtnSalvar() {
        return btnAtualizar;
    }

    public void setBtnSalvar(boolean btnSalvar) {
        this.btnAtualizar = btnSalvar;
    }
    @FXML
    void handleSalvar() {        
        aluno.setNumero(Integer.parseInt(txtNumero.getText()));
        aluno.setNome(txtNome.getText());
        if(rbM.isSelected()){
            aluno.setSexo("M");            
        }else{
            aluno.setSexo("F");
        }        
        btnAtualizar = true;
        stage.close();
        
    }

    @FXML
    void handleCancelar() {
        stage.close();
    }
    
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
        txtNumero.setText(String.valueOf(aluno.getNumero()));
        txtNome.setText(String.valueOf(aluno.getNome()));
        if(aluno.getSexo().equals("M")){
            rbM.setSelected(true);
        }else{
            rbF.setSelected(true);
        }
    }
    
    @FXML
    void handleRBM() {
        rbF.setSelected(false);        
    }

    @FXML
    void handleRBF() {
        rbM.setSelected(false);
    }
    
    
    
    
    
}
