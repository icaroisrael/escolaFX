
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoDAO {
    Connection con = null;
    public AlunoDAO(){
        con = Conexao.abrirConexao();
    }
    
    public List<Aluno> pesquisarAll(){
        List<Aluno> lista = new ArrayList<>();
        try {            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ALUNO");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setNumero(rs.getInt("numero"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo"));
                lista.add(aluno);                
            }
            return lista;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void pesquisar(int numero){}
    
}
