package view;

import dao.LivroDao;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaVerLivro extends JDialog {
    private JTable jtTabela;
    private JButton jbSair;
    private JScrollPane jspScroll;

    public TelaVerLivro() {
        init();
    }
    
    private void init() {
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(480, 360);
        setTitle("Visualizar Livros");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        jtTabela = new JTable();
        jspScroll = new JScrollPane();
        jspScroll.setViewportView(jtTabela);
        
        add(jspScroll, BorderLayout.CENTER);
        atualizarTabela();
    }
    
    public void atualizarTabela() {
        int qtd = LivroDao.qntLivros();
        String[] titulos = {"Título", "Autor", "Ano de Publicação"};
        Object[][] matrizLivros = new Object[qtd][titulos.length];
        
        for (int i = 0 ; i<qtd ; i++) {
            matrizLivros[i] = LivroDao.getDados(i);
        }
        
        DefaultTableModel dtm = new DefaultTableModel(matrizLivros, titulos);
        jtTabela.setModel(dtm);
    }
}
