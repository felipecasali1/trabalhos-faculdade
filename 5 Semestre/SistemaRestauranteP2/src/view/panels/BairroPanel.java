package view.panels;

import dto.BairroDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;

public class BairroPanel extends InterfacePanel {
    private BairroDTO dto;
    
    public BairroPanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();

        jLabel1.setText("Nome do Bairro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 223, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables

    @Override
    public InterfaceDTO getData() {
        BairroDTO bDTO = dto;
        String nome = jtNome.getText().trim();
        if (nome.isEmpty()) {
            return null;
        }
        
        bDTO.id = "0";
        bDTO.nome = nome;
        return bDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        this.dto = (BairroDTO) interfaceDTO;
        jtNome.setText(this.dto.nome);
    }
}
