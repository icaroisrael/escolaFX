
package controller;

import dao.AlunoDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        
        initTabela();       
    }    

    public void initTabela() {
        
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
