
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
    public String salvar(Aluno aluno){        
        try {
            String sql = "INSERT INTO ALUNO(NUMERO, NOME, SEXO, USER) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, aluno.getNumero());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getSexo());
             ps.setInt(4, 1);
            if(ps.executeUpdate() != 0){
                return "Cadastrado com sucesso";
            }else{
                return "Erro ao cadastrar";
            }
        } catch (Exception e) {
            return "Deu erro";
        }
    }
    
    public boolean deletar(int numero){
        try {
            String sql = "DELETE FROM ALUNO WHERE NUMERO = '"+numero+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void atualizar(Aluno aluno){
        try {
            String sql = "UPDATE ALUNO SET NOME = ?, SEXO = ? WHERE NUMERO = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getSexo());
            ps.setInt(3, aluno.getNumero());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
