package app;

import entities.Marca;
import entities.Produto;
import entities.Usuario;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Boolean run = true;
        List<Produto> produtos = new LinkedList<>();
        List<Marca> marcas = new LinkedList<>();
        
        do{
            Integer option = Integer.valueOf(JOptionPane.showInputDialog(null, "MENU"
                    + "\n1 - Cadastrar produto"
                    + "\n2 - Cadastrar marca"
                    + "\n3 - Exibir produtos"
                    + "\n0 - Sair")); 
            switch(option){
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando...");
                    run = false;
                    break;
                case 1:
                    Produto produto = new Produto();
                    Usuario user = new Usuario();
                    int i = 1;
                    Boolean verif = false;
                    if(marcas.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhuma marca cadastrada!");
                        break;
                    } else {
                        user.setNome(JOptionPane.showInputDialog(null, "Informe seu nome"));
                        user.setCpf(JOptionPane.showInputDialog(null, "Informe seu CPF"));
                        produto.setUsuario(user);
                        JOptionPane.showMessageDialog(null, "Listagem de marcas cadastradas");
                        for(Marca m : marcas){
                            JOptionPane.showMessageDialog(null, "Marca: "+m.getNome());
                        }
                        String escolha = JOptionPane.showInputDialog(null, "Escolha a marca do produto");                
                        for(Marca m : marcas){
                            if(m.getNome().equalsIgnoreCase(escolha)){
                                produto.setMarca(m);
                                verif = true;
                            }
                        }
                    }
                    if(verif){
                        produto.setNome(JOptionPane.showInputDialog(null, "Informe o nome do produto"));
                        produtos.add(produto);
                        JOptionPane.showMessageDialog(null, "Produto cadastrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Marca não encontrada!");
                    }
                    break;
                case 2:
                    Marca marca = new Marca();
                    marca.setNome(JOptionPane.showInputDialog(null, "Informe a marca do produto"));
                    marcas.add(marca);
                    break;
                case 3:
                    if(produtos.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Listagem de produtos");
                        for(Produto prod : produtos){
                            JOptionPane.showMessageDialog(null, prod.toString());
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
                    break;
            }
        } while(run);
    }
}
