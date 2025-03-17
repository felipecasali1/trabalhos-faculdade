package view;

import dao.LivroDao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tela extends JFrame {
    private JButton jbAddLivros;
    private JButton jbDelLivros;
    private JButton jbEditLivros;
    private JButton verLivros;
    private JPanel jpPainel;

    public Tela() {
        init();
        actions();
    }
    
    private void init() {
        setVisible(true);
        setTitle("Controle de Livros");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360, 480);
        setLocationRelativeTo(null);
        
        jbAddLivros = new JButton("ADICIONAR LIVROS");
        jbDelLivros = new JButton("REMOVER LIVROS");
        jbEditLivros = new JButton("EDITAR LIVROS");
        verLivros = new JButton("VISUALIZAR LIVROS");
        jpPainel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        Dimension tamanhoBotao = new Dimension(240, 80);
        jbAddLivros.setPreferredSize(tamanhoBotao);
        jbDelLivros.setPreferredSize(tamanhoBotao);
        jbEditLivros.setPreferredSize(tamanhoBotao);
        verLivros.setPreferredSize(tamanhoBotao);
        
        jpPainel.add(jbAddLivros);
        jpPainel.add(jbDelLivros);
        jpPainel.add(jbEditLivros);
        jpPainel.add(verLivros);
        add(jpPainel, BorderLayout.CENTER);
        
    }
    
    private void actions() {
        jbAddLivros.addActionListener((e) -> {
            new TelaAddLivro().setVisible(true);
        });
        jbDelLivros.addActionListener((e) -> {
            if(LivroDao.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum livro encontrado!");
            } else {
                new TelaDelLivro().setVisible(true);
            }
        });
        jbEditLivros.addActionListener((e) -> {
            if(LivroDao.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum livro encontrado!");
            } else {
                new TelaEditLivro().setVisible(true);
            }
        });
        verLivros.addActionListener((e) -> {
            new TelaVerLivro().setVisible(true);
        });
    }
}
