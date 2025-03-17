package entities;

public class Produto {
    private String nome;
    private Marca marca;
    private Usuario usuario;

    @Override
    public String toString() {
        return "\nProduto: " + getNome() +
               "\nMarca: " + marca.getNome() +
               "\nCadastro por: " + usuario.getNome();
    }
    
    public Produto(){
        this.nome = "";
        this.marca = new Marca();
        this.usuario = new Usuario();
    }
    
    public Produto(String nome, Usuario usuario, Marca marca) {
        this.nome = nome;
        this.marca = marca;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
