/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.TelaAdministrativo;
import view.TelaGerencia;


/**
 *
 * @author Vinícius Pires de Morais
 */
public class LoginDAO {
    
    
public void CadastrarUsuario(String nome, String CPF, String email, String cargo, String usuario, String senha ) throws SQLException {
    Connection conexao = new ConnectionDB().getConnection();
    
    System.out.println("Valores recebidos na função de cadastro:");
    System.out.println("nome: " + nome);
    System.out.println("CPF: " + CPF);
    System.out.println("email: " + email);
    System.out.println("cargo: " + cargo);
    System.out.println("usuário: " + usuario);
    System.out.println("senha: " + senha);
    
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
    
    statement.close();
    conexao.close();
}

    public String getNivelPermissao(String usuario, String senha) {
        String nivelPermissao = null;

        try {
            Connection conexao = ConnectionDB.getConnection();
            String sql = "SELECT nivel_permissao FROM login WHERE usuario = ? AND senha = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, usuario);
                statement.setString(2, senha);
                
                ResultSet rs = statement.executeQuery();
                
                if (rs.next()) {
                    nivelPermissao = rs.getString("nivel_permissao");
                }
            }
           
        } catch (SQLException ex) {
            System.err.println("Erro ao executar a consulta: " + ex.getMessage());
        }

        return nivelPermissao;
    }
    public boolean verificarEmailExistente(String email) throws SQLException {
        int count;
    try (Connection conexao = ConnectionDB.getConnection()) {
        String sql = "SELECT COUNT(*) FROM login WHERE email = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next(); // Move para a primeira linha do resultado
        count = resultSet.getInt(1);
    }
    
    return count > 0; // Retorna true se o e-mail existe, false caso contrário
}
    public String recuperarSenhaPorEmail(String email) throws SQLException {
    Connection conexao = ConnectionDB.getConnection();
    String sql = "SELECT senha FROM login WHERE email = ?";
    
    try (PreparedStatement statement = conexao.prepareStatement(sql)) {
        statement.setString(1, email);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString("senha");
            }
        }
    }
    
    
    
    return null; // Retorna null se o e-mail não for encontrado
}
    public boolean verificarEmailECPFExistente(String email, String cpf) throws SQLException {
        String sql = "SELECT * FROM login WHERE email = ? AND CPF = ?";

        try (
            Connection conexao = ConnectionDB.getConnection();
            PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, cpf);
            
            

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Retorna true se existe um registro com o e-mail e CPF fornecidos
            }
        }
    }
    public String recuperarNomeUsuarioPorEmail(String email) throws SQLException {
    String nomeUsuario = null;

    try (Connection conexao = ConnectionDB.getConnection()) {
        String sql = "SELECT usuario FROM login WHERE email = ?";
        
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    nomeUsuario = resultSet.getString("usuario");
                }
            }
        }
    }

    return nomeUsuario;
}
    public void alterarSenhaPorEmail(String email, String novaSenha) throws SQLException {
        String sql = "UPDATE login SET senha = ? WHERE email = ?";

        try (Connection conexao = ConnectionDB.getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, novaSenha);
            statement.setString(2, email);

            statement.executeUpdate();
        }
    }
      public String recuperarUsuarioPorCPF(String usuario) throws SQLException {
        Connection conexao = ConnectionDB.getConnection();
        String sql = "SELECT CPF FROM login WHERE usuario = ?";
        
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, usuario);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getString("CPF");
            }
        } catch (SQLException ex) {
            // Trate a exceção adequadamente
            
        } finally {
            ConnectionDB.closeConnection();
        }
        
        return null; // Retorna null se não encontrar o CPF
    }

    
    
    
 public boolean login(String usuario, String senha) {
    try {
        Connection conexao = ConnectionDB.getConnection();
        String sql = "SELECT usuario, senha, nivel_permissao FROM login WHERE usuario = ? AND senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario);
        statement.setString(2, senha);
        
        ResultSet rs = statement.executeQuery();
        
        if (rs.next()) {
            String nivelPermissao = rs.getString("nivel_permissao");
            
            if ("Administrativo".equals(nivelPermissao)) {
                TelaAdministrativo admFrame = new TelaAdministrativo();
                admFrame.setVisible(true);
            } else if ("Gerente".equals(nivelPermissao)) {
                TelaGerencia gerencia = new TelaGerencia();
                gerencia.setVisible(true);
            } 
             else {
                // Nível de permissão inválido
                System.out.println("Nível de permissão inválido");
            }
            
            rs.close();
            statement.close();
            conexao.close();
            
            return true; // Retorna true para indicar sucesso no login
        } else {
            System.out.println("Não Existe");
            return false; // Retorna false para indicar falha no login
        }
        
    } catch (SQLException ex) {
        System.err.println("Erro ao executar a consulta: " + ex.getMessage());
        return false;
    }
}

    
}
