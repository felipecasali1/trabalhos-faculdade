package view.panels;

import dto.CupomDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;

public class CupomPanel extends InterfacePanel {
    private CupomDTO dto;

    public CupomPanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jftPorcentagem = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jftValidade = new javax.swing.JFormattedTextField();

        jLabel1.setText("Código do Cupom");

        jLabel2.setText("Porcentagem");

        jLabel3.setText("Validade (yyyy-MM-dd HH:mm:ss)");

        jftValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jftPorcentagem, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jftValidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jftPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jftValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public InterfaceDTO getData() {
        CupomDTO cDTO = dto;
        
        String codigo = jtCodigo.getText().trim();
        String porcentagem = jftPorcentagem.getText().trim();
        String validade = jftValidade.getText().trim();
        if (codigo.isEmpty() || porcentagem.isEmpty() || validade.isEmpty()) {
            return null;
        }
        
        cDTO.id = "0";
        cDTO.codigo = codigo;
        cDTO.porcentagem = porcentagem;
        cDTO.validade = validade;
        cDTO.ativo = "true";
        return cDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        this.dto = (CupomDTO) interfaceDTO;
        jtCodigo.setText(this.dto.codigo);
        jftPorcentagem.setText(this.dto.porcentagem);
        jftValidade.setText(this.dto.validade);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField jftPorcentagem;
    private javax.swing.JFormattedTextField jftValidade;
    private javax.swing.JTextField jtCodigo;
    // End of variables declaration//GEN-END:variables
}
