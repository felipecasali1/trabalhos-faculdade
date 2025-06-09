package view.panels;

import controller.CarrinhoController;
import controller.ClienteController;
import controller.ReembolsoController;
import controller.StatusPedidoController;
import dto.CarrinhoDTO;
import dto.ClienteDTO;
import dto.PedidoDTO;
import dto.ReembolsoDTO;
import dto.StatusPedidoDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;
import java.sql.*;
import java.time.Instant;
import java.util.List;

public class PedidoPanel extends InterfacePanel {
    private PedidoDTO dto;
    private List<ClienteDTO> clientes;
    private List<CarrinhoDTO> carrinhos;
    private List<ReembolsoDTO> reembolsos;
    private List<StatusPedidoDTO> status;

    public PedidoPanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
        updateCBCliente();
        updateCBStatus();
        updateCBReembolso();
        updateCBCarrinho();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jcbCarrinho = new javax.swing.JComboBox<>();
        jcbCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcbStatusPedido = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbReembolso = new javax.swing.JComboBox<>();

        jLabel4.setText("Carrinho");

        jcbCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCarrinhoActionPerformed(evt);
            }
        });

        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Cliente");

        jcbStatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusPedidoActionPerformed(evt);
            }
        });

        jLabel6.setText("Status Pedido");

        jLabel7.setText("Reembolso");

        jcbReembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbReembolsoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbCarrinho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbStatusPedido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbReembolso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(333, 333, 333)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbStatusPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbReembolso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCarrinhoActionPerformed
        updateCBCarrinho();
    }//GEN-LAST:event_jcbCarrinhoActionPerformed

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
       updateCBCliente();
    }//GEN-LAST:event_jcbClienteActionPerformed

    private void jcbStatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusPedidoActionPerformed
        updateCBStatus();
    }//GEN-LAST:event_jcbStatusPedidoActionPerformed

    private void jcbReembolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbReembolsoActionPerformed
        updateCBReembolso();
    }//GEN-LAST:event_jcbReembolsoActionPerformed

    @Override
    public InterfaceDTO getData() {
        PedidoDTO pDTO = dto;
        
        Timestamp now = Timestamp.from(Instant.now());
        
        pDTO.id = "0";
        pDTO.data = now.toString();
        pDTO.carrinhoDTO = (CarrinhoDTO) jcbCarrinho.getSelectedItem();
        pDTO.clienteDTO = (ClienteDTO) jcbCliente.getSelectedItem();
        pDTO.statusPedidoDTO = (StatusPedidoDTO) jcbStatusPedido.getSelectedItem();
        pDTO.reembolsoDTO = (ReembolsoDTO) jcbReembolso.getSelectedItem();
        
        return pDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        this.dto = (PedidoDTO) interfaceDTO;
    }
    
    private void updateCBCliente() {
        jcbCliente.removeAllItems();
        
        clientes = (List<ClienteDTO>)(List<?>) new ClienteController().list();
        for (ClienteDTO cliente : clientes) {
            jcbCliente.addItem(cliente);
        }
    }
    
    private void updateCBStatus() {
        jcbStatusPedido.removeAllItems();
        
        status = (List<StatusPedidoDTO>)(List<?>) new StatusPedidoController().list();
        for (StatusPedidoDTO sp : status) {
            jcbStatusPedido.addItem(sp);
        }
    }
    
    private void updateCBReembolso() {
        jcbReembolso.removeAllItems();
        
        reembolsos = (List<ReembolsoDTO>)(List<?>) new ReembolsoController().list();
        for (ReembolsoDTO re : reembolsos) {
            jcbReembolso.addItem(re);
        }
    }

    private void updateCBCarrinho() {
        jcbCarrinho.removeAllItems();
        
        carrinhos = (List<CarrinhoDTO>)(List<?>) new CarrinhoController().list();
        for (CarrinhoDTO ca : carrinhos) {
            jcbCarrinho.addItem(ca);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<CarrinhoDTO> jcbCarrinho;
    private javax.swing.JComboBox<ClienteDTO> jcbCliente;
    private javax.swing.JComboBox<ReembolsoDTO> jcbReembolso;
    private javax.swing.JComboBox<StatusPedidoDTO> jcbStatusPedido;
    // End of variables declaration//GEN-END:variables
}
