package view.panels;

import controller.ClienteController;
import controller.DeliveryController;
import controller.PedidoController;
import dto.ClienteDTO;
import dto.DeliveryDTO;
import dto.EntregaDTO;
import dto.PedidoDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;
import java.util.List;

public class EntregaPanel extends InterfacePanel {
    private EntregaDTO dto;
    private List<ClienteDTO> clientes;
    private List<DeliveryDTO> deliveries;
    private List<PedidoDTO> pedidos;

    public EntregaPanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
        updateCBCliente();
        updateCBDelivery();
        updateCBPedido();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jcbCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcbDelivery = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jcbPedido = new javax.swing.JComboBox<>();

        jLabel5.setText("Cliente");

        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Delivery");

        jcbDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDeliveryActionPerformed(evt);
            }
        });

        jLabel7.setText("Pedido");

        jcbPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jcbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jcbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        updateCBCliente();
    }//GEN-LAST:event_jcbClienteActionPerformed

    private void jcbDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDeliveryActionPerformed
        updateCBDelivery();
    }//GEN-LAST:event_jcbDeliveryActionPerformed

    private void jcbPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPedidoActionPerformed
        updateCBPedido();
    }//GEN-LAST:event_jcbPedidoActionPerformed

    @Override
    public InterfaceDTO getData() {
        EntregaDTO eDTO = dto;
        
        eDTO.id = "0";
        eDTO.clienteDTO = (ClienteDTO) jcbCliente.getSelectedItem();
        eDTO.deliveryDTO = (DeliveryDTO) jcbDelivery.getSelectedItem();
        eDTO.pedidoDTO = (PedidoDTO) jcbPedido.getSelectedItem();
        
        return eDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        
    }
    
    private void updateCBCliente() {
        jcbCliente.removeAllItems();
        
        clientes = (List<ClienteDTO>)(List<?>) new ClienteController().list();
        for (ClienteDTO cliente : clientes) {
            jcbCliente.addItem(cliente);
        }
    }
    
    private void updateCBDelivery() {
        jcbDelivery.removeAllItems();
        
        deliveries = (List<DeliveryDTO>)(List<?>) new DeliveryController().list();
        for (DeliveryDTO deliv : deliveries) {
            jcbDelivery.addItem(deliv);
        }
    }
    
    private void updateCBPedido() {
        jcbPedido.removeAllItems();
        
        pedidos = (List<PedidoDTO>)(List<?>) new PedidoController().list();
        for (PedidoDTO pedido : pedidos) {
            jcbPedido.addItem(pedido);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<ClienteDTO> jcbCliente;
    private javax.swing.JComboBox<DeliveryDTO> jcbDelivery;
    private javax.swing.JComboBox<PedidoDTO> jcbPedido;
    // End of variables declaration//GEN-END:variables
}
