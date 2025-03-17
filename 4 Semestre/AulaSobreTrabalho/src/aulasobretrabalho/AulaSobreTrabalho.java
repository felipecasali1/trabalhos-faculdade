package aulasobretrabalho;

import controller.ProdutoController;
import javax.swing.JOptionPane;

public class AulaSobreTrabalho {

    public static void main(String[] args) {

           String nome= JOptionPane.showInputDialog("Entre com nome");
           ProdutoController controller = new ProdutoController();
        try {
            controller.salvar(nome);
        } catch (Exception ex) {
            JOptionPane.showInputDialog(ex.getMessage());
        }

    }
    
}
