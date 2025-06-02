package view;

import interfaces.InterfaceController;
import interfaces.InterfacePanel;
import java.awt.BorderLayout;
import java.sql.*;

public class CadastroTemplateView extends javax.swing.JDialog {
    private final InterfaceController interfaceController;
    private final InterfacePanel interfacePanel;
    
    public CadastroTemplateView(java.awt.Frame parent, InterfacePanel interfacePanel, InterfaceController interfaceController, boolean modal) {
        super(parent, modal);
        initComponents();
        this.interfacePanel = interfacePanel;
        this.interfaceController = interfaceController;
        add(interfacePanel, BorderLayout.CENTER);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbSair = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbSair.setText("Cancelar");
        jbSair.setMaximumSize(new java.awt.Dimension(100, 100));
        jbSair.setMinimumSize(new java.awt.Dimension(100, 40));
        jbSair.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });
        jPanel1.add(jbSair);

        jbSalvar.setText("Salvar");
        jbSalvar.setMaximumSize(new java.awt.Dimension(100, 100));
        jbSalvar.setMinimumSize(new java.awt.Dimension(100, 40));
        jbSalvar.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(jbSalvar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        interfaceController.insert(interfacePanel.getData());
    }//GEN-LAST:event_jbSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSalvar;
    // End of variables declaration//GEN-END:variables
}
