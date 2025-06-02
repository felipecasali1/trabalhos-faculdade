package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MainView extends javax.swing.JFrame {

    public MainView() {
        initComponents();
        updateTime();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTime = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiCadCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Cadastro");
        setPreferredSize(new java.awt.Dimension(1080, 720));

        JTime.setText(":");
        jPanel1.add(JTime);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("Cadastrar");

        jmiCadCliente.setText("Cliente");
        jmiCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Listar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadClienteActionPerformed
        
    }//GEN-LAST:event_jmiCadClienteActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
    
    private void updateTime() {  
        Timer timer = new Timer(1000, e -> {
        Date dataHoraAtual = new Date();
        String horaFormatada = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTime.setText(horaFormatada);
            }
        });
    });
    timer.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTime;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmiCadCliente;
    // End of variables declaration//GEN-END:variables
}
