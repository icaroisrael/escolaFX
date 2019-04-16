package controller;

import dao.AlunoDAO;
import java.net.URL;
import java.util.ArrayList;
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
public class FXMLController implements Initializable {
    
    @FXML private TableView<Aluno> tabela;
    @FXML private TableColumn<Aluno, String> cNome;
    @FXML private TableColumn<Aluno, String> cSexo;
    @FXML private TableColumn<Aluno, Integer> cNumero;
    AlunoDAO dao = new AlunoDAO();
   

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializeTable();
    }    

    private void inicializeTable() {
      cNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
       cNome.setCellValueFactory(  new PropertyValueFactory<>("nome"));
       cSexo.setCellValueFactory(  new PropertyValueFactory<>("sexo"));       
       tabela.setItems(listarAluno());
    }

    private ObservableList<Aluno> listarAluno() {
        List<Aluno> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);
        
    }
    
}
