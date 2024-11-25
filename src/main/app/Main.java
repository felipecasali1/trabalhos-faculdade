package main.app;

import main.controller.*;
import main.models.*;
import main.persistence.*;
import main.utils.InputUtils;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer opt = 0;
        do {
            String input = InputUtils.getStringInput("MENU" +
                    "\n1 - Cadastro e Edição" +
                    "\n2 - Operações e Estoque" +
                    "\n3 - Relatórios e Visualização" +
                    "\n0 - Sair");
            if (input == null) {
                opt = 0;
                break;
            }
            try {
                opt = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt = -1;
            }
            switch (opt) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando");
                    break;
                case 1:
                    menuCadastroEdicao();
                    break;
                case 2:
                    menuOperacoesEstoque();
                    break;
                case 3:
                    menuRelatorios();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt != 0);
    }

    public static void menuCadastroEdicao() {
        Integer opt2 = 0;
        do {
            String input = InputUtils.getStringInput("Cadastro e Edição" +
                    "\n1 - Produtos" +
                    "\n2 - Categorias" +
                    "\n3 - Fornecedores" +
                    "\n4 - Vendedores" +
                    "\n5 - Clientes" +
                    "\n0 - Voltar");
            if (input == null) {
                opt2 = 0;
                break;
            }
            try {
                opt2 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt2 = -1;
            }
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
                case 4:
                    menuVendedores();
                    break;
                case 5:
                    menuClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt2 != 0);
    }

    public static void menuProdutos() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Produtos" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
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
                    Registro registro = new Registro(produto, "Entrada", quant, new Date());
                    RegistroController.salvar(registro);
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
                JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada!");
            }
            if (FornecedorDao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nenhum fornecedor cadastrado!");
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
                if (preco == null || preco <= 0) {
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

                estoque.setQuantidade(prod.getEstoque().getQuantidade());

                Integer quantMin = InputUtils.getIntegerInput("Quantidade mínima");
                if (quantMin == null || quantMin <= 0) {
                    throw new IllegalArgumentException("Quantidade mínima inválida!");
                }
                estoque.setQuantidadeMinima(quantMin);
                prodEditado.setEstoque(estoque);

                if (ProdutoController.editar(prod.getCodigo(), prodEditado)) {
                    JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
                    ProdutoVendidoController.limpar();
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
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
            } else if (CategoriaDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada!");
            } else if (FornecedorDao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado!");
            }
        }
    }

    public static void menuRemoverProdutos() {
        if(!ProdutoDao.isEmpty()) {
            try {
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto a ser removido", ProdutoDao.getProdutos().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }
                if (ProdutoController.excluir(prod)) {
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    Registro registro = new Registro(prod, "Saída", prod.getEstoque().getQuantidade(), new Date());
                    RegistroController.salvar(registro);
                }
                ProdutoVendidoController.limpar();
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
        }
    }

    public static void menuListarProdutos() {
        if(!ProdutoDao.isEmpty()) {
            try {
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.getProdutos().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }
                JOptionPane.showMessageDialog(null, ProdutoController.toString(prod));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
        }
    }

    public static void menuCategorias() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Categorias" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
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
                JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
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
                    JOptionPane.showMessageDialog(null, "Categoria editada com sucesso!");
                    ProdutoVendidoController.limpar();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada!");
        }
    }

    public static void menuRemoverCategorias() {
        if(!CategoriaDao.isEmpty()) {
            try {
                Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria a ser removida", CategoriaDao.getCategorias().toArray());
                if (cat == null) {
                    throw new IllegalArgumentException("Erro na seleção de categoria!");
                }
                if (CategoriaController.excluir(cat)) {
                    JOptionPane.showMessageDialog(null, "Categoria removida com sucesso!");
                    ProdutoVendidoController.limpar();
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada!");
        }
    }

    public static void menuListarCategorias() {
        if(!CategoriaDao.isEmpty()) {
            try {
                Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria:", CategoriaDao.getCategorias().toArray());
                if (cat == null) {
                    throw new IllegalArgumentException("Erro na seleção da categoria!");
                }
                JOptionPane.showMessageDialog(null, CategoriaController.toString(cat));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada!");
        }
    }

    public static void menuFornecedores() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Fornecedores" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
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
                    ProdutoVendidoController.limpar();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado!");
        }
    }

    public static void menuRemoverFornecedores() {
        if(!FornecedorDao.isEmpty()) {
            try {
                Fornecedor fornecedor = (Fornecedor) InputUtils.getSelectionInput("Selecione o fornecedor a ser removido", FornecedorDao.getFornecedores().toArray());
                if (fornecedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do fornecedor!");
                }
                if (FornecedorController.excluir(fornecedor)) {
                    JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
                    ProdutoVendidoController.limpar();
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado!");
        }
    }

    public static void menuListarFornecedores() {
        if(!FornecedorDao.isEmpty()) {
            try {
                Fornecedor fornecedor = (Fornecedor) InputUtils.getSelectionInput("Selecione o fornecedor:", FornecedorDao.getFornecedores().toArray());
                if (fornecedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do fornecedor!");
                }
                JOptionPane.showMessageDialog(null, FornecedorController.toString(fornecedor));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado!");
        }
    }

    public static void menuVendedores() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Vendedores" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Remover" +
                    "\n4 - Listar" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
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
            String nome = InputUtils.getStringInput("Nome do vendedor");
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido!");
            }
            vendedor.setNome(nome);

            String cpf = InputUtils.getStringInput("Cpf do vendedor");
            if (cpf == null || cpf.isEmpty() || VendedorController.verificarCpf(cpf) || ClienteController.verificarCpf(cpf)) {
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
                Vendedor vendedorEditado = new Vendedor();
                Vendedor vendedor = (Vendedor) InputUtils.getSelectionInput("Selecione o vendedor", VendedorDao.getVendedores().toArray());
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
                    ProdutoVendidoController.limpar();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum vendedor encontrado!");
        }
    }

    public static void menuRemoverVendedores() {
        if(!VendedorDao.isEmpty()) {
            try {
                Vendedor vendedor = (Vendedor) InputUtils.getSelectionInput("Selecione o vendedor a ser removido", VendedorDao.getVendedores().toArray());
                if (vendedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do vendedor!");
                }
                if (VendedorController.excluir(vendedor)) {
                    JOptionPane.showMessageDialog(null, "Vendedor removido com sucesso!");
                    ProdutoVendidoController.limpar();
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum vendedor encontrado!");
        }
    }

    public static void menuListarVendedores() {
        if(!VendedorDao.isEmpty()) {
            try {
                Vendedor vendedor = (Vendedor) InputUtils.getSelectionInput("Selecione o vendedor:", VendedorDao.getVendedores().toArray());
                if (vendedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do vendedor!");
                }
                JOptionPane.showMessageDialog(null, VendedorController.toString(vendedor));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum vendedor encontrado!");
        }
    }

    public static void menuClientes() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Clientes" +
                    "\n1 - Cadastrar" +
                    "\n2 - Editar" +
                    "\n3 - Listar" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuCadastrarCliente();
                    break;
                case 2:
                    menuEditarClientes();
                    break;
                case 3:
                    menuListarClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuCadastrarCliente() {
        try {
            Cliente cliente = new Cliente();

            String cpf = InputUtils.getStringInput("Cpf do cliente");
            if (cpf == null || cpf.isEmpty() || ClienteController.verificarCpf(cpf) || VendedorController.verificarCpf(cpf)) {
                throw new IllegalArgumentException("Cpf inválido!");
            }
            cliente.setCpf(cpf);

            String nome = InputUtils.getStringInput("Nome do cliente");
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome inválido!");
            }
            cliente.setNome(nome);

            String telefone = InputUtils.getStringInput("Telefone do cliente");
            if (telefone == null || telefone.isEmpty()) {
                throw new IllegalArgumentException("Telefone inválido!");
            }
            cliente.setTelefone(telefone);

            String email = InputUtils.getStringInput("Email do cliente");
            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("Email inválido!");
            }
            cliente.setEmail(email);

            if (ClienteController.salvar(cliente)) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }

    public static void menuListarClientes() {
        if(!ClienteDao.isEmpty()) {
            try {
                Cliente cliente = (Cliente) InputUtils.getSelectionInput("Selecione o cliente", ClienteDao.getClientes().toArray());
                if (cliente == null) {
                    throw new IllegalArgumentException("Erro na seleção de cliente!");
                }

                JOptionPane.showMessageDialog(null, ClienteController.toString(cliente));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado!");
        }
    }

    public static void menuEditarClientes() {
        if(!ClienteDao.isEmpty()) {
            try {
                Cliente clienteEditado = new Cliente();
                Cliente cliente = (Cliente) InputUtils.getSelectionInput("Selecione o cliente", ClienteDao.getClientes().toArray());
                if (cliente == null) {
                    throw new IllegalArgumentException("Erro na seleção de cliente!");
                }

                String nome = InputUtils.getStringInput("Nome do cliente");
                if (nome == null || nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome inválido!");
                }
                clienteEditado.setNome(nome);

                String telefone = InputUtils.getStringInput("Telefone do cliente");
                if (telefone == null || telefone.isEmpty()) {
                    throw new IllegalArgumentException("Telefone inválido!");
                }
                clienteEditado.setTelefone(telefone);

                String email = InputUtils.getStringInput("Email do cliente");
                if (email == null || email.isEmpty()) {
                    throw new IllegalArgumentException("Email inválido!");
                }
                clienteEditado.setEmail(email);

                if (ClienteController.editar(cliente.getCpf(), clienteEditado)) {
                    JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
                    ProdutoVendidoController.limpar();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado!");
        }
    }

    public static void menuOperacoesEstoque() {
        Integer opt2 = null;
        do {
            String input = InputUtils.getStringInput("Operações e Estoque" +
                    "\n1 - Vendas" +
                    "\n2 - Estoque" +
                    "\n0 - Voltar");
            if (input == null) {
                opt2 = 0;
                break;
            }
            try {
                opt2 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt2 = -1;
            }
            switch (opt2) {
                case 0:
                    break;
                case 1:
                    menuVendas();
                    break;
                case 2:
                    menuEstoque();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt2 != 0);
    }

    public static void menuVendas() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Vendas" +
                    "\n1 - Adicionar Produtos no Carrinho" +
                    "\n2 - Remover Produto do Carrinho" +
                    "\n3 - Limpar Carrinho" +
                    "\n4 - Listar Produtos no Carrinho" +
                    "\n5 - Finalizar Venda" +
                    "\n6 - Listar Vendas" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuVendasAdicionarProdutos();
                    break;
                case 2:
                    menuVendaRemoverProdutos();
                    break;
                case 3:
                    menuVendaLimparProdutos();
                    break;
                case 4:
                    menuVendaListarProdutos();
                    break;
                case 5:
                    menuVendaFinalizar();
                    break;
                case 6:
                    menuVendaListar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuVendasAdicionarProdutos() {
        if (!ProdutoDao.isEmpty()) {
            try {
                if (!ProdutoVendidoDao.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você possui outros itens adicionados!");
                }
                ProdutoVendido produtoVendido = new ProdutoVendido();
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.getProdutos().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }
                produtoVendido.setProduto(prod);

                ProdutoVendido prodVExistente = null;
                Integer quantAdicionada = 0;
                for (ProdutoVendido prodV : ProdutoVendidoDao.getProdutosVendidos()) {
                    if (prodV.getProduto().equals(prod)) {
                        quantAdicionada += prodV.getQuantidade();
                        prodVExistente = prodV;
                    }
                }
                Integer quantDisp = prod.getEstoque().getQuantidade() - quantAdicionada;

                if (quantDisp > 0) {
                    Integer quant = InputUtils.getIntegerInput("Quantidade - Disponível: " + quantDisp);
                    if (quant == null || quant <= 0) {
                        throw new IllegalArgumentException("Quantidade inválida!");
                    }
                    if(quant > quantDisp) {
                        throw new IllegalArgumentException("Quantidade indisponível no estoque!");
                    }
                    if (quantAdicionada != 0) {
                        prodVExistente.setQuantidade(prodVExistente.getQuantidade() + quant);
                        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                    } else {
                        produtoVendido.setQuantidade(quant);
                        ProdutoVendidoController.salvar(produtoVendido);
                        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Produto sem estoque!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
        }
    }

    public static void menuVendaRemoverProdutos() {
        if (!ProdutoVendidoDao.isEmpty()) {
            try {
                ProdutoVendido produtoVendido = (ProdutoVendido) InputUtils.getSelectionInput("Selecione o produto:", ProdutoVendidoDao.getProdutosVendidos().toArray());
                if (produtoVendido == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }

                if (ProdutoVendidoController.excluir(produtoVendido)) {
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto adicionado!");
        }
    }

    public static void menuVendaLimparProdutos() {
        if (!ProdutoVendidoDao.isEmpty()) {
            ProdutoVendidoController.limpar();
            JOptionPane.showMessageDialog(null, "Produtos removidos com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto adicionado!");
        }
    }

    public static void menuVendaListarProdutos() {
        if (!ProdutoVendidoDao.isEmpty()) {
            try {
                ProdutoVendido produtoVendido = (ProdutoVendido) InputUtils.getSelectionInput("Selecione o produto:", ProdutoVendidoDao.getProdutosVendidos().toArray());
                if (produtoVendido == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }
                JOptionPane.showMessageDialog(null, ProdutoVendidoController.toString(produtoVendido));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto adicionado!");
        }
    }

    public static void menuVendaFinalizar() {
        if (!ProdutoVendidoDao.isEmpty() && !VendedorDao.isEmpty()) {
            try {
                Cliente cliente = new Cliente();
                Venda venda = new Venda();

                Vendedor vendedor = (Vendedor) InputUtils.getSelectionInput("Selecione o vendedor", VendedorDao.getVendedores().toArray());
                if (vendedor == null) {
                    throw new IllegalArgumentException("Erro na seleção do vendedor!");
                }
                venda.setVendedor(vendedor);

                String cpf = InputUtils.getStringInput("Cpf do cliente");
                if (cpf == null || cpf.isEmpty()) {
                    throw new IllegalArgumentException("Cpf inválido!");
                }
                if (ClienteController.verificarCpf(cpf)) {
                    venda.setCliente(ClienteController.buscarClientes(cpf));
                } else if (VendedorController.verificarCpf(cpf)) {
                    Vendedor vendedorCliente = VendedorController.buscarVendedor(cpf);
                    String cpfV = vendedorCliente.getCpf();
                    cliente.setCpf(cpfV);
                    String nomeV = vendedorCliente.getNome();
                    cliente.setNome(nomeV);

                    String telefone = InputUtils.getStringInput("Telefone do cliente (vendedor)");
                    if (telefone == null || telefone.isEmpty()) {
                        throw new IllegalArgumentException("Telefone inválido!");
                    }
                    cliente.setTelefone(telefone);

                    String email = InputUtils.getStringInput("Email do cliente (vendedor)");
                    if (email == null || email.isEmpty()) {
                        throw new IllegalArgumentException("Email inválido!");
                    }
                    cliente.setEmail(email);

                    venda.setCliente(cliente);
                    ClienteController.salvar(cliente);
                } else {
                    cliente.setCpf(cpf);

                    String nome = InputUtils.getStringInput("Nome do cliente");
                    if (nome == null || nome.isEmpty()) {
                        throw new IllegalArgumentException("Nome inválido!");
                    }
                    cliente.setNome(nome);

                    String telefone = InputUtils.getStringInput("Telefone do cliente");
                    if (telefone == null || telefone.isEmpty()) {
                        throw new IllegalArgumentException("Telefone inválido!");
                    }
                    cliente.setTelefone(telefone);

                    String email = InputUtils.getStringInput("Email do cliente");
                    if (email == null || email.isEmpty()) {
                        throw new IllegalArgumentException("Email inválido!");
                    }
                    cliente.setEmail(email);

                    venda.setCliente(cliente);
                    ClienteController.salvar(cliente);
                }

                venda.setData(new Date());
                venda.setProdutosVendidos(new LinkedList<>(ProdutoVendidoDao.getProdutosVendidos()));
                if (VendaController.salvar(venda)) {
                    ProdutoVendidoController.atualizarEstoque();
                    JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                    for (ProdutoVendido prodV : venda.getProdutosVendidos()) {
                        if (EstoqueController.emitirAlertaZero(prodV.getProduto())) {
                            JOptionPane.showMessageDialog(null, "AVISO! " + prodV.getProduto().getNome() + " ficou sem estoque!");
                        } else if (EstoqueController.emitirAlerta(prodV.getProduto())) {
                            JOptionPane.showMessageDialog(null, "AVISO! " + prodV.getProduto().getNome() + " ficou com o estoque abaixo da quantidade mínima!");
                        }
                    }
                    ProdutoVendidoController.limpar();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            if (ProdutoVendidoDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto adicionado!");
            }
            if (VendedorDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado!");
            }
        }
    }

    public static void menuVendaListar() {
        if (!VendaDao.isEmpty()) {
            try {
                Venda venda = (Venda) InputUtils.getSelectionInput("Selecione a venda", VendaDao.getVendas().toArray());
                if (venda == null) {
                    throw new IllegalArgumentException("Erro na seleção da venda!");
                }
                JOptionPane.showMessageDialog(null, VendaController.toString(venda));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido! Por favor, digite um número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma venda realizada!");
        }
    }

    public static void menuEstoque() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Estoque" +
                    "\n1 - Abastecer Estoque" +
                    "\n2 - Listar Todos os Produtos" +
                    "\n3 - Listar Produtos Abaixo do Estoque Minimo" +
                    "\n4 - Listar Produtos por Categoria" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuEstoqueAbastecer();
                    break;
                case 2:
                    menuEstoqueListar();
                    break;
                case 3:
                    menuEstoqueListarAbaixo();
                    break;
                case 4:
                    menuEstoqueListarCategoria();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuEstoqueAbastecer() {
        if(!ProdutoDao.isEmpty()) {
            try {
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.getProdutos().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }

                Integer quant = InputUtils.getIntegerInput("Informe a quantidade");
                if (quant == null || quant <= 0) {
                    throw new IllegalArgumentException("Quantidade invalida!");
                }
                if (EstoqueController.adicionarQuantidade(quant, prod)) {
                    JOptionPane.showMessageDialog(null, "Estoque abastecido com sucesso!");
                    Registro registro = new Registro(prod, "Entrada", quant, new Date());
                    RegistroController.salvar(registro);
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
        }
    }

    public static void menuEstoqueListar() {
        menuListarProdutos();
    }

    public static void menuEstoqueListarAbaixo() {
        if (!ProdutoDao.isEmpty() && !ProdutoDao.produtosAbaixoEstoqueMin().isEmpty()) {
            try {
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.produtosAbaixoEstoqueMin().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }
                JOptionPane.showMessageDialog(null, ProdutoController.toString(prod));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            if (ProdutoDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
            } else if (ProdutoDao.produtosAbaixoEstoqueMin().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto abaixo do estoque minimo!");
            }
        }
    }

    public static void menuEstoqueListarCategoria() {
        if (!CategoriaDao.isEmpty() || !ProdutoDao.isEmpty()) {
            try {
                Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria", CategoriaDao.getCategorias().toArray());
                if (cat == null) {
                    throw new IllegalArgumentException("Erro na seleção de categoria!");
                }

                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.produtosPorCategoria(cat).toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }

                JOptionPane.showMessageDialog(null, ProdutoController.toString(prod));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            if (!CategoriaDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada!");
            } else if (ProdutoDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
            }
        }
    }

    public static void menuRelatorios() {
        Integer opt3 = 0;
        do {
            String input = InputUtils.getStringInput("Relatorios e Visualização" +
                    "\n1 - Relatorio de Estoque" +
                    "\n2 - Relatorio de Vendas" +
                    "\n0 - Voltar");
            if (input == null) {
                opt3 = 0;
                break;
            }
            try {
                opt3 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt3 = -1;
            }
            switch (opt3) {
                case 0:
                    break;
                case 1:
                    menuRelatoriosEstoque();
                    break;
                case 2:
                    menuRelatoriosVendas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt3 != 0);
    }

    public static void menuRelatoriosEstoque() {
        Integer opt4 = 0;
        do {
            String input = InputUtils.getStringInput("Relatorios de Estoque" +
                    "\n1 - Relatorio por Produto" +
                    "\n2 - Relatorio por Categoria" +
                    "\n3 - Relatorio por Data" +
                    "\n0 - Voltar");
            if (input == null) {
                opt4 = 0;
                break;
            }
            try {
                opt4 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt4 = -1;
            }
            switch (opt4) {
                case 0:
                    break;
                case 1:
                    menuRelatoriosEstoqueProduto();
                    break;
                case 2:
                    menuRelatoriosEstoqueCategoria();
                    break;
                case 3:
                    menuRelatoriosEstoqueData();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt4 != 0);
    }

    public static void menuRelatoriosVendas() {
        Integer opt4 = 0;
        do {
            String input = InputUtils.getStringInput("Relatorios de Vendas" +
                    "\n1 - Relatorio por Produto" +
                    "\n2 - Relatorio por Categoria" +
                    "\n3 - Relatorio por Data" +
                    "\n4 - Relatorio por Volume de Vendas" +
                    "\n0 - Voltar");
            if (input == null) {
                opt4 = 0;
                break;
            }
            try {
                opt4 = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                opt4 = -1;
            }
            switch (opt4) {
                case 0:
                    break;
                case 1:
                    menuRelatoriosVendaProduto();
                    break;
                case 2:
                    menuRelatoriosVendaCategoria();
                    break;
                case 3:
                    menuRelatoriosVendaData();
                    break;
                case 4:
                    menuRelatoriosVendaVolume();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    break;
            }
        } while (opt4 != 0);
    }

    public static void menuRelatoriosEstoqueProduto() {
        if(!ProdutoDao.isEmpty()) {
            try {
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.getProdutos().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }

                System.out.println("\nRelatório por Produto (" + prod.getNome() + ")");
                if (EstoqueController.emitirAlertaZero(prod)) {
                    System.out.println(ProdutoController.toString(prod) + "\n (Produto sem estoque)");
                } else if (EstoqueController.emitirAlerta(prod)) {
                    System.out.println(ProdutoController.toString(prod) + "\n (Produto com estoque baixo)");
                } else {
                    System.out.println(ProdutoController.toStringRelatorio(prod));
                }

                JOptionPane.showMessageDialog(null, "Relatório gerado!");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
        }
    }

    public static void menuRelatoriosEstoqueCategoria() {
        if (!CategoriaDao.isEmpty() || !ProdutoDao.isEmpty()) {
            try {
                Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria", CategoriaDao.getCategorias().toArray());
                if (cat == null) {
                    throw new IllegalArgumentException("Erro na seleção de categoria!");
                }

                if (!ProdutoDao.produtosPorCategoria(cat).isEmpty()) {
                    System.out.println("\nRelatório por Categoria (" + cat + ")");
                    for (Produto prod : ProdutoDao.produtosPorCategoria(cat)) {
                        System.out.println(ProdutoController.toStringRelatorio(prod));
                        if (EstoqueController.emitirAlertaZero(prod)) {
                            System.out.println(" - Produto sem estoque!");
                        } else if (EstoqueController.emitirAlerta(prod)) {
                            System.out.println(" - Produto com estoque baixo!");
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Relatório gerado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
                }

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            if (!CategoriaDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada!");
            } else if (ProdutoDao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
            }
        }
    }

    public static void menuRelatoriosEstoqueData() {
        if(!ProdutoDao.isEmpty()) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                formato.setLenient(false);

                String stringDataInicial =  InputUtils.getStringInput("Informe a Data Inicial (dd/MM/yyyy)");
                if (stringDataInicial == null || stringDataInicial.isEmpty()) {
                    throw new IllegalArgumentException("Data inválida!");
                }
                Date dataInicial = formato.parse(stringDataInicial);
                dataInicial = RegistroController.zerarHoras(dataInicial);

                String stringDataFinal =  InputUtils.getStringInput("Informe a Data Final (dd/MM/yyyy)");
                if (stringDataFinal == null || stringDataFinal.isEmpty()) {
                    throw new IllegalArgumentException("Data inválida!");
                }
                Date dataFinal = formato.parse(stringDataFinal);
                dataFinal = RegistroController.zerarHoras(dataFinal);

                if (RegistroController.periodoValido(dataInicial, dataFinal)) {
                    List<Registro> registros = RegistroDao.registrosPorPeriodo(dataInicial, dataFinal);
                    if (registros != null && !registros.isEmpty()) {
                        System.out.println("\nRelatório por Data (" + stringDataInicial + " - " + stringDataFinal + ")");
                        for (Registro reg : registros) {
                            System.out.println(RegistroController.toString(reg));
                        }
                        JOptionPane.showMessageDialog(null, "Relatório gerado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado no período!");
                    }
                } else {
                    throw new IllegalArgumentException("Período inválido!");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
        }
    }

    public static void menuRelatoriosVendaProduto() {
        if (!VendaDao.isEmpty()) {
            try {
                Produto prod = (Produto) InputUtils.getSelectionInput("Selecione o produto:", ProdutoDao.getProdutos().toArray());
                if (prod == null) {
                    throw new IllegalArgumentException("Erro na seleção de produto!");
                }

                List<Venda> vendasPorProd = VendaDao.vendasPorProduto(prod);
                if (vendasPorProd != null) {
                    System.out.println("\nRelatório por Produto (" + prod.getNome() + ")");
                    for (Venda venda : vendasPorProd) {
                        System.out.println(VendaController.toStringRelatorio(venda));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada!");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada!");
        }
    }

    public static void menuRelatoriosVendaCategoria() {
        if (!CategoriaDao.isEmpty()) {
            try {
                Categoria cat = (Categoria) InputUtils.getSelectionInput("Selecione a categoria:", CategoriaDao.getCategorias().toArray());
                if (cat == null) {
                    throw new IllegalArgumentException("Erro na seleção da categoria!");
                }

                List<Venda> vendasPorCat = VendaDao.vendasPorCategoria(cat);
                if (vendasPorCat != null) {
                    System.out.println("\nRelatório por Categoria (" + cat.getNome() + ")");
                    for (Venda venda : vendasPorCat) {
                        System.out.println(VendaController.toStringRelatorio(venda));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada!");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada!");
        }
    }

    public static void menuRelatoriosVendaData() {
        if (!VendaDao.isEmpty()) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                formato.setLenient(false);

                String stringDataInicial =  InputUtils.getStringInput("Informe a Data Inicial (dd/MM/yyyy)");
                if (stringDataInicial == null || stringDataInicial.isEmpty()) {
                    throw new IllegalArgumentException("Data inválida!");
                }
                Date dataInicial = formato.parse(stringDataInicial);
                dataInicial = VendaController.zerarHoras(dataInicial);

                String stringDataFinal =  InputUtils.getStringInput("Informe a Data Final (dd/MM/yyyy)");
                if (stringDataFinal == null || stringDataFinal.isEmpty()) {
                    throw new IllegalArgumentException("Data inválida!");
                }
                Date dataFinal = formato.parse(stringDataFinal);
                dataFinal = VendaController.zerarHoras(dataFinal);

                if (VendaController.periodoValido(dataInicial, dataFinal)) {
                    List<Venda> vendasPeriodo = VendaDao.vendasPorPeriodo(dataInicial, dataFinal);
                    if (vendasPeriodo != null && !vendasPeriodo.isEmpty()) {
                        System.out.println("\nRelatório por Data (" + stringDataInicial + " - " + stringDataFinal + ")");
                        for (Venda v : vendasPeriodo) {
                            System.out.println(VendaController.toStringRelatorio(v));
                        }
                        JOptionPane.showMessageDialog(null, "Relatório gerado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada no período!");
                    }
                } else {
                    throw new IllegalArgumentException("Período inválido!");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada!");
        }
    }

    public static void menuRelatoriosVendaVolume() {
        if (!VendaDao.isEmpty()) {
            try {
                if (!RegistroDao.isEmpty()) {
                    System.out.println("\nRelatório por Volume de Venda");
                    List<Registro> prodOrdenados = RegistroDao.agruparOrdenarRegistros();
                    if (!prodOrdenados.isEmpty()) {
                        int posicao = 1;
                        for (Registro reg : prodOrdenados) {
                            System.out.println("#" + posicao++ + " - " + RegistroController.toStringVolume(reg));
                        }
                        JOptionPane.showMessageDialog(null, "Relatório gerado!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada!");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada!");
        }
    }
}