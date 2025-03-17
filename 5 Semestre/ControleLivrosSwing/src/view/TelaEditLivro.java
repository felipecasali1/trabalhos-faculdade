package view;

import dao.LivroDao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import models.Livro;

public class TelaEditLivro extends JDialog {
    private JComboBox jcbCbox;
    private JPanel jpPainelTexto;
    private JPanel jpPainelEscolha;
    private JPanel jpPainelButtons;
    private JScrollPane jspScroll;
    private JButton jbEditar;
    private JButton jbSair;
    private JLabel jlSelec;
    private JLabel jlTitulo;
    private JLabel jlAutor;
    private JLabel jlAno;
    private JTextField jtTitulo;
    private JTextField jtAutor;
    private JTextField jtAno;
    
    public TelaEditLivro() {
        init();
        actions();
    }
    
    private void init() {
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(480, 360);
        setTitle("Editar Livro");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        jcbCbox = new JComboBox(LivroDao.getLivros().toArray());
        jlSelec = new JLabel("Selecione o livro");
        jlTitulo = new JLabel("Título");
        jlAutor = new JLabel("Autor");
        jlAno = new JLabel("Ano de publicação");
        jtTitulo = new JTextField();
        jtAutor = new JTextField();
        jtAno = new JTextField();
        jbEditar = new JButton("Editar");
        jbSair = new JButton("Sair");
        jpPainelTexto = new JPanel(new GridLayout(8, 1, 5, 5));
        jpPainelButtons = new JPanel(new FlowLayout());
        jpPainelEscolha = new JPanel(new GridLayout(2, 1, 5, 5));
        jspScroll = new JScrollPane();
        
        jlSelec.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jtTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlAutor.setHorizontalAlignment(JLabel.CENTER);
        jtAutor.setHorizontalAlignment(JLabel.CENTER);
        jlAno.setHorizontalAlignment(JLabel.CENTER);
        jtAno.setHorizontalAlignment(JLabel.CENTER);
        
        jspScroll.setViewportView(jcbCbox);
        jpPainelEscolha.add(jlSelec);
        jpPainelEscolha.add(jspScroll);
        add(jpPainelEscolha, BorderLayout.NORTH);
        
        jpPainelTexto.add(jlTitulo);
        jpPainelTexto.add(jtTitulo);
        jpPainelTexto.add(jlAutor);
        jpPainelTexto.add(jtAutor);
        jpPainelTexto.add(jlAno);
        jpPainelTexto.add(jtAno);
        jpPainelTexto.add(jbEditar);
        jpPainelTexto.add(jbSair);
        add(jpPainelTexto, BorderLayout.CENTER);
        
        jpPainelButtons.add(jbEditar);
        jpPainelButtons.add(jbSair);
        add(jpPainelButtons, BorderLayout.SOUTH);
    }
    
    private void actions() {
        jbEditar.addActionListener((e) -> {
            try {
                if (jtTitulo.getText().isEmpty() || jtAutor.getText().isEmpty() || jtAno.getText().isEmpty()) {
                    throw new IllegalArgumentException("Todos os campos são obrigatórios!");
                } else {
                    LivroDao.editar((Livro)jcbCbox.getSelectedItem() ,jtTitulo.getText(), jtAutor.getText(), jtAno.getText());
                    JOptionPane.showMessageDialog(rootPane, "Livro editado!");
                    dispose();
                }
            } catch (IllegalArgumentException ex) {
                 System.out.println("Erro: " + ex.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        jbSair.addActionListener((e) -> {
            dispose();
        });
    }
}
