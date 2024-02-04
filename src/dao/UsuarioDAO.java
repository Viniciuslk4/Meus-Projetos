
package dao;

import database.ConnectionDB;
import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class UsuarioDAO {

    
public void CadastrarUsuario(String nome, String CPF, String email, String cargo, String usuario, String senha, String codigoGerente ) 
        throws SQLException {
    Connection conexao = new ConnectionDB().getConnection();
  
    System.out.println("Valores recebidos na função de cadastro:");
    System.out.println("nome: " + nome);
    System.out.println("CPF: " + CPF);
    System.out.println("email: " + email);
    System.out.println("cargo: " + cargo);
    System.out.println("usuário: " + usuario);
    System.out.println("senha: " + senha);
    System.out.println("codigoGerente: " + codigoGerente);
    
    // Verifica se o cargo é gerente e se o código é válido
    if ("gerente".equalsIgnoreCase(cargo) && !"000000".equals(codigoGerente)) {
        System.out.println("Código de gerente inválido. Cadastro não realizado.");
        return; // Sai da função sem fazer o cadastro
    }
    
    String sql = "INSERT INTO login (nome, email, CPF, nivel_permissao, usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = conexao.prepareStatement(sql);
    statement.setString(1, nome);
    statement.setString(2, email);
    statement.setString(3, CPF);
    statement.setString(4, cargo);
    statement.setString(5, usuario);
    statement.setString(6, senha);
    
    System.out.println("SQL executado: " + sql);
    
    statement.execute();
    
    System.out.println("Inserção no banco de dados realizada com sucesso.");
    
    
    conexao.close();
}


    
    public static boolean validarUsuario(Usuario usuario) {
        String sql = "SELECT COUNT(*) FROM login WHERE usuario = ? AND senha=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());

            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Retorna true se o usuário já existir no banco de dados
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return false; // Retorna false em caso de erro ou se o usuário não existir
    }
    
    public void deletarUsuario(Usuario usuario) {
          String sql = "DELETE FROM Usuario WHERE nome = ? AND senha=?";
          PreparedStatement ps = null;
        try {
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            ps.setString(1, String.valueOf(usuario.getNome()));
            ps.setString(1, String.valueOf(usuario.getSenha()));
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar deletar usuário");
            e.printStackTrace();
        }
    }

}
