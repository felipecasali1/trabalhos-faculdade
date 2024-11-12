package test;

import main.controller.ClienteController;
import main.models.Cliente;
import main.persistence.ClienteDao;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteControllerTest {
    @Test
    public void testSalvarCliente() {
        Cliente cliente = new Cliente("Felipe", "123.123.123-12", "6790000-0000", "testesunitarios@email.com");
        assertTrue(ClienteController.salvar(cliente));
        assertFalse(ClienteController.salvar(null));
    }

    @Test
    public void testExcluirCategoria() {
        Cliente cliente = new Cliente("Felipe", "123.123.123-12", "6790000-0000", "testesunitarios@email.com");
        assertTrue(ClienteController.excluir(cliente));
        assertFalse(ClienteController.excluir(null));
    }

    @Test
    public void testEditarCategoria() {
        Cliente cliente = new Cliente("Felipe", "123.123.123-12", "6790000-0000", "testesunitarios@email.com");
        Cliente cliente2 = new Cliente("Sergio", "321.321.321-32", "6791111-1111", "tunitarios@email.com");
        ClienteController.salvar(cliente);
        assertTrue(ClienteController.editar("123.123.123-12", cliente2));
        assertEquals(ClienteDao.getClientes().getFirst().getNome(), cliente2.getNome());
        assertNotEquals(ClienteDao.getClientes().getFirst().getCpf(), cliente2.getCpf());
        assertFalse(ClienteController.editar("111.111.111-11", cliente));
    }

    @Test
    public void testVerificarCpf() {
        assertFalse(ClienteController.verificarCpf(null));
        Cliente cliente = new Cliente("Felipe", "123.123.123-12", "6790000-0000", "testesunitarios@email.com");
        ClienteController.salvar(cliente);
        assertTrue(ClienteController.verificarCpf("123.123.123-12"));
        assertFalse(ClienteController.verificarCpf("000.000.000-00"));
    }

    @Test
    public void testToString() {
        Cliente cliente = new Cliente("Felipe", "123.123.123-12", "6790000-0000", "testesunitarios@email.com");
        assertNotNull(ClienteController.toString(cliente));
        assertNull(ClienteController.toString(null));
    }
}