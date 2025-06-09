package interfaces;

import interfaces.InterfaceDTO;
import javax.swing.JPanel;

public abstract class InterfacePanel extends JPanel {
    public abstract InterfaceDTO getData();
    public abstract void setDTO(InterfaceDTO interfaceDTO);
}
