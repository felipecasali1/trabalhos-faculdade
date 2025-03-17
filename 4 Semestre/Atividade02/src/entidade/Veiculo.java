package entidade;
import app.Menu;

public class Veiculo {
    public String modelo;
    public String marca;
    public String categoria;
    public int ano;
    public float valor;
    
    public Veiculo(){
        modelo = "Não Informado!";
        marca = "Não Informado!";
        categoria = "Não Informado!";
        ano = 0;
        valor = 0;
    }
    
    public Veiculo(String modelo, String marca, String categoria, int ano, float valor){
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.ano = ano;
        this.valor = valor;
    }
    
    public void showAll(){
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Categoria: " + categoria);
        System.out.println("Ano: " + ano);
        System.out.println("Valor: R$" + valor);
    }
}
