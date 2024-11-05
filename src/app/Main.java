package app;

import controller.ProdutoController;
import models.Categoria;
import models.Estoque;
import models.Fornecedor;
import models.Produto;
import persistence.CategoriaDao;
import persistence.FornecedorDao;
import persistence.ProdutoDao;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Boolean run = true;
        Fornecedor fornecedor1 = new Fornecedor("Felipe", "123123");
        Categoria categoria1 = new Categoria("Frutas", 123123);
        FornecedorDao.salvar(fornecedor1);
        CategoriaDao.salvar(categoria1);
        do {
            Integer opt = Integer.valueOf(JOptionPane.showInputDialog(null, "MENU" +
                    "\n1 - Cadastro e Edição" +
                    "\n2 - Operações e Estoque" +
                    "\n3 - Relatórios e Visualização" +
                    "\n0 - Sair"));
            switch (opt) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando");
                    run = false;
                    break;
                case 1:
                    menuCadastroEdicao();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida! 1");
                    break;
            }
        } while(run);
    }

    public static void menuCadastroEdicao() {
        Integer opt2 = null;
        do {
            opt2 = Integer.valueOf(JOptionPane.showInputDialog(null, "Cadastro e Edição" +
                    "\n1 - Produtos" +
                    "\n2 - Categorias" +
                    "\n3 - Fornecedores" +
                    "\n4 - Vendedores" +
                    "\n0 - Voltar"));
            switch (opt2) {
                case 0:
                    break;
                case 1:
                    menuProdutos();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida! 2");
                    break;
            }
        } while (opt2 != 0);
    }

    public static void menuProdutos() {
        Integer opt3 = null;
        do {
            opt3 = Integer.valueOf(JOptionPane.showInputDialog(null, "Produtos" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar"));
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuCadastrarProdutos();
                    break;
                case 2:
                    menuEditarProdutos();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida! 3");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuCadastrarProdutos() {
        if(!CategoriaDao.isEmpty() && !FornecedorDao.isEmpty()) {
            Produto produto = new Produto();
            Estoque estoque = new Estoque();
            try {
                String nome = JOptionPane.showInputDialog(null, "Nome do produto");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                produto.setNome(nome);

                String codigo = JOptionPane.showInputDialog(null, "Código do produto");
                if (codigo == null || codigo.isEmpty()) {
                    throw new IllegalArgumentException("Código inválido!");
                }
                produto.setCodigo(Integer.valueOf(codigo));

                Categoria categoria = (Categoria) JOptionPane.showInputDialog(null, "Selecione a categoria:", "Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDao.getCategorias().toArray(), null);
                if (categoria == null) {
                    throw new IllegalArgumentException("Erro na seleção de categoria!");
                }
                produto.setCategoria(categoria);

                String preco = JOptionPane.showInputDialog(null, "Preço do produto");
                if (preco == null || preco.isEmpty()) {
                    throw new IllegalArgumentException("Preço inválido!");
                }
                produto.setPreco(Float.valueOf(preco));

                Fornecedor fornecedor = (Fornecedor) JOptionPane.showInputDialog(null, "Selecione o fornecedor:", "Fornecedor", JOptionPane.QUESTION_MESSAGE, null, FornecedorDao.getFornecedores().toArray(), null);
                if (fornecedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do fornecedor!");
                }
                produto.setFornecedor(fornecedor);

                Integer quant = Integer.valueOf(JOptionPane.showInputDialog(null, "Quantidade atual em estoque"));
                if (quant == null) {
                    throw new IllegalArgumentException("Quantidade inválida!");
                }
                estoque.setQuantidade(quant);
                Integer quantMin = Integer.valueOf(JOptionPane.showInputDialog(null, "Quantidade mínima do estoque"));
                if (quantMin == null) {
                    throw new IllegalArgumentException("Quantidade inválida!");
                }
                estoque.setQuantidadeMinima(quantMin);
                produto.setEstoque(estoque);

                ProdutoController.salvar(produto);
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            if (CategoriaDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada.");
            }
            if (FornecedorDao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nenhum fornecedor cadastrado.");
            }
        }
    }

    public static void menuEditarProdutos() {
        if(!ProdutoDao.isEmpty() && !CategoriaDao.isEmpty() && !FornecedorDao.isEmpty()) {
            try {
                Produto prod = (Produto) JOptionPane.showInputDialog(null, "Selecione o produto:", "Produto", JOptionPane.QUESTION_MESSAGE, null, ProdutoDao.getProdutos().toArray(), null);
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }
                Produto prodEditado = new Produto();
                Estoque estoque = new Estoque();

                String nome = JOptionPane.showInputDialog(null, "Nome do produto");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                prodEditado.setNome(nome);

                String preco = JOptionPane.showInputDialog(null, "Preço do produto");
                if (preco == null) {
                    throw new IllegalArgumentException("Preço inválido!");
                }
                prodEditado.setPreco(Float.valueOf(preco));

                Categoria categoria = (Categoria) JOptionPane.showInputDialog(null, "Selecione a categoria:", "Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDao.getCategorias().toArray(), null);
                if (categoria == null) {
                    throw new IllegalArgumentException("Erro na seleção de categoria!");
                }
                prodEditado.setCategoria(categoria);

                Fornecedor fornecedor = (Fornecedor) JOptionPane.showInputDialog(null, "Selecione o fornecedor:", "Fornecedor", JOptionPane.QUESTION_MESSAGE, null, FornecedorDao.getFornecedores().toArray(), null);
                if (fornecedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do fornecedor!");
                }
                prodEditado.setFornecedor(fornecedor);

                estoque.setQuantidade(Integer.valueOf(JOptionPane.showInputDialog(null, "Quantidade atual em estoque")));
                estoque.setQuantidadeMinima(Integer.valueOf(JOptionPane.showInputDialog(null, "Quantidade mínima do estoque")));
                prodEditado.setEstoque(estoque);

                ProdutoController.editar(prod.getCodigo(), prodEditado);
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            if (ProdutoDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.");
            }
            if (CategoriaDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada.");
            }
            if (FornecedorDao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado.");
            }
        }
    }
}
