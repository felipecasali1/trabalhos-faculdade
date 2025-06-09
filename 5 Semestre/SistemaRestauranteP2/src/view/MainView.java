package view;

import controller.BairroController;
import controller.ClienteController;
import controller.CupomController;
import controller.DeliveryController;
import controller.EnderecoController;
import controller.EntregaController;
import controller.FuncionarioController;
import controller.LoginController;
import controller.PedidoController;
import controller.ProdutoController;
import controller.ReembolsoController;
import controller.StatusPedidoController;
import controller.TelefoneController;
import dto.BairroDTO;
import dto.ClienteDTO;
import dto.CupomDTO;
import dto.DeliveryDTO;
import dto.EnderecoDTO;
import dto.EntregaDTO;
import dto.FuncionarioDTO;
import dto.LoginDTO;
import dto.PedidoDTO;
import dto.ProdutoDTO;
import dto.ReembolsoDTO;
import dto.StatusPedidoDTO;
import dto.TelefoneDTO;
import interfaces.InterfaceController;
import interfaces.InterfacePanel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import view.panels.BairroPanel;
import view.panels.ClientePanel;
import view.panels.CupomPanel;
import view.panels.DeliveryPanel;
import view.panels.EnderecoPanel;
import view.panels.EntregaPanel;
import view.panels.FuncionarioPanel;
import view.panels.LoginPanel;
import view.panels.PedidoPanel;
import view.panels.ProdutoPanel;
import view.panels.ReembolsoPanel;
import view.panels.StatusPedidoPanel;
import view.panels.TelefonePanel;

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
        jmiCadTelefone = new javax.swing.JMenuItem();
        jmiCadBairro = new javax.swing.JMenuItem();
        jmiCadCupom = new javax.swing.JMenuItem();
        jmiCadEndereco = new javax.swing.JMenuItem();
        jmiCadDelivery = new javax.swing.JMenuItem();
        jmiCadFuncionario = new javax.swing.JMenuItem();
        jmiCadLogin = new javax.swing.JMenuItem();
        jmiCadProduto = new javax.swing.JMenuItem();
        jmiCadReembolso = new javax.swing.JMenuItem();
        jmiCadStatusPedido = new javax.swing.JMenuItem();
        jmiCadPedido = new javax.swing.JMenuItem();
        jmiCadEntrega = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiListarCliente = new javax.swing.JMenuItem();
        jmiListarTelefone = new javax.swing.JMenuItem();
        jmiListarBairro = new javax.swing.JMenuItem();
        jmiListarCupom = new javax.swing.JMenuItem();
        jmiListarEndereco = new javax.swing.JMenuItem();
        jmiListarDelivery = new javax.swing.JMenuItem();
        jmiListarFuncionario = new javax.swing.JMenuItem();
        jmiListarLogin = new javax.swing.JMenuItem();
        jmiListarProduto = new javax.swing.JMenuItem();
        jmiListarReembolso = new javax.swing.JMenuItem();
        jmiListarStatusPedido = new javax.swing.JMenuItem();
        jmiListarPedido = new javax.swing.JMenuItem();
        jmiListarEntrega = new javax.swing.JMenuItem();

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

        jmiCadTelefone.setText("Telefone");
        jmiCadTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadTelefoneActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadTelefone);

        jmiCadBairro.setText("Bairro");
        jmiCadBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadBairroActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadBairro);

        jmiCadCupom.setText("Cupom");
        jmiCadCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadCupomActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadCupom);

        jmiCadEndereco.setText("Endereco");
        jmiCadEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadEnderecoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadEndereco);

        jmiCadDelivery.setText("Delivery");
        jmiCadDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadDeliveryActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadDelivery);

        jmiCadFuncionario.setText("Funcionario");
        jmiCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadFuncionario);

        jmiCadLogin.setText("Login");
        jmiCadLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadLoginActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadLogin);

        jmiCadProduto.setText("Produto");
        jmiCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadProduto);

        jmiCadReembolso.setText("Reembolso");
        jmiCadReembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadReembolsoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadReembolso);

        jmiCadStatusPedido.setText("Status Pedido");
        jmiCadStatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadStatusPedidoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadStatusPedido);

        jmiCadPedido.setText("Pedido");
        jmiCadPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadPedidoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadPedido);

        jmiCadEntrega.setText("Entrega");
        jmiCadEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadEntregaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCadEntrega);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Listar");

        jmiListarCliente.setText("Cliente");
        jmiListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarCliente);

        jmiListarTelefone.setText("Telefone");
        jmiListarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarTelefoneActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarTelefone);

        jmiListarBairro.setText("Bairro");
        jmiListarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarBairroActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarBairro);

        jmiListarCupom.setText("Cupom");
        jmiListarCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarCupomActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarCupom);

        jmiListarEndereco.setText("Endereco");
        jmiListarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarEnderecoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarEndereco);

        jmiListarDelivery.setText("Delivery");
        jmiListarDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarDeliveryActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarDelivery);

        jmiListarFuncionario.setText("Funcionario");
        jmiListarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarFuncionarioActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarFuncionario);

        jmiListarLogin.setText("Login");
        jmiListarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarLoginActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarLogin);

        jmiListarProduto.setText("Produto");
        jmiListarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarProduto);

        jmiListarReembolso.setText("Reembolso");
        jmiListarReembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarReembolsoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarReembolso);

        jmiListarStatusPedido.setText("Status Pedido");
        jmiListarStatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarStatusPedidoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarStatusPedido);

        jmiListarPedido.setText("Pedido");
        jmiListarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarPedidoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarPedido);

        jmiListarEntrega.setText("Entrega");
        jmiListarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarEntregaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiListarEntrega);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadClienteActionPerformed
        new CadastroTemplate(this, true, new ClientePanel(new ClienteDTO()), new ClienteController()).setVisible(true);
    }//GEN-LAST:event_jmiCadClienteActionPerformed

    private void jmiCadTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadTelefoneActionPerformed
       new CadastroTemplate(this, true, new TelefonePanel(new TelefoneDTO()), new TelefoneController()).setVisible(true);
    }//GEN-LAST:event_jmiCadTelefoneActionPerformed

    private void jmiListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarClienteActionPerformed
        new Listagem(this, true, new ClienteController(), new ClientePanel(new ClienteDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarClienteActionPerformed

    private void jmiListarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarTelefoneActionPerformed
        new Listagem(this, true, new TelefoneController(), new TelefonePanel(new TelefoneDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarTelefoneActionPerformed

    private void jmiCadBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadBairroActionPerformed
        new CadastroTemplate(this, true, new BairroPanel(new BairroDTO()), new BairroController()).setVisible(true);
    }//GEN-LAST:event_jmiCadBairroActionPerformed

    private void jmiListarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarBairroActionPerformed
        new Listagem(this, true, new BairroController(), new BairroPanel(new BairroDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarBairroActionPerformed

    private void jmiCadCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadCupomActionPerformed
        new CadastroTemplate(this, true, new CupomPanel(new CupomDTO()), new CupomController()).setVisible(true);
    }//GEN-LAST:event_jmiCadCupomActionPerformed

    private void jmiListarCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarCupomActionPerformed
        new Listagem(this, true, new CupomController(), new CupomPanel(new CupomDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarCupomActionPerformed

    private void jmiCadEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadEnderecoActionPerformed
        new CadastroTemplate(this, true, new EnderecoPanel(new EnderecoDTO()), new EnderecoController()).setVisible(true);
    }//GEN-LAST:event_jmiCadEnderecoActionPerformed

    private void jmiListarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarEnderecoActionPerformed
        new Listagem(this, true, new EnderecoController(), new EnderecoPanel(new EnderecoDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarEnderecoActionPerformed

    private void jmiCadDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadDeliveryActionPerformed
        new CadastroTemplate(this, true, new DeliveryPanel(new DeliveryDTO()), new DeliveryController()).setVisible(true);
    }//GEN-LAST:event_jmiCadDeliveryActionPerformed

    private void jmiListarDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarDeliveryActionPerformed
        new Listagem(this, true, new DeliveryController(), new DeliveryPanel(new DeliveryDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarDeliveryActionPerformed

    private void jmiCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadFuncionarioActionPerformed
        new CadastroTemplate(this, true, new FuncionarioPanel(new FuncionarioDTO()), new FuncionarioController()).setVisible(true);
    }//GEN-LAST:event_jmiCadFuncionarioActionPerformed

    private void jmiListarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarFuncionarioActionPerformed
        new Listagem(this, true, new FuncionarioController(), new FuncionarioPanel(new FuncionarioDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarFuncionarioActionPerformed

    private void jmiCadLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadLoginActionPerformed
        new CadastroTemplate(this, true, new LoginPanel(new LoginDTO()), new LoginController()).setVisible(true);
    }//GEN-LAST:event_jmiCadLoginActionPerformed

    private void jmiListarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarLoginActionPerformed
        new Listagem(this, true, new LoginController(), new LoginPanel(new LoginDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarLoginActionPerformed

    private void jmiCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadProdutoActionPerformed
        new CadastroTemplate(this, true, new ProdutoPanel(new ProdutoDTO()), new ProdutoController()).setVisible(true);
    }//GEN-LAST:event_jmiCadProdutoActionPerformed

    private void jmiListarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarProdutoActionPerformed
        new Listagem(this, true, new ProdutoController(), new ProdutoPanel(new ProdutoDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarProdutoActionPerformed

    private void jmiCadReembolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadReembolsoActionPerformed
        new CadastroTemplate(this, true, new ReembolsoPanel(new ReembolsoDTO()), new ReembolsoController()).setVisible(true);
    }//GEN-LAST:event_jmiCadReembolsoActionPerformed

    private void jmiListarReembolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarReembolsoActionPerformed
        new Listagem(this, true, new ReembolsoController(), new ReembolsoPanel(new ReembolsoDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarReembolsoActionPerformed

    private void jmiCadStatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadStatusPedidoActionPerformed
        new CadastroTemplate(this, true, new StatusPedidoPanel(new StatusPedidoDTO()), new StatusPedidoController()).setVisible(true);
    }//GEN-LAST:event_jmiCadStatusPedidoActionPerformed

    private void jmiListarStatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarStatusPedidoActionPerformed
        new Listagem(this, true, new StatusPedidoController(), new StatusPedidoPanel(new StatusPedidoDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarStatusPedidoActionPerformed

    private void jmiCadPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadPedidoActionPerformed
        new CadastroTemplate(this, true, new PedidoPanel(new PedidoDTO()), new PedidoController()).setVisible(true);
    }//GEN-LAST:event_jmiCadPedidoActionPerformed

    private void jmiListarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarPedidoActionPerformed
        new Listagem(this, true, new PedidoController(), new PedidoPanel(new PedidoDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarPedidoActionPerformed

    private void jmiCadEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadEntregaActionPerformed
        new CadastroTemplate(this, true, new EntregaPanel(new EntregaDTO()), new EntregaController()).setVisible(true);
    }//GEN-LAST:event_jmiCadEntregaActionPerformed

    private void jmiListarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarEntregaActionPerformed
        new Listagem(this, true, new EntregaController(), new EntregaPanel(new EntregaDTO())).setVisible(true);
    }//GEN-LAST:event_jmiListarEntregaActionPerformed

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
    private javax.swing.JMenuItem jmiCadBairro;
    private javax.swing.JMenuItem jmiCadCliente;
    private javax.swing.JMenuItem jmiCadCupom;
    private javax.swing.JMenuItem jmiCadDelivery;
    private javax.swing.JMenuItem jmiCadEndereco;
    private javax.swing.JMenuItem jmiCadEntrega;
    private javax.swing.JMenuItem jmiCadFuncionario;
    private javax.swing.JMenuItem jmiCadLogin;
    private javax.swing.JMenuItem jmiCadPedido;
    private javax.swing.JMenuItem jmiCadProduto;
    private javax.swing.JMenuItem jmiCadReembolso;
    private javax.swing.JMenuItem jmiCadStatusPedido;
    private javax.swing.JMenuItem jmiCadTelefone;
    private javax.swing.JMenuItem jmiListarBairro;
    private javax.swing.JMenuItem jmiListarCliente;
    private javax.swing.JMenuItem jmiListarCupom;
    private javax.swing.JMenuItem jmiListarDelivery;
    private javax.swing.JMenuItem jmiListarEndereco;
    private javax.swing.JMenuItem jmiListarEntrega;
    private javax.swing.JMenuItem jmiListarFuncionario;
    private javax.swing.JMenuItem jmiListarLogin;
    private javax.swing.JMenuItem jmiListarPedido;
    private javax.swing.JMenuItem jmiListarProduto;
    private javax.swing.JMenuItem jmiListarReembolso;
    private javax.swing.JMenuItem jmiListarStatusPedido;
    private javax.swing.JMenuItem jmiListarTelefone;
    // End of variables declaration//GEN-END:variables
}
