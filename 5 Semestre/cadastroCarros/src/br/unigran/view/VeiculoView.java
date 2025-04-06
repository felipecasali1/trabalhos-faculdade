package br.unigran.view;

import br.unigran.controller.VeiculoController;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class VeiculoView extends javax.swing.JFrame {
    public VeiculoView() {
        initComponents();
        
        DecimalFormat format = new DecimalFormat("######0");
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(null);
        formatter.setMaximum(999999);
        formatter.setAllowsInvalid(true);
        formatter.setCommitsOnValidEdit(true);

        jftKm.setFormatterFactory(new DefaultFormatterFactory(formatter));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jpTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpOptions = new javax.swing.JPanel();
        jbCadastrar = new javax.swing.JButton();
        jbListar = new javax.swing.JButton();
        jpInfo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jlMarca = new javax.swing.JLabel();
        jtfMarca = new javax.swing.JTextField();
        jlCor = new javax.swing.JLabel();
        jtfCor = new javax.swing.JTextField();
        jlKm = new javax.swing.JLabel();
        jftKm = new javax.swing.JFormattedTextField();
        jlValor = new javax.swing.JLabel();
        jftValor = new javax.swing.JFormattedTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar veículos");
        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar veículos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpTituloLayout = new javax.swing.GroupLayout(jpTitulo);
        jpTitulo.setLayout(jpTituloLayout);
        jpTituloLayout.setHorizontalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTituloLayout.setVerticalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
        );

        jpOptions.setMinimumSize(new java.awt.Dimension(115, 50));

        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.setMinimumSize(new java.awt.Dimension(60, 40));
        jbCadastrar.setPreferredSize(new java.awt.Dimension(120, 40));
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });
        jpOptions.add(jbCadastrar);

        jbListar.setText("LISTAR");
        jbListar.setMinimumSize(new java.awt.Dimension(60, 40));
        jbListar.setPreferredSize(new java.awt.Dimension(120, 40));
        jbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarActionPerformed(evt);
            }
        });
        jpOptions.add(jbListar);

        jPanel1.setLayout(new java.awt.GridLayout(10, 1));

        jlNome.setText("Nome");
        jlNome.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jlNome);

        jtfNome.setToolTipText("");
        jtfNome.setMaximumSize(new java.awt.Dimension(50, 25));
        jtfNome.setMinimumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jtfNome);

        jlMarca.setText("Marca");
        jlMarca.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jlMarca);

        jtfMarca.setToolTipText("");
        jtfMarca.setMaximumSize(new java.awt.Dimension(50, 25));
        jtfMarca.setMinimumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jtfMarca);

        jlCor.setText("Cor");
        jlCor.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jlCor);

        jtfCor.setToolTipText("");
        jtfCor.setMaximumSize(new java.awt.Dimension(50, 25));
        jtfCor.setMinimumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jtfCor);

        jlKm.setText("Kilometragem");
        jlKm.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jlKm);

        jftKm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel1.add(jftKm);

        jlValor.setText("Valor");
        jlValor.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel1.add(jlValor);

        jftValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jPanel1.add(jftValor);

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        try {
            String nome = jtfNome.getText();
            String marca = jtfMarca.getText();
            String cor = jtfCor.getText();
            String kmStr = jftKm.getText().trim();
            String valorStr = jftValor.getText().trim();
            
            if (emptyFields(nome, marca, cor, kmStr, valorStr)) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, preencha todos os campos.");
                return;
            }
            
            jftKm.commitEdit();
            jftValor.commitEdit();
            
            Number kmNum = (Number) jftKm.getValue();
            Number valorNum = (Number) jftValor.getValue();
            
            if(kmNum == null || valorNum == null) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, preencha os campos numéricos corretamente.");
                return;
            }
            
            int km = kmNum.intValue();
            float valor = valorNum.floatValue();
            
            VeiculoController.insertVeiculo(nome, marca, cor, km, valor);
            JOptionPane.showMessageDialog(rootPane, "Cadastro realizado!");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro nos valores numéricos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro inesperado: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarActionPerformed
        new VeiculoListView(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jbListarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeiculoView().setVisible(true);
            }
        });
    }
    
    private boolean emptyFields(String... campos) {
        for(String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbListar;
    private javax.swing.JFormattedTextField jftKm;
    private javax.swing.JFormattedTextField jftValor;
    private javax.swing.JLabel jlCor;
    private javax.swing.JLabel jlKm;
    private javax.swing.JLabel jlMarca;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlValor;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JPanel jpTitulo;
    private javax.swing.JTextField jtfCor;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables

}

