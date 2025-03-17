package app;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tela extends JFrame implements ActionListener {
    private JButton bOk = new JButton();
    private JButton bCancel = new JButton();
    
    public Tela() {
        setSize(720,480);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bOk.setText("Ok");
        bCancel.setText("Cancel");
        bOk.addActionListener(this);
        bCancel.addActionListener(this);
        add(bOk);
        add(bCancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bOk)) {
            JOptionPane.showMessageDialog(rootPane, "Você clicou em Ok!");
        } else if(e.getSource().equals(bCancel)) {
            dispose();
        }
    }
    
    
}
