package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {
    public static void save(File file, String text) {
        try {
            try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
                System.out.println(text);
                output.write(text);
            }
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
