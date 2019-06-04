
package controller;

import dao.AlunoDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Aluno;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class FXMLVisualizarController implements Initializable {
    @FXML private TableColumn<Aluno, Integer> colN;
    @FXML private TableColumn<Aluno, String> colNome;
    @FXML private TableView<Aluno> tabela;
    @FXML private TableColumn<Aluno, String> colSexo;
    AlunoDAO dao = new AlunoDAO();
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        mostrarTabela();
    }    

    
        
    @FXML
    public void btExcluir(){        
        Aluno aluno = new Aluno();
        aluno = tabela.getSelectionModel().getSelectedItem();        
        if(aluno != null){
            AlunoDAO dao = new AlunoDAO();
            if(dao.deletar(aluno.getNumero())){
                Alert alert = new Alert(Alert.AlertType.WARNING);            
                alert.setTitle("Exclusão com sucesso");
                alert.setHeaderText("Exclusão");
                alert.setContentText("Dados excluidos com sucesso");
                alert.showAndWait();
                mostrarTabela();
            }else{
                System.out.println("Erro ao excluir");
            }                             
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);            
            alert.setTitle("Exclusão");
            alert.setHeaderText("Cabeçalho do alerta");
            alert.setContentText("Você deve selecionar um aluno para excluir");
            alert.show();
        }        
    }

    public void mostrarTabela(){
        colN.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));         
        tabela.setItems(listaAlunos());
    }
    public ObservableList<Aluno> listaAlunos(){
        List<Aluno> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);        
    }
}
