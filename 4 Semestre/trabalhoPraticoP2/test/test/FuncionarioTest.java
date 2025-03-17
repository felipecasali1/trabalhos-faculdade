package test;

import entities.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;

public class FuncionarioTest {

    @Test
    public void testSituacaoAtivo() {
        Funcionario funcionario = new Funcionario("Alex", "Farmaceutico", 3000.00D, "2023-01-01", "");
        assertEquals("Ativo", funcionario.getSituacao());
    }

    @Test
    public void testSituacaoDemitido() {
        Funcionario funcionario = new Funcionario("Bruna", "Cozinha", 3000.00D, "2020-05-10", "2023-06-15");
        assertEquals("Demitido", funcionario.getSituacao());
    }

    @Test
    public void testCalcularSalarioLiquidoSemImposto() {
        Funcionario funcionario = new Funcionario("Lucas", "Contábil", 1900.00D, "2022-06-11", "");
        assertEquals(1900.00D, funcionario.calcularSalarioLiquido(), 0.001);
    }

    @Test
    public void testCalcularSalarioLiquido7() {
        Funcionario funcionario = new Funcionario("Ana Julia", "Financeiro", 2800.00D, "2021-01-01", "");
        assertEquals(2590.00D, funcionario.calcularSalarioLiquido(), 0.001);
    }

    @Test
    public void testCalcularSalarioLiquido15() {
        Funcionario funcionario = new Funcionario("José", "Caixa", 3750.00D, "2022-01-01", "");
        assertEquals(3187.50D, funcionario.calcularSalarioLiquido(), 0.001);
    }

    @Test
    public void testCalcularSalarioLiquido22() {
        Funcionario funcionario = new Funcionario("Letícia", "Suporte", 4650.00D, "2020-10-15", "");
        assertEquals(3603.75D, funcionario.calcularSalarioLiquido(), 0.001);
    }

    @Test
    public void testCalcularSalarioLiquido27() {
        Funcionario funcionario = new Funcionario("Luís", "RH", 5000.00D, "2021-03-10", "2023-06-25");
        assertEquals(3625.00D, funcionario.calcularSalarioLiquido(), 0.001);
    }
}

