/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginController;

import dao.LoginDAO;
import database.ConnectionDB;
import java.awt.Component;
import view.Cadastroview;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Loginview;
import view.TelaAdministrativo;
import view.TelaGerencia;


/**
 *
 * @author Vincius Pires de Morais
 */
public class LoginController {

    private Component rootPane;
   public void cadastroUsuario(Cadastroview view, String codigoGerente) throws SQLException {
    Connection conexao = new ConnectionDB().getConnection();
    

    try {
        LoginDAO cadastro = new LoginDAO();
        cadastro.CadastrarUsuario(view.getjTextFieldNome().getText(), view.getjTextFieldCPF().getText(), 
            view.getjTextField1Email().getText(), (String) view.getjComboBoxCargo().getSelectedItem(), 
            view.getjTextFieldUSUARIO().getText(), view.getjPasswordFieldSenha().getText());

        JOptionPane.showMessageDialog(rootPane, "LOGIN CRIADO COM SUCESSO");
    } catch (SQLException sql) {
        // Tratar exceção, se necessário
    } if (conexao != null) {
            conexao.close();
    }
}

  public void loginUsuario(Loginview view) throws SQLException {
    String usuario = view.getjTextField1Usuario().getText();
    String senha = view.getjPasswordField1Senha().getText();

    LoginDAO loginDAO = new LoginDAO();
    String nivelPermissao = loginDAO.getNivelPermissao(usuario, senha);

    if (nivelPermissao != null) {
    switch (nivelPermissao) {
        case "Administrativo":
           TelaAdministrativo admFrame = new TelaAdministrativo();
               admFrame.setVisible(true);
                view.dispose();
            break; // Lembre-se de adicionar o break para cada case
        case "Gerente":
            TelaGerencia gerenciaFrame = new TelaGerencia();
               gerenciaFrame.setVisible(true);
                view.dispose();
            break; // Lembre-se de adicionar o break para cada case
        default:
            JOptionPane.showMessageDialog(view, "Nível de permissão inválido");
            break; // Lembre-se de adicionar o break para o default
    }
} else {
        JOptionPane.showMessageDialog(view, "Credenciais inválidas\nNome de usuário ou senha inválida");
    }
}
}
    


   
