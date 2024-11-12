package app;

import controller.CategoriaController;
import controller.FornecedorController;
import controller.ProdutoController;
import controller.VendedorController;
import models.*;
import persistence.CategoriaDao;
import persistence.FornecedorDao;
import persistence.ProdutoDao;
import persistence.VendedorDao;
import utils.InputUtils;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("categoria a", 1);
        Fornecedor fornecedor = new Fornecedor("Felipe", "12172461");
        CategoriaDao.salvar(categoria);
        FornecedorDao.salvar(fornecedor);
        Integer opt = null;
        do {
            opt = InputUtils.getIntegerInput("MENU" +
                    "\n1 - Cadastro e Edição" +
                    "\n2 - Operações e Estoque" +
                    "\n3 - Relatórios e Visualização" +
                    "\n0 - Sair");
            switch (opt) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando");
                    break;
                case 1:
                    menuCadastroEdicao();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while(opt != 0);
    }

    public static void menuCadastroEdicao() {
        Integer opt2 = null;
        do {
            opt2 = InputUtils.getIntegerInput("Cadastro e Edição" +
                    "\n1 - Produtos" +
                    "\n2 - Categorias" +
                    "\n3 - Fornecedores" +
                    "\n4 - Vendedores" +
                    "\n0 - Voltar");
            switch (opt2) {
                case 0:
                    break;
                case 1:
                    menuProdutos();
                    break;
                case 2:
                    menuCategorias();
                    break;
                case 3:
                    menuFornecedores();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt2 != 0);
    }

    public static void menuProdutos() {
        Integer opt3 = null;
        do {
            opt3 = InputUtils.getIntegerInput("Produtos" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar");
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuCadastrarProdutos();
                    break;
                case 2:
                    menuEditarProdutos();
                    break;
                case 3:
                    menuRemoverProdutos();
                    break;
                case 4:
                    menuListarProdutos();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuCadastrarProdutos() {
        if(!CategoriaDao.isEmpty() && !FornecedorDao.isEmpty()) {
            Produto produto = new Produto();
            Estoque estoque = new Estoque();
            try {
                String nome = InputUtils.getStringInput("Nome do produto");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                produto.setNome(nome);

                Integer codigo = InputUtils.getIntegerInput("Código do produto");
                if (codigo == null || codigo < 0 || ProdutoController.verificarCodigo(codigo)) {
                    throw new IllegalArgumentException("Código inválido!");
                }
                produto.setCodigo(codigo);

                Categoria categoria = (Categoria) InputUtils.getSelectionInput("Selecione a categoria", CategoriaDao.getCategorias().toArray());
                if (categoria == null) {
                    throw new IllegalArgumentException("Seleção inválida");
                }
                produto.setCategoria(categoria);

                Float preco = InputUtils.getFloatInput("Preço do produto");
                if (preco == null || preco <= 0) {
                    throw new IllegalArgumentException("Preço inválido!");
                }
                produto.setPreco(preco);

                Fornecedor fornecedor = (Fornecedor) InputUtils.getSelectionInput("Selecione o fornecedor", FornecedorDao.getFornecedores().toArray());
                if (fornecedor == null) {
                    throw new IllegalArgumentException("Seleção inválida!");
                }
                produto.setFornecedor(fornecedor);

                Integer quant = InputUtils.getIntegerInput("Quantidade em estoque");
                if (quant == null) {
                    throw new IllegalArgumentException("Quantidade inválida!");
                }
                estoque.setQuantidade(quant);
                Integer quantMin = InputUtils.getIntegerInput("Quantidade mínima");
                if (quantMin == null || quantMin <= 0) {
                    throw new IllegalArgumentException("Quantidade mínima inválida!");
                }
                estoque.setQuantidadeMinima(quantMin);
                produto.setEstoque(estoque);

                if (ProdutoController.salvar(produto)) {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                }
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
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto", ProdutoDao.getProdutos().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }
                Produto prodEditado = new Produto();
                Estoque estoque = new Estoque();

                String nome = InputUtils.getStringInput("Nome do produto");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                prodEditado.setNome(nome);

                Float preco = InputUtils.getFloatInput("Preço do produto");
                if (preco == null) {
                    throw new IllegalArgumentException("Preço inválido!");
                }
                prodEditado.setPreco(preco);

                Categoria categoria = (Categoria) InputUtils.getSelectionInput("Selecione a categoria", CategoriaDao.getCategorias().toArray());
                if (categoria == null) {
                    throw new IllegalArgumentException("Erro na seleção de categoria!");
                }
                prodEditado.setCategoria(categoria);

                Fornecedor fornecedor = (Fornecedor) InputUtils.getSelectionInput("Selecione o fornecedor", FornecedorDao.getFornecedores().toArray());
                if (fornecedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do fornecedor!");
                }
                prodEditado.setFornecedor(fornecedor);

                Integer quant = InputUtils.getIntegerInput("Quantidade atual em estoque");
                if (quant == null || quant < 0) {
                    throw new IllegalArgumentException("Quantidade inválida!");
                }
                estoque.setQuantidade(quant);

                Integer quantMin = InputUtils.getIntegerInput("Quantidade mínima");
                if (quantMin == null || quantMin <= 0) {
                    throw new IllegalArgumentException("Quantidade mínima inválida!");
                }
                estoque.setQuantidadeMinima(quantMin);
                prodEditado.setEstoque(estoque);

                if (ProdutoController.editar(prod.getCodigo(), prodEditado)) {
                    JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
                }
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

    public static void menuRemoverProdutos() {
        try {
            Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto a ser removido", ProdutoDao.getProdutos().toArray());
            if (prod == null) {
                throw new IllegalArgumentException("Erro na seleção de produto!");
            }
            if (ProdutoController.excluir(prod)) {
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void menuListarProdutos() {
        try {
            Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.getProdutos().toArray());
            if (prod == null) {
                throw new IllegalArgumentException("Erro na seleção de produto!");
            }
            JOptionPane.showMessageDialog(null, ProdutoController.toString(prod));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void menuCategorias() {
        Integer opt3 = null;
        do {
            opt3 = Integer.valueOf(JOptionPane.showInputDialog(null, "Categorias" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar"));
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuCadastrarCategorias();
                    break;
                case 2:
                    menuEditarCategorias();
                    break;
                case 3:
                    menuRemoverCategorias();
                    break;
                case 4:
                    menuListarCategorias();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuCadastrarCategorias() {
        try {
            Categoria categoria = new Categoria();
            String nome = JOptionPane.showInputDialog(null, "Nome da categoria");
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido!");
            }
            categoria.setNome(nome);

            Integer codigo = InputUtils.getIntegerInput("Código da categoria");
            if (codigo == null || codigo < 0 || CategoriaController.verificarCodigo(codigo)) {
                throw new IllegalArgumentException("Código inválido!");
            }
            categoria.setCodigo(codigo);

            if (CategoriaController.salvar(categoria)) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }

    public static void menuEditarCategorias() {
        if(!CategoriaDao.isEmpty()) {
            try {
                Categoria catEditada = new Categoria();
                Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria", CategoriaDao.getCategorias().toArray());
                if (cat == null) {
                    throw new IllegalArgumentException("Erro na seleção de categoria!");
                }

                String nome = InputUtils.getStringInput("Nome do produto");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                catEditada.setNome(nome);

                if (CategoriaController.editar(cat.getCodigo(), catEditada)) {
                    JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada.");
        }
    }

    public static void menuRemoverCategorias() {
        try {
            Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria a ser removida", CategoriaDao.getCategorias().toArray());
            if (cat == null) {
                throw new IllegalArgumentException("Erro na seleção de categoria!");
            }
            if (CategoriaController.excluir(cat)) {
                JOptionPane.showMessageDialog(null, "Categoria removida com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void menuListarCategorias() {
        try {
            Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria:", CategoriaDao.getCategorias().toArray());
            if (cat == null) {
                throw new IllegalArgumentException("Erro na seleção da categoria!");
            }
            JOptionPane.showMessageDialog(null, CategoriaController.toString(cat));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void menuFornecedores() {
        Integer opt3 = null;
        do {
            opt3 = Integer.valueOf(JOptionPane.showInputDialog(null, "Fornecedores" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar"));
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuCadastrarFornecedores();
                    break;
                case 2:
                    menuEditarFornecedores();
                    break;
                case 3:
                    menuRemoverFornecedores();
                    break;
                case 4:
                    menuListarFornecedores();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuCadastrarFornecedores() {
        try {
            Fornecedor fornecedor = new Fornecedor();
            String nome = JOptionPane.showInputDialog(null, "Nome do fornecedor");
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido!");
            }
            fornecedor.setNome(nome);

            String cnpj = JOptionPane.showInputDialog(null, "Cnpj do fornecedor");
            if (cnpj == null || cnpj.isEmpty() || FornecedorController.verificarCnpj(cnpj)) {
                throw new IllegalArgumentException("Cnpj inválido!");
            }
            fornecedor.setCnpj(cnpj);

            if (FornecedorController.salvar(fornecedor)) {
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }

    public static void menuEditarFornecedores() {
        if(!FornecedorDao.isEmpty()) {
            try {
                Fornecedor fornecedorEditado = new Fornecedor();
                Fornecedor fornecedor = (Fornecedor) InputUtils.getSelectionInput("Selecione o fornecedor", FornecedorDao.getFornecedores().toArray());
                if (fornecedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do fornecedor!");
                }

                String nome = InputUtils.getStringInput("Nome do fornecedor");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                fornecedorEditado.setNome(nome);

                if (FornecedorController.editar(fornecedor.getCnpj(), fornecedorEditado)) {
                    JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado.");
        }
    }

    public static void menuRemoverFornecedores() {
        try {
            Fornecedor fornecedor = (Fornecedor) InputUtils.getSelectionInput("Selecione o fornecedor a ser removido", FornecedorDao.getFornecedores().toArray());
            if (fornecedor == null) {
                throw new IllegalArgumentException("Erro na seleção do fornecedor!");
            }
            if (FornecedorController.excluir(fornecedor)) {
                JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void menuListarFornecedores() {
        try {
            Fornecedor fornecedor = (Fornecedor) InputUtils.getSelectionInput("Selecione o fornecedor:", CategoriaDao.getCategorias().toArray());
            if (fornecedor == null) {
                throw new IllegalArgumentException("Erro na seleção do fornecedor!");
            }
            JOptionPane.showMessageDialog(null, FornecedorController.toString(fornecedor));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void menuVendedores() {
        Integer opt3 = null;
        do {
            opt3 = Integer.valueOf(JOptionPane.showInputDialog(null, "Vendedores" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar"));
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuCadastrarVendedores();
                    break;
                case 2:
                    menuEditarVendedores();
                    break;
                case 3:
                    menuRemoverVendedores();
                    break;
                case 4:
                    menuListarVendedores();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuCadastrarVendedores() {
        try {
            Vendedor vendedor = new Vendedor();
            String nome = JOptionPane.showInputDialog(null, "Nome do vendedor");
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido!");
            }
            vendedor.setNome(nome);

            String cpf = JOptionPane.showInputDialog(null, "Cpf do vendedor");
            if (cpf == null || cpf.isEmpty() || VendedorController.verificarCpf(cpf)) {
                throw new IllegalArgumentException("Cpf inválido!");
            }
            vendedor.setCpf(cpf);

            if (VendedorController.salvar(vendedor)) {
                JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }

    public static void menuEditarVendedores() {
        if(!VendedorDao.isEmpty()) {
            try {
                Vendedor vendedor = new Vendedor();
                Vendedor vendedorEditado = (Vendedor) InputUtils.getSelectionInput("Selecione o vendedor", VendedorDao.getVendedores().toArray());
                if (vendedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do vendedor!");
                }

                String nome = InputUtils.getStringInput("Nome do vendedor");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                vendedorEditado.setNome(nome);

                if (VendedorController.editar(vendedor.getCpf(), vendedorEditado)) {
                    JOptionPane.showMessageDialog(null, "Vendedor editado com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado.");
        }
    }

    public static void menuRemoverVendedores() {

    }

    public static void menuListarVendedores() {

    }
}


