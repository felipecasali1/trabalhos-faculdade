package persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class GerenciadorArquivos {    
    
    public static void escreverObjetos(List pessoas) throws IOException {
        File arq = new File("dadosPessoa.txt");
        if(!arq.exists()) {
            arq.createNewFile();
        }
        FileOutputStream fileOutStream = new FileOutputStream(arq);
        ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream);
        
        for(Object pessoa : pessoas) {
            objOutStream.writeObject(pessoa);
        }
        
        objOutStream.close();
    }
}
