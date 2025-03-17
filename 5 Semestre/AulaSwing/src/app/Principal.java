package app;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        JFrame tela =new JFrame();
        tela.setLayout(new FlowLayout());
        tela.setSize(500, 400);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton botão = new JButton("Clique aqui");
        tela.add(botão);
        
        botão.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // botão.setText("vc clicou");
                JOptionPane.showMessageDialog(tela, "Olá mundo");
            }
        });
        
    }
    
}
