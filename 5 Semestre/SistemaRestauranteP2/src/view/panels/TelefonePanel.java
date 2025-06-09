package view.panels;

import controller.ClienteController;
import controller.FuncionarioController;
import dto.ClienteDTO;
import dto.FuncionarioDTO;
import dto.TelefoneDTO;
import interfaces.InterfaceDTO;
import interfaces.InterfacePanel;
import java.util.List;
import javax.swing.JOptionPane;

public class TelefonePanel extends InterfacePanel {
    private TelefoneDTO dto;
    private List<ClienteDTO> clientes;
    private List<FuncionarioDTO> funcionarios;

    public TelefonePanel(InterfaceDTO interfaceDTO) {
        initComponents();
        setDTO(interfaceDTO);
        updateComboBoxPessoa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDDD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcbPessoa = new javax.swing.JComboBox<>();

        jLabel1.setText("Telefone");

        jLabel2.setText("DDD");

        jLabel3.setText("Tipo");

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Funcionario" }));
        jcbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoActionPerformed(evt);
            }
        });

        jLabel4.setText("Pessoa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(jtfDDD)
                        .addComponent(jLabel2)
                        .addComponent(jtfTelefone)
                        .addComponent(jcbTipo, 0, 440, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoActionPerformed
        updateComboBoxPessoa();
    }//GEN-LAST:event_jcbTipoActionPerformed

    @Override
    public InterfaceDTO getData() {
        TelefoneDTO tDTO = dto;
        
        String numero = jtfTelefone.getText().trim();
        String ddd = jtfDDD.getText().trim();
        
        if (numero.isEmpty() || ddd.isEmpty()) {
            return null;
        }
        
        if (ddd.length() != 2) {
            JOptionPane.showMessageDialog(this, "DDD inválido!");
            return null;
        }
        
        tDTO.id = "0";
        tDTO.numero = numero;
        tDTO.ddd = ddd;
        
        int selectedIndex = jcbPessoa.getSelectedIndex();
        
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa!");
            return null;
        }

        if (jcbTipo.getSelectedItem().equals("Cliente")) {
            tDTO.clienteId = Integer.valueOf(clientes.get(selectedIndex).id);
            tDTO.funcionarioId = null;
        } else {
            tDTO.funcionarioId = Integer.valueOf(funcionarios.get(selectedIndex).id);
            tDTO.clienteId = null;
        }
        
        return tDTO;
    }

    @Override
    public void setDTO(InterfaceDTO interfaceDTO) {
        this.dto = (TelefoneDTO) interfaceDTO;
        jtfTelefone.setText(this.dto.numero);
        jtfDDD.setText(this.dto.ddd);
    }
    
    private void updateComboBoxPessoa() {
    jcbPessoa.removeAllItems();

    if (jcbTipo.getSelectedItem().equals("Cliente")) {
        clientes = (List<ClienteDTO>)(List<?>) new ClienteController().list();
        for (ClienteDTO cliente : clientes) {
            jcbPessoa.addItem(cliente.nome);
        }
    } else {
        funcionarios = (List<FuncionarioDTO>)(List<?>) new FuncionarioController().list();
        for (FuncionarioDTO funcionario : funcionarios) {
            jcbPessoa.addItem(funcionario.nome);
        }
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jcbPessoa;
    private javax.swing.JComboBox<String> jcbTipo;
    private javax.swing.JTextField jtfDDD;
    private javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}
