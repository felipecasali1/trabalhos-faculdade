package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorArquivos {    
    
    public static void escreverObjetos(List pessoas) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("dadosPessoa.txt"));
            output.writeObject(pessoas);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Object lerObjetos() {
        Object obj = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("dadosPessoa.txt"));
            obj = input.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, "Arquivo não encontrado!", ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, "Erro na leitura!", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
}
