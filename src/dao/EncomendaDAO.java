
package dao;
import database.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Encomenda;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class  EncomendaDAO {

   public static void cadastrarEncomenda(Encomenda encomenda) {
        String sql = "INSERT INTO Encomenda (origem, destino, posicao, dataPostagem, dataEntrega, status, chave, motorista) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            Connection conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, encomenda.getOrigem());
            ps.setString(2, encomenda.getDestino());
            ps.setString(3, encomenda.getPosicao());
            ps.setDate(4, new java.sql.Date(encomenda.getDataPostagem().getTime()));
            ps.setDate(5, new java.sql.Date(encomenda.getDataEntrega().getTime()));
            ps.setString(6, encomenda.getStatus());
            ps.setString(7, encomenda.getChave());
            ps.setString(8, encomenda.getMotorista());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Encomenda cadastrada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar encomenda no banco de dados");
            System.err.println(ex);
        }
    }
   
    public static void atualizarEncomenda(Encomenda encomenda) {
        String sql = "UPDATE encomenda SET origem=?, destino=?, posicao=?, dataPostagem=?, dataEntrega=?, "
                    + "status=?, motorista=? WHERE id=?";
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(encomenda.getOrigem()));
            ps.setString(2, encomenda.getDestino());
            ps.setString(3, encomenda.getPosicao());
            ps.setDate(4, new java.sql.Date(encomenda.getDataPostagem().getTime()));
            ps.setDate(5, new java.sql.Date(encomenda.getDataEntrega().getTime()));
            ps.setString(6, encomenda.getStatus());
            ps.setString(7, encomenda.getMotorista());
            ps.setString(8, String.valueOf(encomenda.getId()));

            // Executar a atualização
            ps.executeUpdate();
        
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar encomenda");
            System.err.println(ex);
        }
    }
    
    public static void buscarEncomenda(JTable tabela, String chave) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Origem", "Destino", "Posição", "Data de Postagem", "Entrega Prevista", "Status", "Motorista"}, 0);
        Connection a = ConnectionDB.getConnection();
        String sql = "SELECT id, origem, destino, posicao, DATE_FORMAT(dataPostagem, '%d/%m/%Y') as dataFormatada, DATE_FORMAT(dataEntrega, '%d/%m/%Y') as dataFormatada2, status, motorista FROM ENCOMENDA where chave = '" + chave + "'  ORDER BY id";
        try {
            Statement st = a.createStatement();
            ResultSet executeQuery = st.executeQuery(sql);
            while (executeQuery.next()) { 
                Object linha[] = new Object[]{
                    executeQuery.getString("id"),
                    executeQuery.getString("origem"),
                    executeQuery.getString("destino"),
                    executeQuery.getString("posicao"),
                    executeQuery.getString("dataFormatada"), // Usando o alias definido na consulta
                    executeQuery.getString("dataFormatada2"),
                    executeQuery.getString("status"),
                    executeQuery.getString("motorista")
                };
                modelo.addRow(linha);
            }
            tabela.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean validarMotorista(String usuario) {
        String sql = "SELECT * FROM USUARIO WHERE NIVEL_PERMISSAO = 'MOTORISTA' AND usuario = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean motoristaValido = false;

        try {
            Connection conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);

            // Executar a consulta
            rs = ps.executeQuery();

            // Verificar se um motorista válido foi encontrado
            if (rs.next()) {
                motoristaValido = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao validar motorista");
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
     }

     return motoristaValido;
 }
    
    public static boolean validarChave(String chave) {
        String sql = "SELECT * FROM encomenda WHERE chave = '" + chave + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean chaveValida = false;

        try {
            Connection conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(sql);

            // Executar a consulta
            rs = ps.executeQuery();

            // Verificar se um motorista válido foi encontrado
            if (rs.next()) {
                chaveValida = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao validar motorista");
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
     }

     return chaveValida;
 }

    
      public static void deletarEncomenda(int id) {
          String sql = "DELETE FROM Encomenda WHERE id = ?";
          PreparedStatement ps = null;
        try {
            ps = ConnectionDB.getConnection().prepareStatement(sql);
            ps.setString(1, String.valueOf(id));
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar deletar encomenda");
            e.printStackTrace();
        }
    }
    

}
