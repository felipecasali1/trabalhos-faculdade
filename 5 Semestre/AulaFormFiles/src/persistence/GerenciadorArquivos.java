package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Pessoa;

public class GerenciadorArquivos {
    private static final String PESSOA_FILE_NAME = "dadosPessoa.txt";
    
    public static void escreverObjetos(List<Pessoa> pessoas) {
        try {
            File file = new File(PESSOA_FILE_NAME);
            if (!file.exists() || file.length() == 0) {
                file.createNewFile();
            }
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
                output.writeObject(pessoas);
            }
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Pessoa> lerObjetos() {
        List<Pessoa> lista = null;
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(PESSOA_FILE_NAME))) {
                lista = (List<Pessoa>) input.readObject();
                if (lista instanceof List<?>) {
                    return lista;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, "Arquivo não encontrado!", ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, "Erro na leitura!", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LinkedList<>();
    }
    
    public static boolean fileExist() {
        File file = new File(PESSOA_FILE_NAME);
        return file.exists();
    }
}
