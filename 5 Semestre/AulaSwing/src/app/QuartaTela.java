package app;

import controle.PrimeiraClasse;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuartaTela extends JFrame{

    private JTable tabela;
    private JScrollPane scroll;
    private JButton jbSair;
    private JButton jbCadastrar;
    private JPanel painel;
    public QuartaTela() {
        init();
        acoes();
    }
    private void init() {
            painel = new JPanel(new FlowLayout());
           jbSair= new JButton("Sair");
           jbCadastrar= new JButton("Cadastrar");
           setLayout(new BorderLayout());
           tabela = new JTable();
           scroll = new JScrollPane();
           scroll.setViewportView(tabela);
           add(painel,BorderLayout.PAGE_END);
           painel.add(jbSair);
           painel.add(jbCadastrar);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(400, 400);
           add(scroll,BorderLayout.CENTER);
          
//         List lista = new LinkedList();
//         lista.add("Andre");
//         String[] vetorTitle = new String []{"NOme"};       
//         Object[][] matrizDados= new Object[lista.size()][vetorTitle.length];
//         for(int i=0;i<lista.size();i++){
//             matrizDados[i][0]=lista.get(i);    
//             matrizDados[i][1]=lista.get(i);    
//             matrizDados[i][2]=lista.get(i);    
//          matrizDados[i]= new Object[]{};
   
//         }     
//         DefaultTableModel dm = new DefaultTableModel(matrizDados,vetorTitle);             
//         tabela.setModel(dm);
//        
    atualizaTabela();
    }
    public void atualizaTabela(){
        int qtd= PrimeiraClasse.qtdRegistro();//pega qtd registro
        String[] vetorTitle=PrimeiraClasse.titulos();//pega os titulos
         Object[][] matrizDados= new Object[qtd][vetorTitle.length];//aloca a matriz
         for(int i=0;i<qtd;i++){//prencher a matriz
             matrizDados[i]=PrimeiraClasse.getDados(i);    
         }     
         DefaultTableModel dm = new DefaultTableModel(matrizDados,vetorTitle);             
         tabela.setModel(dm); 
    }
    public static void main(String[] args) {
        new QuartaTela().setVisible(true);
    }

    private void acoes() {
        jbCadastrar.addActionListener((e)->{
            new TerceiraTela().setVisible(true);
            atualizaTabela();
        });
    }
    
}
