package app;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class SegundaTela extends JFrame implements ActionListener{
    private JButton botaoOK = new JButton("Ok");
    private JButton botaoCancel = new JButton("Cancel");
    public SegundaTela(){
        setLayout(new FlowLayout());
        setSize(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(botaoOK);
        add(botaoCancel);
        botaoOK.addActionListener(this);
        botaoCancel.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(botaoCancel)){
           dispose();
       }
       if(e.getSource().equals(botaoOK)){
           JOptionPane.showMessageDialog(this, "Olá");
       }
    }
    public static void main(String[] args) {
        new SegundaTela().setVisible(true);
    }
    
    
}
