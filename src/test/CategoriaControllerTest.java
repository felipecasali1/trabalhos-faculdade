package test;

import main.controller.CategoriaController;
import main.models.Categoria;
import main.persistence.CategoriaDao;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoriaControllerTest {
    @Test
    public void testSalvarCategoria() {
        Categoria categoria = new Categoria("Categoria 1", 1);
        assertTrue(CategoriaController.salvar(categoria));
        assertFalse(CategoriaController.salvar(null));
    }

    @Test
    public void testExcluirCategoria() {
        Categoria categoria = new Categoria("Categoria 1", 1);
        assertTrue(CategoriaController.excluir(categoria));
        assertFalse(CategoriaController.excluir(null));
    }

    @Test
    public void testEditarCategoria() {
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria categoria2 = new Categoria("Categoria 2", 2);
        CategoriaController.salvar(categoria);
        assertTrue(CategoriaController.editar(1, categoria2));
        assertEquals(CategoriaDao.getCategorias().getFirst().getNome(), categoria2.getNome());
        assertFalse(CategoriaController.editar(10, categoria));
    }

    @Test
    public void testVerificarCodigoCategoria() {
        assertFalse(CategoriaController.verificarCodigo(null));
        Categoria categoria = new Categoria("Categoria 1", 1);
        CategoriaController.salvar(categoria);
        assertTrue(CategoriaController.verificarCodigo(1));
        assertFalse(CategoriaController.verificarCodigo(0));
    }

    @Test
    public void testToString() {
        Categoria categoria = new Categoria("Categoria 1", 1);
        assertNotNull(CategoriaController.toString(categoria));
        assertNull(CategoriaController.toString(null));
    }
}
