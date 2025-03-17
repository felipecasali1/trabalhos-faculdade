package app;

import entities.Funcionario;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa de Gestão de RH\n");
        
        Funcionario funcionario = new Funcionario("Felipe", "Engenharia de Software", 3000D, "2023-03-26", "");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Setor: " + funcionario.getSetor());
        System.out.println("Salário Bruto: R$" + funcionario.getSalarioBruto());
        System.out.println("Situação: " + funcionario.getSituacao());
        System.out.println("Salário Líquido: R$" + funcionario.calcularSalarioLiquido());
        
        System.out.println("");
        
        Funcionario funcionario2 = new Funcionario("Bruna", "Psicologia", 2000D, "2022-03-26", "2023-06-13");
        System.out.println("Nome: " + funcionario2.getNome());
        System.out.println("Setor: " + funcionario2.getSetor());
        System.out.println("Salário Bruto: R$" + funcionario2.getSalarioBruto());
        System.out.println("Situação: " + funcionario2.getSituacao());
        System.out.println("Salário Líquido: R$" + funcionario2.calcularSalarioLiquido());
    }
}
