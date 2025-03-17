package app;

import controle.PrimeiraClasse;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class TerceiraTela extends JDialog{
    JLabel jlNome;
    JLabel jlIdade;
    JLabel jlEndereco;
    JTextField jtNome;
    JTextField jtIdade;
    JTextArea jtEndereco;
    JScrollPane jsRolagem;
    JButton jbSalvar;
    JButton jbSair;
    public TerceiraTela() {
        iniciaComponentes();       
    }
    private void iniciaComponentes() {
        //alocando os componentes
        jbSalvar = new JButton("Salvar");
        jbSair = new JButton("Sair");
        jlNome=new JLabel("Nome: ");
        jlIdade = new JLabel("Idade: ");
        jlEndereco = new JLabel("Endereço: ");
        jtNome = new JTextField();
        jtIdade = new JTextField();
        jtEndereco = new JTextArea();  
        jsRolagem= new JScrollPane(jtEndereco);
        posicionarComponentes();
        acoesComponentes();
        setSize(500,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
    }
    private void posicionarComponentes() {
        setLayout(null);
        jlIdade.setBounds(10, 10, 60, 30);
        jtIdade.setBounds(80, 10, 360, 30);
        jlNome.setBounds(10, 50, 60, 30);
        jtNome.setBounds(80, 50, 360, 30);
        jlEndereco.setBounds(10, 90, 80, 30);
        jsRolagem.setBounds(80, 90, 360, 160);
        jbSalvar.setBounds(150, 250, 100, 40);
        jbSair.setBounds(250, 250, 100, 40);
        add(jbSalvar);
        add(jbSair);
        add(jlIdade);
        add(jtIdade);
        add(jlNome);
        add(jtNome);
        add(jlEndereco);
        add(jsRolagem);
    }
      public static void main(String[] args) {
        new TerceiraTela().setVisible(true);
    }

    private void acoesComponentes() {
        jbSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimeiraClasse.
                        cadastro(
                                jtNome.getText(),
                                jtIdade.getText(),
                                jtEndereco.getText()
                        );
                //salvar
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                dispose();
            }
        });
        jbSair.addActionListener((e -> {
            dispose();
        }));
    }
}
