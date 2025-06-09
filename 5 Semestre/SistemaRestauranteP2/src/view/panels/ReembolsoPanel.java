package view.panels;

import dto.ReembolsoDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;

public class ReembolsoPanel extends InterfacePanel {
    private ReembolsoDTO dto;

    public ReembolsoPanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtMotivo = new javax.swing.JTextField();

        jLabel1.setText("Motivo do Reembolso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtMotivo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 193, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public InterfaceDTO getData() {
        ReembolsoDTO rDTO = dto;
        
        String motivo = jtMotivo.getText().trim();
        
        if (motivo.isEmpty()) {
            return null;
        }
        
        rDTO.id = "0";
        rDTO.motivo = motivo;
        
        return rDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        this.dto = (ReembolsoDTO) interfaceDTO;
        jtMotivo.setText(this.dto.motivo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jtMotivo;
    // End of variables declaration//GEN-END:variables
}
