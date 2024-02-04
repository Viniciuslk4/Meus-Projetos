
package view;

import dao.EncomendaDAO;
import database.ConnectionDB;
import java.awt.Color;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Encomenda;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaAdministrativo extends javax.swing.JFrame {


    public TelaAdministrativo() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        loadTableCadastro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_adm = new javax.swing.JPanel();
        header_decorativo = new javax.swing.JPanel();
        header_texto = new javax.swing.JLabel();
        btn_voltar_adm = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_encomenda_adm = new javax.swing.JTable();
        label_origem_adm = new javax.swing.JLabel();
        combobox_origem_adm = new javax.swing.JComboBox<>();
        label_destino_adm = new javax.swing.JLabel();
        combobox_destino_adm = new javax.swing.JComboBox<>();
        label_posicao_adm = new javax.swing.JLabel();
        combobox_posicao_adm = new javax.swing.JComboBox<>();
        input_dataPost_adm = new javax.swing.JFormattedTextField();
        labelestimativa_adm = new javax.swing.JLabel();
        input_estimativa_adm = new javax.swing.JFormattedTextField();
        label_dataPost_adm = new javax.swing.JLabel();
        label_situacao_adm = new javax.swing.JLabel();
        combobox_situacao_adm = new javax.swing.JComboBox<>();
        label_chave_adm = new javax.swing.JLabel();
        btn_editar_adm = new javax.swing.JButton();
        btn_cadastrar_adm = new javax.swing.JButton();
        btn_salvar_adm = new javax.swing.JButton();
        btn_buscar_adm = new javax.swing.JButton();
        input_chave_adm = new javax.swing.JTextField();
        btn_gerarChave_adm = new javax.swing.JButton();
        label_userMotorista_adm = new javax.swing.JLabel();
        input_userMotorista_adm = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rastreio Express - Painel Administrativo");
        setResizable(false);

        painel_adm.setBackground(new java.awt.Color(220, 220, 220));

        header_decorativo.setBackground(new java.awt.Color(21, 21, 21));

        header_texto.setBackground(new java.awt.Color(0, 0, 0));
        header_texto.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        header_texto.setForeground(new java.awt.Color(255, 255, 255));
        header_texto.setText("Administração e cadastro de encomendas");

        btn_voltar_adm.setBackground(new java.awt.Color(200, 200, 200));
        btn_voltar_adm.setForeground(new java.awt.Color(20, 20, 20));
        btn_voltar_adm.setText("Voltar ao Login");
        btn_voltar_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltar_admActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout header_decorativoLayout = new javax.swing.GroupLayout(header_decorativo);
        header_decorativo.setLayout(header_decorativoLayout);
        header_decorativoLayout.setHorizontalGroup(
            header_decorativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_decorativoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(header_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_voltar_adm)
                .addGap(19, 19, 19))
        );
        header_decorativoLayout.setVerticalGroup(
            header_decorativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_decorativoLayout.createSequentialGroup()
                .addGroup(header_decorativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_decorativoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(header_texto))
                    .addGroup(header_decorativoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btn_voltar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabela_encomenda_adm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Origem", "Destino", "Posição", "Data de Postagem", "Entregra Prevista", "Status", "Motorista"
            }
        ));
        tabela_encomenda_adm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_encomenda_admMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabela_encomenda_adm);

        label_origem_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_origem_adm.setText("Origem:");

        combobox_origem_adm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Posição de partida", "Catalão", "Uberaba", "Uberlândia", "Goiânia" }));
        combobox_origem_adm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        combobox_origem_adm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_origem_admItemStateChanged(evt);
            }
        });

        label_destino_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_destino_adm.setText("Destino:");

        combobox_destino_adm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Local de entrega", "Catalão", "Uberaba", "Uberlândia", "Goiânia" }));
        combobox_destino_adm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        label_posicao_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_posicao_adm.setText("Posição:");

        combobox_posicao_adm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Posição atual da encomenda", "Catalão", "Uberaba", "Uberlândia", "Goiânia", "Extravio", "Roubo", "Devolução" }));
        combobox_posicao_adm.setToolTipText("");
        combobox_posicao_adm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        input_dataPost_adm.setForeground(new java.awt.Color(153, 153, 153));
        input_dataPost_adm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        input_dataPost_adm.setToolTipText("dd / mm / yyyy");
        input_dataPost_adm.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        input_dataPost_adm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        input_dataPost_adm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_dataPost_admFocusGained(evt);
            }
        });

        labelestimativa_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelestimativa_adm.setText("Data de Entrega:");

        input_estimativa_adm.setForeground(new java.awt.Color(20, 20, 20));
        input_estimativa_adm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        input_estimativa_adm.setToolTipText("dd / mm / yyyy");
        input_estimativa_adm.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        input_estimativa_adm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        input_estimativa_adm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_estimativa_admFocusGained(evt);
            }
        });

        label_dataPost_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_dataPost_adm.setText("Data de Postagem:");

        label_situacao_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_situacao_adm.setText("Situação:");

        combobox_situacao_adm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Situação atual da encomenda", "Ativo", "Interrompido" }));
        combobox_situacao_adm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        label_chave_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_chave_adm.setText("Chave de rastreio:");

        btn_editar_adm.setBackground(new java.awt.Color(20, 20, 20));
        btn_editar_adm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_editar_adm.setForeground(new java.awt.Color(255, 255, 255));
        btn_editar_adm.setText("Editar");
        btn_editar_adm.setBorder(null);
        btn_editar_adm.setEnabled(false);
        btn_editar_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_admActionPerformed(evt);
            }
        });

        btn_cadastrar_adm.setBackground(new java.awt.Color(20, 20, 20));
        btn_cadastrar_adm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cadastrar_adm.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar_adm.setText("Cadastrar");
        btn_cadastrar_adm.setBorder(null);
        btn_cadastrar_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_admActionPerformed(evt);
            }
        });

        btn_salvar_adm.setBackground(new java.awt.Color(20, 20, 20));
        btn_salvar_adm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_salvar_adm.setForeground(new java.awt.Color(255, 255, 255));
        btn_salvar_adm.setText("Salvar");
        btn_salvar_adm.setBorder(null);
        btn_salvar_adm.setEnabled(false);
        btn_salvar_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_admActionPerformed(evt);
            }
        });

        btn_buscar_adm.setBackground(new java.awt.Color(20, 20, 20));
        btn_buscar_adm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_buscar_adm.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar_adm.setText("Buscar");
        btn_buscar_adm.setBorder(null);
        btn_buscar_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_admActionPerformed(evt);
            }
        });

        input_chave_adm.setEditable(false);

        btn_gerarChave_adm.setText("Gerar");
        btn_gerarChave_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerarChave_admActionPerformed(evt);
            }
        });

        label_userMotorista_adm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_userMotorista_adm.setText("User do Motorista:");

        javax.swing.GroupLayout painel_admLayout = new javax.swing.GroupLayout(painel_adm);
        painel_adm.setLayout(painel_admLayout);
        painel_admLayout.setHorizontalGroup(
            painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_decorativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
            .addGroup(painel_admLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_origem_adm)
                            .addComponent(combobox_origem_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobox_destino_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_destino_adm))
                        .addGap(18, 18, 18)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_posicao_adm)
                            .addComponent(combobox_posicao_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_situacao_adm)
                            .addComponent(combobox_situacao_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(142, Short.MAX_VALUE))
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_dataPost_adm)
                            .addComponent(input_dataPost_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_estimativa_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelestimativa_adm))
                        .addGap(18, 18, 18)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_chave_adm)
                            .addGroup(painel_admLayout.createSequentialGroup()
                                .addComponent(input_chave_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_gerarChave_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))))
            .addGroup(painel_admLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btn_cadastrar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_userMotorista_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_userMotorista_adm))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addComponent(btn_editar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_salvar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_buscar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painel_admLayout.setVerticalGroup(
            painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_admLayout.createSequentialGroup()
                .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addComponent(header_decorativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painel_admLayout.createSequentialGroup()
                                .addComponent(label_destino_adm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox_destino_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_admLayout.createSequentialGroup()
                                .addComponent(label_origem_adm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox_origem_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_admLayout.createSequentialGroup()
                                .addComponent(label_posicao_adm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox_posicao_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addComponent(label_situacao_adm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combobox_situacao_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addComponent(label_dataPost_adm)
                        .addGap(5, 5, 5)
                        .addComponent(input_dataPost_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_admLayout.createSequentialGroup()
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelestimativa_adm)
                            .addComponent(label_chave_adm))
                        .addGap(5, 5, 5)
                        .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input_estimativa_adm)
                            .addComponent(input_chave_adm)
                            .addComponent(btn_gerarChave_adm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25)
                .addComponent(label_userMotorista_adm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input_userMotorista_adm, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(painel_admLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cadastrar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(painel_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(painel_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_encomenda_admMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_encomenda_admMouseClicked
        btn_editar_adm.setEnabled(true);
    }//GEN-LAST:event_tabela_encomenda_admMouseClicked

    private void input_dataPost_admFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_input_dataPost_admFocusGained
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = dateFormat.format(new Date());
            input_dataPost_adm.setForeground(new Color(20,20,20));
            input_dataPost_adm.setText(currentDate);
            input_dataPost_adm.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_input_dataPost_admFocusGained

    private void input_estimativa_admFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_input_estimativa_admFocusGained
        try {
           
            if (input_dataPost_adm.getText().equals("Data de Postagem")) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String currentDate = dateFormat.format(new Date());
                input_dataPost_adm.setForeground(new Color(20,20,20));
                input_dataPost_adm.setText(currentDate);
                input_dataPost_adm.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_input_estimativa_admFocusGained

    private void btn_editar_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_admActionPerformed
        btn_salvar_adm.setEnabled(true);
        try {
            int linha = tabela_encomenda_adm.getSelectedRow();
    
            combobox_origem_adm.setSelectedItem(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 1)));
            combobox_destino_adm.setSelectedItem(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 2)));
            combobox_posicao_adm.setSelectedItem(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 3)));
            combobox_posicao_adm.setEnabled(true);
            btn_gerarChave_adm.setEnabled(false);
            input_dataPost_adm.setText(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 4)));
            input_estimativa_adm.setText(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 5)));
            combobox_situacao_adm.setSelectedItem(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 6)));
            input_userMotorista_adm.setText(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 7)));
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela");
            e.printStackTrace();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar tabela");
        }
    }//GEN-LAST:event_btn_editar_admActionPerformed

    private void btn_cadastrar_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_admActionPerformed
        if(input_chave_adm.getText().equals("") || combobox_origem_adm.getSelectedIndex() == 0|| combobox_destino_adm.getSelectedIndex() == 0|| combobox_posicao_adm.getSelectedIndex() == 0 || combobox_situacao_adm.getSelectedIndex() == 0 || input_dataPost_adm.getText().equals("") || input_estimativa_adm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            try {
            
                String dataTexto = input_dataPost_adm.getText();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dataPostagem = format.parse(dataTexto);

                String dataTexto1 = input_estimativa_adm.getText();
                Date dataEstimativa = format.parse(dataTexto1);
                if(dataEstimativa.getYear() < dataPostagem.getYear()) {
                    throw new InputMismatchException("Data Inválida");
                }else if (dataEstimativa.getYear() == dataPostagem.getYear()) {
                    if(dataEstimativa.getMonth() < dataPostagem.getMonth()) {
                        throw new InputMismatchException("Data Inválida");
                    }
                } else if ((dataEstimativa.getYear() == dataPostagem.getYear()) && (dataEstimativa.getMonth() == dataPostagem.getMonth())) {
                    System.out.print(dataEstimativa);
                    if(dataEstimativa.getDay()< dataPostagem.getDay()) {
                        System.out.print(dataEstimativa);
                        throw new InputMismatchException("Data Inválida");
                    }
                } 
                String chave = input_chave_adm.getText();
                String userMotorista = input_userMotorista_adm.getText();
                if(EncomendaDAO.validarMotorista(userMotorista)) {
                    Encomenda p = new Encomenda();
                    p.setOrigem(String.valueOf(combobox_origem_adm.getSelectedItem()));
                    p.setDestino(String.valueOf(combobox_destino_adm.getSelectedItem()));
                    p.setPosicao(String.valueOf(combobox_posicao_adm.getSelectedItem()));
                    p.setDataPostagem(dataPostagem);
                    p.setDataEntrega(dataEstimativa);
                    p.setStatus(String.valueOf(combobox_situacao_adm.getSelectedItem()));
                    p.setChave(chave);
                    p.setMotorista(userMotorista);


                    EncomendaDAO.cadastrarEncomenda(p);
                    input_chave_adm.setText("");
                    input_dataPost_adm.setText("");
                    input_dataPost_adm.setEnabled(true);
                    input_estimativa_adm.setText("");
                    input_userMotorista_adm.setText("");
                    
                    combobox_origem_adm.setSelectedIndex(0);
                    combobox_destino_adm.setSelectedIndex(0);
                    combobox_posicao_adm.setSelectedIndex(0);
                    combobox_situacao_adm.setSelectedIndex(0);
                    combobox_posicao_adm.setEnabled(true);
                    
                    loadTableCadastro();
                } else {
                     JOptionPane.showMessageDialog(null, "Motorista não registrado.");
                }          
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de data inválido\nFormato correto: dd / mm / aaaa");
                System.err.println("Erro ao cadastrar encomenda: " + e);
            } catch (InputMismatchException e) { 
                JOptionPane.showMessageDialog(null, "Data de entrega inválida.");
                System.err.println(e);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro");
                System.err.println("Erro ao cadastrar encomenda: " + e);
            }
        }
    }//GEN-LAST:event_btn_cadastrar_admActionPerformed

    private void btn_gerarChave_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerarChave_admActionPerformed
        input_chave_adm.setText(Encomenda.geradorChave());
        
    }//GEN-LAST:event_btn_gerarChave_admActionPerformed

    private void combobox_origem_admItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_origem_admItemStateChanged
        combobox_posicao_adm.setSelectedItem(combobox_origem_adm.getSelectedItem());
        combobox_posicao_adm.setEnabled(false);
        if(combobox_origem_adm.getSelectedIndex() == 0) {
           combobox_posicao_adm.setSelectedIndex(0);
           combobox_posicao_adm.setEnabled(true);
        }
    }//GEN-LAST:event_combobox_origem_admItemStateChanged

    private void btn_salvar_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_admActionPerformed
        try {
            
            if(combobox_origem_adm.getSelectedIndex() == 0|| combobox_destino_adm.getSelectedIndex() == 0|| combobox_posicao_adm.getSelectedIndex() == 0 || combobox_situacao_adm.getSelectedIndex() == 0 || input_dataPost_adm.getText().equals("") || input_estimativa_adm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                int linha = tabela_encomenda_adm.getSelectedRow();
                int id = Integer.parseInt(String.valueOf(tabela_encomenda_adm.getValueAt(linha, 0)));
                String dataTexto = input_dataPost_adm.getText();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dataPostagem = format.parse(dataTexto);

                String dataTexto1 = input_estimativa_adm.getText();
                Date dataEstimativa = format.parse(dataTexto1);

                Encomenda p = new Encomenda();
                p.setId(id);
                p.setOrigem(combobox_origem_adm.getSelectedItem().toString());
                p.setDestino(combobox_destino_adm.getSelectedItem().toString());
                String selectedPosicao = String.valueOf(combobox_posicao_adm.getSelectedItem());
                p.setPosicao(selectedPosicao);
                p.setDataPostagem(dataPostagem);
                p.setDataEntrega(dataEstimativa);
                String selectedSituacao = String.valueOf(combobox_situacao_adm.getSelectedItem());
                p.setStatus(selectedSituacao);
                if(EncomendaDAO.validarMotorista(input_userMotorista_adm.getText())) {
                     p.setMotorista(input_userMotorista_adm.getText());
                    EncomendaDAO.atualizarEncomenda(p);
                    combobox_origem_adm.setSelectedIndex(0);
                    combobox_destino_adm.setSelectedIndex(0);
                    combobox_posicao_adm.setSelectedIndex(0);
                    combobox_posicao_adm.setEnabled(true);
                    combobox_situacao_adm.setSelectedIndex(0);
                    input_dataPost_adm.setText("");
                    input_dataPost_adm.setEnabled(true);
                    input_estimativa_adm.setText("");
                    input_userMotorista_adm.setText("");
                    JOptionPane.showMessageDialog(null, "Encomenda atualizada com sucesso");
                    loadTableCadastro();
                    btn_salvar_adm.setEnabled(false);
                    btn_editar_adm.setEnabled(false);
                    btn_gerarChave_adm.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Motorista não registrado");
                }
               
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela e clique em editar");
            e.printStackTrace();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido.\n\nFormato válido: dd / mm / aaaa");
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_salvar_admActionPerformed

    private void btn_buscar_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_admActionPerformed
       String chaveDigitada = JOptionPane.showInputDialog(null, "Insira a chave de rastreio da encomenda:");
       if(EncomendaDAO.validarChave(chaveDigitada)) {
           try {
               EncomendaDAO.buscarEncomenda(tabela_encomenda_adm, chaveDigitada);
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       } else {
           JOptionPane.showMessageDialog(null, "Chave de rastreio não encontrada");
           clearTableCadastro();
           try {
               loadTableCadastro();
           } catch (SQLException ex) {
               Logger.getLogger(TelaAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_btn_buscar_admActionPerformed

    private void btn_voltar_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltar_admActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja mesmo voltar à tela de login?");
        
        if(confirm == 0) {
            this.setVisible(false);
            Loginview login = new Loginview();
            login.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btn_voltar_admActionPerformed

    public void loadTableCadastro() throws SQLException {
    DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Origem", "Destino", "Posição", "Data de Postagem", "Entrega Prevista", "Status", "Motorista"}, 0);
    Connection a = ConnectionDB.getConnection();
    try {
        String query = "SELECT id, origem, destino, posicao, DATE_FORMAT(dataPostagem, '%d/%m/%Y') as dataFormatada, DATE_FORMAT(dataEntrega, '%d/%m/%Y') as dataFormatada2, status, motorista FROM ENCOMENDA ORDER BY id";
        Statement st = a.createStatement();
        ResultSet executeQuery = st.executeQuery(query);
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
        tabela_encomenda_adm.setModel(modelo);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(TelaAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrativo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaAdministrativo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
     public void clearTableCadastro() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Origem", "Destino", "Posição", "Data de Postagem", "Entrega Prevista", "Status", "Motorista"}, 0);
        try {
            tabela_encomenda_adm.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar_adm;
    private javax.swing.JButton btn_cadastrar_adm;
    private javax.swing.JButton btn_editar_adm;
    private javax.swing.JButton btn_gerarChave_adm;
    private javax.swing.JButton btn_salvar_adm;
    private javax.swing.JButton btn_voltar_adm;
    private javax.swing.JComboBox<String> combobox_destino_adm;
    private javax.swing.JComboBox<String> combobox_origem_adm;
    private javax.swing.JComboBox<String> combobox_posicao_adm;
    private javax.swing.JComboBox<String> combobox_situacao_adm;
    private javax.swing.JPanel header_decorativo;
    private javax.swing.JLabel header_texto;
    private javax.swing.JTextField input_chave_adm;
    private javax.swing.JFormattedTextField input_dataPost_adm;
    private javax.swing.JFormattedTextField input_estimativa_adm;
    private javax.swing.JTextField input_userMotorista_adm;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label_chave_adm;
    private javax.swing.JLabel label_dataPost_adm;
    private javax.swing.JLabel label_destino_adm;
    private javax.swing.JLabel label_origem_adm;
    private javax.swing.JLabel label_posicao_adm;
    private javax.swing.JLabel label_situacao_adm;
    private javax.swing.JLabel label_userMotorista_adm;
    private javax.swing.JLabel labelestimativa_adm;
    private javax.swing.JPanel painel_adm;
    private javax.swing.JTable tabela_encomenda_adm;
    // End of variables declaration//GEN-END:variables
}
