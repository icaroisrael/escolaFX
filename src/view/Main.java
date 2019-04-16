package view;

import dao.AlunoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

/**
 *
 * @author Israel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> lista = new ArrayList<Aluno>();
        lista = dao.pesquisarAll();
        
        for(Aluno l : lista){
            System.out.println("Nome:" + l.getNome());
        }
    }
    
}
