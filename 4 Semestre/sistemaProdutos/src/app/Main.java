package app;
import entities.Produtos;
import entities.Eletronicos;
import entities.Roupas;
import entities.Interface;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        List<Produtos> listaProdutos = new LinkedList();
        Boolean exec = true;
        while(exec){
            String opcao = JOptionPane.showInputDialog(null, "\nMENU"
                    + "\n1 - Cadastrar Eletronico"
                    + "\n2 - Cadastrar Roupa"
                    + "\n3 - Listar Produtos"
                    + "\n0 - Encerrar Programa");
            if(opcao!=null){
                switch(opcao){
                    case "0":
                        JOptionPane.showMessageDialog(null, "Encerrando o Programa!");
                        exec = false;
                        break;
                    case "1":
                        Produtos produtoE = new Eletronicos();
                        produtoE.setNome(JOptionPane.showInputDialog(null, "Informe o nome: "));
                        produtoE.setPreco(Float.valueOf(JOptionPane.showInputDialog(null, "Informe o preco: ")));
                        ((Eletronicos)produtoE).setMarca(JOptionPane.showInputDialog(null, "Informe a marca: "));
                        ((Eletronicos)produtoE).setGarantia(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe a garantia: ")));
                        listaProdutos.add(produtoE);
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado!");
                        break;
                    case "2":
                        Produtos produtoR = new Roupas();
                        produtoR.setNome(JOptionPane.showInputDialog(null, "Informe o nome: "));
                        produtoR.setPreco(Float.valueOf(JOptionPane.showInputDialog(null, "Informe o preco: ")));
                        ((Roupas)produtoR).setMarca(JOptionPane.showInputDialog(null, "Informe a marca: "));
                        ((Roupas)produtoR).setTamanho(JOptionPane.showInputDialog(null, "Informe o tamanho: "));
                        listaProdutos.add(produtoR);
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado!");
                        break;
                    case "3":
                        if(listaProdutos.isEmpty()){
                            JOptionPane.showMessageDialog(null, "\nNenhum produto cadastrado!");
                        } else {
                            JOptionPane.showMessageDialog(null, "\nListagem dos Cadastros: ");
                            for(Produtos prod : listaProdutos){
                                JOptionPane.showMessageDialog(null, prod.exibInformacoes());
                            }
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcao Invalida!");
                        break;
                }
            }
        }
    }
}
