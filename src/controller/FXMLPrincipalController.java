
package controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import view.Palco;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class FXMLPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
      @FXML
    void cadatrar(ActionEvent event)  {
          Palco.cadastroAluno();
    }
    
     @FXML
    void pesquisar(ActionEvent event) {
        Palco.mostrarAluno();

    }

}
