package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDB {
    private static final String url = "jdbc:mysql://localhost:3306/bd_rastreioExpress";
    private static final String user = "root";
    private static final String senha = "123456"; 
    
    private static Connection conn;
    
    public static Connection getConnection() throws SQLException {
        if(conn == null || conn.isClosed()) {
            try {
                conn = DriverManager.getConnection(url, user, senha);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar banco de dados");
                throw e; // Lança a exceção para ser tratada mais acima
            }
        }
        return conn;
    }
    
    public static void closeConnection() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar conexão com o BD");
                System.err.println("Falha ao tentar fechar conexão: " + e.getMessage());
            }
        }
    }
}