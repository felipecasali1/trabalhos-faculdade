package controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arquivo;

public class ArquivoController {
    public static void save(File file, String text) {
        if (!file.getName().toLowerCase().endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ArquivoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Arquivo.save(file, text);
    }
}
