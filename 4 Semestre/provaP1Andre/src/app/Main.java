package app;

import entities.Midia;
import entities.Musica;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        List <Midia>musicas = new LinkedList();
        Boolean run = true;
        do {
            Integer option = Integer.valueOf(JOptionPane.showInputDialog(null, "\nMENU"
                    + "\n1 - Adicionar musica"
                    + "\n2 - Reproduzir musica"
                    + "\n0 - Sair")
            );
            switch(option){
                case 0:
                    run = false;
                    JOptionPane.showMessageDialog(null, "Finalizando...");
                    break;
                case 1:
                    Midia musica = new Musica();
                    musica.setNome(JOptionPane.showInputDialog(null, "Informe o nome da musica: "));
                    musica.setDuracao(Integer.valueOf(JOptionPane.showInputDialog(null, "Informe a duracao: ")));
                    ((Musica)musica).setArtista(JOptionPane.showInputDialog(null, "Informe o artista: "));
                    musicas.add(musica);
                    break;
                case 2:
                    if(musicas.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhuma musica na playlist!");
                        break;
                    } else {
                        Integer i = 0;
                        JOptionPane.showMessageDialog(null, "Listagem das musicas: ");
                        for(Midia m : musicas){
                                JOptionPane.showMessageDialog(null, m.listar() + "\nIndex: " + i++);
                            }
                        Integer numMusica = Integer.valueOf(JOptionPane.showInputDialog(null, "Informe o index da musica para reproduzir: "));
                        if(musicas.contains(numMusica)){
                            JOptionPane.showMessageDialog(null, musicas.get(numMusica).reproduzir());
                        } else {
                            JOptionPane.showMessageDialog(null, "Musica não encontrada!");
                        }
                    }
                    break;
                default:
                        JOptionPane.showMessageDialog(null, "Opcao Invalida!");
                    break;
            }
        } while(run);
    }
}
