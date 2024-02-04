/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import LoginController.LoginController;
import dao.LoginDAO;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import view.Cadastroview;
/**
 *
 * @author Vinícius Pires de Morais
 */
public class Loginview extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Loginview() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
public void mostrarDialogoRecuperacaoConta() throws SQLException {
    boolean continuar = true;
    
    while (continuar) {
        String email = JOptionPane.showInputDialog(null, "Digite o seu e-mail de recuperação:");

        if (email != null && !email.isEmpty()) {
            LoginDAO loginDAO = new LoginDAO();
            boolean emailExistente = loginDAO.verificarEmailExistente(email);

            if (emailExistente) {
                String cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF de recuperação:");

                if (cpf != null && !cpf.isEmpty()) {
                    boolean emailECPFExistente = loginDAO.verificarEmailECPFExistente(email, cpf);

                    if (emailECPFExistente) {
                        String novaSenha = JOptionPane.showInputDialog(null, "Digite a nova senha:");

                        if (novaSenha != null && !novaSenha.isEmpty()) {
                            // Alterar a senha no banco de dados
                            loginDAO.alterarSenhaPorEmail(email, novaSenha);

                            String usuarioRecuperado = loginDAO.recuperarNomeUsuarioPorEmail(email);
                            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!\nUsuário: " + usuarioRecuperado +
                                                              "\nNova Senha: " + novaSenha);
                            continuar = false; // Encerra o loop após sucesso
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, insira uma nova senha válida.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "CPF informado inválido. ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um CPF válido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar sua conta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, insira um e-mail válido.");
        }
        
        if (continuar) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja tentar novamente?", "Recuperação de Conta", JOptionPane.YES_NO_OPTION);
            if (resposta != JOptionPane.YES_OPTION) {
                continuar = false; // Encerra o loop se o usuário não quiser tentar novamente
            }
        }
    }
}

    // ... outras partes da classe ...

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1Usuario = new javax.swing.JTextField();
        jPasswordField1Senha = new javax.swing.JPasswordField();
        jButton1Entrar = new javax.swing.JButton();
        jButton2Cadastro = new javax.swing.JButton();
        jButtonRecuperarSenha = new javax.swing.JButton();
        jButtonRastrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField1Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 250, 30));
        getContentPane().add(jPasswordField1Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 250, 30));

        jButton1Entrar.setContentAreaFilled(false);
        jButton1Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1EntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 170, 60));

        jButton2Cadastro.setContentAreaFilled(false);
        jButton2Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2CadastroActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2Cadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 180, 60));

        jButtonRecuperarSenha.setContentAreaFilled(false);
        jButtonRecuperarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecuperarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRecuperarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 570, 150, 60));

        jButtonRastrear.setContentAreaFilled(false);
        jButtonRastrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRastrearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRastrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 180, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LOGIN.png"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1EntrarActionPerformed
                                              
        if (jTextField1Usuario.getText().isEmpty() || jPasswordField1Senha.getText().isEmpty()) {
        JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
    } else {
        try {
            LoginController loginController = new LoginController();
            Loginview loginView = this; 
            loginController.loginUsuario(loginView);
        } catch (SQLException SQL) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao executar a consulta: " + SQL.getMessage());
           
        }
    }




      
    }//GEN-LAST:event_jButton1EntrarActionPerformed

    private void jButtonRastrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRastrearActionPerformed
        TelaRastreio telaRastreio = new TelaRastreio();
        telaRastreio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRastrearActionPerformed

    private void jButtonRecuperarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecuperarSenhaActionPerformed
        try {
            mostrarDialogoRecuperacaoConta();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   


    }//GEN-LAST:event_jButtonRecuperarSenhaActionPerformed

    private void jButton2CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2CadastroActionPerformed
    Cadastroview telaDeCadastro = new Cadastroview(this);
    this.setVisible(false);
    telaDeCadastro.setVisible(true);
    
    }//GEN-LAST:event_jButton2CadastroActionPerformed
            
    

    public JPasswordField getjPasswordField1Senha() {
        return jPasswordField1Senha;
    }

    public void setjPasswordField1Senha(JPasswordField jPasswordField1Senha) {
        this.jPasswordField1Senha = jPasswordField1Senha;
    }

    public JTextField getjTextField1Usuario() {
        return jTextField1Usuario;
    }

    /**
     * @param args the command line arguments
     */
    public void setjTextField1Usuario(JTextField jTextField1Usuario) {    
        this.jTextField1Usuario = jTextField1Usuario;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Entrar;
    private javax.swing.JButton jButton2Cadastro;
    private javax.swing.JButton jButtonRastrear;
    private javax.swing.JButton jButtonRecuperarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1Senha;
    private javax.swing.JTextField jTextField1Usuario;
    // End of variables declaration//GEN-END:variables
}
