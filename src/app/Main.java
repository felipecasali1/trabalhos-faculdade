package app;

import models.Produto;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Boolean run = true;
        do {
            Integer opt = Integer.valueOf(JOptionPane.showInputDialog(null, "MENU" +
                    "\n1 - Cadastro e Edição de Entidades" +
                    "\n2 - Operações e Estoque" +
                    "\n3 - Relatórios e Visualização" +
                    "\n0 - Sair"));
            switch (opt) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando");
                    run = false;
                    break;
                case 1:
                    Integer opt2 = Integer.valueOf(JOptionPane.showInputDialog(null, "Gerenciar produtos" +
                            "\n1 - Produtos" +
                            "\n2 - Categorias" +
                            "\n3 - Fornecedores" +
                            "\n4 - Vendedores" +
                            "\n0 - Voltar"));
                    switch (opt2) {
                        case 0:
                            break;
                        case 1:
                            Integer opt3 = Integer.valueOf(JOptionPane.showInputDialog(null, "Gerenciar produtos" +
                                    "\n1 - Cadastrar" +
                                    "\n2 - Editar" +
                                    "\n3 - Remover" +
                                    "\n0 - Voltar"));
                            switch (opt3) {
                                case 0:
                                    break;
                                case 1:
                                    Produto produto = new Produto();
                                    produto.setNome(JOptionPane.showInputDialog(null, "Nome do produto"));
                                    produto.setCodigo(Integer.valueOf(JOptionPane.showInputDialog(null, "Codigo do produto")));
                            }
                    }

            }
        } while(run);
    }
}
