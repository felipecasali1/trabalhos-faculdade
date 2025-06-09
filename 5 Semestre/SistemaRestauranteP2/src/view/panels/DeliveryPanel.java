package view.panels;

import controller.EnderecoController;
import dto.DeliveryDTO;
import dto.EnderecoDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;
import java.util.List;
import javax.swing.JOptionPane;

public class DeliveryPanel extends InterfacePanel {
    private DeliveryDTO dto;
    private List<EnderecoDTO> enderecos;

    public DeliveryPanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
        updateComboBoxEndereco();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtComplemento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel1.setText("Número");

        jLabel2.setText("Complemento");

        jLabel4.setText("Endereço");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(jtComplemento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 287, Short.MAX_VALUE)))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        updateComboBoxEndereco();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    @Override
    public InterfaceDTO getData() {
        DeliveryDTO dDTO = dto;
        
        String numero = jtNumero.getText().trim();
        String complemento = jtComplemento.getText().trim();
        
        if (numero.isEmpty() || complemento.isEmpty()) {
            return null;
        }
        
        int selectedIndex = jComboBox1.getSelectedIndex();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um endereço!");
            return null;
        }
        
        dDTO.id = "0";
        dDTO.numero = numero;
        dDTO.complemento = complemento;
        dDTO.enderecoDTO = (EnderecoDTO) jComboBox1.getSelectedItem();
        
        return dDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        this.dto = (DeliveryDTO) interfaceDTO;
        jtNumero.setText(this.dto.numero);
        jtComplemento.setText(this.dto.complemento);
    }
    
    private void updateComboBoxEndereco() {
        jComboBox1.removeAllItems();
        
        enderecos = (List<EnderecoDTO>)(List<?>) new EnderecoController().list();
        for (EnderecoDTO endereco : enderecos) {
            jComboBox1.addItem(endereco);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<EnderecoDTO> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtComplemento;
    private javax.swing.JTextField jtNumero;
    // End of variables declaration//GEN-END:variables
}
