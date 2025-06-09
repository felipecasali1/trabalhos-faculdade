package view.panels;

import dto.StatusPedidoDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;
import java.util.List;
import models.Status;

public class StatusPedidoPanel extends InterfacePanel {
    private StatusPedidoDTO dto;

    public StatusPedidoPanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
        updateCBStatus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel1.setText("Status Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public InterfaceDTO getData() {
        StatusPedidoDTO spDTO = dto;
        
        spDTO.id = "0";
        spDTO.status = (String) jComboBox1.getSelectedItem();
        
        return spDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        this.dto = (StatusPedidoDTO) interfaceDTO;
    }
    
    private void updateCBStatus() {
        jComboBox1.removeAllItems();
        
        for (Status status : Status.values()) {
            jComboBox1.addItem(status.toString());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
