package view;

import dao.LivroDao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TelaDelLivro extends JDialog {
    private JButton jbRemover;
    private JButton jbSair;
    private JList jlLista;
    private JScrollPane jspScroll;
    private JPanel jpPainel;
    private JLabel jlLabel;

    public TelaDelLivro() {
        init();
        actions();
    }
    
    private void init() {
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(480, 360);
        setTitle("Remover Livro");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        jlLista = new JList<>(LivroDao.getLivros().toArray());
        jspScroll = new JScrollPane();
        jpPainel = new JPanel(new FlowLayout());
        jbRemover = new JButton("Remover");
        jbSair = new JButton("Sair");
        jlLabel = new JLabel("Selecione os livros");
        
        jlLabel.setHorizontalAlignment(JLabel.CENTER);
        jlLabel.setVerticalAlignment(JLabel.CENTER);
        jlLabel.setPreferredSize(new Dimension(480, 40));
        
        add(jlLabel, BorderLayout.NORTH);
        jspScroll.setViewportView(jlLista);
        add(jspScroll, BorderLayout.CENTER);
        jpPainel.add(jbRemover);
        jpPainel.add(jbSair);
        add(jpPainel, BorderLayout.SOUTH);
    }
    
    private void actions() {
        jbRemover.addActionListener((e) -> {
            if(jlLista.getSelectedValuesList().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum livro selecionado!");
            } else {
                LivroDao.remover(jlLista.getSelectedValuesList());
                jlLista.setListData(LivroDao.getLivros().toArray());
            }
        });
        jbSair.addActionListener((e) -> {
            dispose();
        });
    }
}
