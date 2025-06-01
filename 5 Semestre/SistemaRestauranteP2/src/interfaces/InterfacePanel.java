package interfaces;

import interfaces.InterfaceDTO;
import javax.swing.JPanel;

public abstract class InterfacePanel extends JPanel {
    //pegar dados da tela
    public abstract InterfaceDTO getData();
    
    //preencher os campos (editar)
    public abstract void setData(InterfaceDTO interfaceDTO);
}
